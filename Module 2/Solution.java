
import java.util.Scanner;

public class Solution {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		/*String filename=sc.next();
		File file=new File(filename);
		FileInputStream fin=new FileInputStream(file);*/
		
		System.out.println("Enter the 'N' value:");
		int N=sc.nextInt();
		Percolation per=new Percolation(N);
		while(sc.hasNext())
		{
			int row=sc.nextInt();
			int col=sc.nextInt();
			per.open(row, col);
			
		}
		per.percolates();
}
}
