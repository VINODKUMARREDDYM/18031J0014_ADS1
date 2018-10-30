import java.util.Scanner;

public class Solution {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int[] a=new int[Integer.parseInt(s)];
		int i=0,j=1;
		while(sc.hasNext())
		{
			a[i]=Integer.parseInt(sc.nextLine());
			i++;
			//.out.println(i);
			if(i==a.length)break;
		}
		for(int k=0;k<a.length;k++)
		{
			//System.out.println("      1         ");
			int c[]=new int[j];
			int d[]=new int[j];
			for(int l=0;l<j;l++)
			{
				c[l]=a[l];
				d[l]=a[l];
			}
			HeapSort H=new HeapSort();
			H.sort(c, d);
			//System.out.println(c);
			j++;
		}
	}
}
class HeapSort 
{ 
    public void sort(int arr[],int ar[]) 
    { 
 //   	System.out.println(" 2 2");
 //   	display(arr);
        int n = arr.length; 
//        System.out.println(arr);
//        System.out.println("********8"+n);
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i);
        
       // display(arr);
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify1(ar, n, i);
        
        //display(ar);
        // One by one extract an element from heap 
        int prevTemp =0;
        int prevTemp1 =0;
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp;
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
            
            //display(arr);
            
            int temp1 = ar[0]; 
            ar[0] = ar[i]; 
            ar[i] = temp1;
            heapify1(ar, i, 0);
           // System.out.println(temp1+" , "+temp);
            if(temp1==temp)
            	{
            	float f=(float)temp;
            	System.out.println(f);
            	break;
            	}
            if(temp==prevTemp1&&prevTemp==temp1)
            {
            	float f=(float)(temp+temp1)/2;
            	System.out.println(f);
            	break;
            }
            prevTemp = temp;
            prevTemp1 = temp1;
        } 
    } 
  
    void display(int a[]){
    	for(int k=0;k<a.length;k++)
		{
    		System.out.print(a[k]+" ");
		}
    	System.out.println();
    	
    }
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    }
    void heapify1(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] < arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] < arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify1(arr, n, largest); 
        } 
	}

}
