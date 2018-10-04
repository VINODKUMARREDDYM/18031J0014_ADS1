import java.util.Scanner;

public class Percolation {
	 private boolean[][] sites;
	 //private boolean[][] grid;
	 //private gridSize;
	 int row,col,N;
	 private WeightedQuickUnion WQU; 
	 Scanner sc;
	 
	 	public Percolation(int n)
		{
			N=n;
			sites=new boolean[N][N];
			WQU =new WeightedQuickUnion(N*N);
			for(int i = 0; i < N; i++)
	        {
	            for(int j = 0; j < N; j++)
	            {
	                sites[i][j] = false;
	            }
	        }
			
		}
		public void open(int row,int col)
		{
			 	int i = row-1;
		        int j = col-1;
		        sites[i][j] = true;
		        if (i-1 >=0  && isOpen(row - 1, col))
		        {
		        	WQU.union(to2D(row,col),to2D(row-1,col));
		        }
		        if (i+1 < sites.length  && isOpen(row + 1, col))         
		        {
		        	WQU.union(to2D(row,col),to2D(row+1,col));
		        }
		        if (j-1 >= 0 && isOpen(row, col-1))     //up
		        {
		        	WQU.union(to2D(row,col),to2D(row,col-1));
		        }
		        if (j+1 < sites.length&& isOpen(row, col+1))     //down
		        {
		        	WQU.union(to2D(row,col),to2D(row,col+1));
		        }
		}
		public boolean isOpen(int row,int col)
		{
			 this.row=row-1;
			 this.col=col-1;
			 for(int i=0;i<N;i++)
			 {
				 for(int j=0;j<N;j++)
				 {
					 if(sites[row][col]==true)
						 return true;
				 }
				// System.out.println(" ");
			 }
			 return false;
		}
		public boolean isFull(int row,int col)
		{
			if(isOpen(row,col))
	        {
	            for(int k = 0; k < sites.length; k++)
	            {

	               if(WQU.find(to2D(row,col),k)) return true;
	            }
	        }
	        return false;
		}
		/*public int numberOfopenSites()
		{
			
		}*/
		public boolean percolates()
		{
			if (sites.length == 1)
	        {
	            if (isOpen(1,1))
	            {
	                return true;
	            }
	            return false;
	        }
	        if(sites.length == 2)
	        {
	            if (WQU.find(0,3)) return true;
	            if (WQU.find(1,2)) return true;
	            if (WQU.find(0,2)) return true;
	            if (WQU.find(1,3)) return true;
	            return false;
	        }


	        for (int i = (sites.length* (sites.length - 1))-1; i < (sites.length *sites.length); i++)
	        {
	           // System.out.println((gridSize * (gridSize - 1))-1);
	            //System.out.println(gridSize * gridSize-1);
	            for (int i2 = 0; i2 < sites.length; i2++)
	            {
	                //System.out.println(i);
	                //System.out.println(i2);
	                //System.out.print(wqf.connected(i, i2));
	                if (WQU.find(i, i2)) return true;

	            }
	        }
	        return false;
	    }
	    private int to2D(int i, int j)
	    {
	        return (i-1)*sites.length+(j-1);
	    }
}
