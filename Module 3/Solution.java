import java.util.Scanner;

public class Solution{
	static int printUnion(int arr1[], int arr2[], int m, int n) 
    { 
      int i = 0, j = 0; 
	int arr3[] 
      while (i < m && j < n) 
      { 
        if (arr1[i] < arr2[j]) 	
		{
          	System.out.print(arr1[i++]+",");
			//if(i<m)
		//System.out.print();
		} 
        else if (arr2[j] < arr1[i]) {
        	  System.out.print(arr2[j++]+","); 
			//if(j<n)
		  //System.out.print(",");
		  }
        else
        { 
          System.out.print(arr2[j++]+","); 
          i++; 
        } 
      } 
       
      
      while(i < m) 
       System.out.print(arr1[i++]+","); 
      while(j < n) 
       System.out.print(arr2[j++]+","); 
         
      return 0;    
    } 
      
    public static void main(String args[]) 
    { 
        /*int arr1[] = {1, 2, 4, 5, 6}; 
        int arr2[] = {2, 3, 5, 7}; 
        int m = arr1.length; 
        int n = arr2.length; 
        printUnion(arr1, arr2, m, n); */
    	Scanner scan=new Scanner(System.in);
    	
    	int m=scan.nextInt();
    	int n=scan.nextInt();
    	String s=scan.next();
    	String[ ] a=s.split(",");
    	
    	int[ ]b=new int[m];
    	for(int i=0;i<m;i++)
    	{
    		b[i]=Integer.parseInt(a[i]);
    	}
    	String s1=scan.next();
    	String[ ]c=s1.split(",");
    	int[]d=new int[n];
    	for(int j=0;j<n;j++)
    	{
    		d[j]=Integer.parseInt(c[j]);
    	}
    	printUnion(b,d,m,n);
    } 
} 


