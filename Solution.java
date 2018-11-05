import java.util.ArrayList;
import java.util.Scanner;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


class MinPQ<Key> implements Iterable<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    public MinPQ() {
        this(1);
    }
    public MinPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    public MinPQ(Comparator<Key> comparator) {
        this(1, comparator);
    } 
    public MinPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMinHeap();
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    public void insert(Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }
    
    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }
    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..N] a min heap?
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
         private MinPQ<Key> copy;
        public HeapIterator() {
            if (comparator == null) copy = new MinPQ<Key>(size());
            else                    copy = new MinPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
    
}
public class Solution implements Comparable<Solution>{
	private final int sum;
	private final int i;
	private final int j;
	
	public Solution(int i,int j)
	{
		this.sum=i*i*i+j*j*j;
		this.i=i;
		this.j=j;
	}
	@Override
	public int compareTo(Solution that) {
		// TODO Auto-generated method stub
		if(this.sum<that.sum)
			return -1;
		if(this.sum>that.sum)
			return 1;
		return 0;
	}
	public int getSum()
    {
    	return sum;
    }
	public String toString()
	{
		String s=""+sum;
		
		return s;//+"="+i+"^3"+"+"+j+"3";
	}
	public static void main(String args[])
	{
		int n = 900;
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
        	String sa=sc.nextLine();
        	String[] b=sa.split(" ");
        
        int o=Integer.parseInt(b[0]);
        int m=Integer.parseInt(b[1]);
        int count=0;
        int temp=3;
        // initialize priority queue
        MinPQ<Solution> pq = new MinPQ<Solution>();
        for (int i = 0; i <= n; i++) {
        	//System.out.println();
            pq.insert(new Solution(i, i));
        }

        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
        	Solution s = pq.delMin();
            if (temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == m - 1) {
                o--;
                if (o == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            temp = s.getSum();
            if (s.j < n) {
                pq.insert(new Solution(s.i, s.j + 1));
            }
    }
    }
    }
}
