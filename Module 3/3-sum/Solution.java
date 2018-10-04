import java.util.Arrays;
import java.util.Scanner;

public class Solution{
	public static boolean containsDuplicates(int[] arr) 
	{
        for (int i = 1; i < arr.length; i++)
            if (arr[i] == arr[i-1]) return true;
        return false;
    }
	public static void printAll(int[] arr) 
	{
        int n = arr.length;
        Arrays.sort(arr);
        if (containsDuplicates(arr)) throw new IllegalArgumentException("array contains duplicate integers");
        for (int i = 0; i < n; i++) 
        {
            for (int j = i+1; j < n; j++) 
            {
                int k = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
                if (k > j) System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
            }
        }
    } 
	 public static int count(int[] arr) {
	        int n = arr.length;
	        Arrays.sort(arr);
	        if (containsDuplicates(arr)) throw new IllegalArgumentException("array contains duplicate integers");
	        int count = 0;
	        for (int i = 0; i < n; i++) {
	            for (int j = i+1; j < n; j++) {
	                int k = Arrays.binarySearch(arr, -(arr[i] + arr[j]));
	                if (k > j) 
	                {
	                	count=count+1;
	                }
	                	
	            }
	        }
	        return count;
	    } 
	 public static void main(String[] args)  
	 { 
		int n;
	     Scanner scan = new Scanner (System.in);
		n=scan.nextInt();
	        int[] a = new int[n];
	        for(int i=0;i<n;i++)
	        {
			a[i]=scan.nextInt();
	        }
	        int count = count(a);
			//System.out.print("Number of Three sum number sets are:");
	        System.out.println(count);
	    } 
}
