import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Dequeue
{

	protected List<Integer> deque =new ArrayList<Integer>();
	
	public void insertFront(int item)
	{
        
        deque.add(0,item);
        System.out.println(deque);
    }
	public void insertRear(int item){
        
        deque.add(item);
        System.out.println(deque);
    }
     
    public void removeFront()
    {
        if(deque.isEmpty()){
            System.out.println("Deck is empty");
            return;
        }
        
        int rem = deque.remove(0);        
        System.out.println(deque);
    }
     
    public void removeRear()
    {
        if(deque.isEmpty()){
            System.out.println("Deck is empty");
            return;
        }
           int rem = deque.remove(deque.size()-1);
              System.out.println(deque);
    }
     
    public int peakFront(){
        
        int item = deque.get(0);
          return item;
    }
     
    public int peakRear(){
            int item = deque.get(deque.size()-1);
               return item;
    }
    
    public int Size()
    {
    	return deque.size();
    }
}

public class Solution {
	public static void main(String a[]){
	     
		Dequeue deq = new Dequeue();
	  	Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i;
		String str[]=new String [n+1];
		for( i=0;i<n+1;i++)
		{
			str[i]=sc.nextLine();
		}
		String a1[]=new String[1];
		for( i=0;i<=n;i++)
		{
			a1=str[i].split(" ");
			
			switch(a1[0])
			{
			case "pushLeft" : deq.insertFront(Integer.parseInt(a1[1]));
								break;
								
			case "pushRight":deq.insertRear(Integer.parseInt(a1[1]));	
								
								break;
			case "popRight":deq.removeRear();
							break;
			case "popLeft" :deq.removeFront();
							break;
			case "size" : System.out.println(deq.Size());
						break;
			default :
						break;			
			
			
				
			}
			
		}
		
		
		
	}
}
