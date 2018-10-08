import java.util.Scanner;

class Node
{
	int data;
	Node Next;
	Node(int data)
	{
		this.data=data;
		this.Next=null;
	}
}
class Llist
{
	Node head;
	public void pushFront(int data)
	{
		Node n=new Node(data);
		
		n.Next=head;
		head=n;
	//System.out.println("Node:"+head.data);
		
	}
	
	public int popFront()
	{
		int x;
		if(head==null)
		{
			System.out.println("No Node is there");
			//return x;
		}
		if(head.Next==null)
		{   x=head.data;
			head=null;
			return x;
		}
		else
		{
			Node temp=head;
			x=head.data;
			head =head.Next;
			
			return x;
			}
		
		}
	//public int numberToDigits()
	public void disp() {
		Node tnode=head;
		while(tnode!=null)
		{
			System.out.print(tnode.data);
			tnode=tnode.Next;
		}
		//System.out.println("\n");
	}
	
	}
public class Solution {
public static void main(String args[])
{
	Llist llist ;
	Llist llist1;
	int y;
	Scanner scan=new Scanner(System.in);
	System.out.println("1.LinkedList numberToDigits \n 2.String digitsToNumber \n 3.LinkedList addLargeNumber");
			String x=scan.nextLine();
		switch(x)
		{
		case "numberToDigits":while(scan.hasNext())
								numberToDigits(scan.nextLine());
								
								break;
		case "addLargeNumbers":	
								llist =new Llist();
								llist1=new Llist();
								
								addLargeNumbers(llist,llist1);
							
								break;
		case "digitsToNumber" :while(scan.hasNext())
								digitsToNumber(scan.nextLine());
								break;
		}
	
	
	}


private static void addLargeNumbers(Llist l1,Llist l2) {
	// TODO Auto-generated method stub
	Scanner scan=new Scanner(System.in);
	Llist ll1 =l1;
	Llist ll2=l2;
	Llist l3=new Llist();
	String s=scan.nextLine();
	String s2=scan.nextLine();
	/*int a=s.length();
	System.out.println(a);*/
	int p=s2.length();
	int l=s.length();
	char[] c=s.toCharArray();
	char[] ch=s2.toCharArray();
	if(s.length()>s2.length())
	{
		int q=0;
		for(int k=s.length();k!=-1;k--)
		{
			int y=0;
			int a=Character.getNumericValue(c[k]);
			ll1.pushFront(a);
			int x=ll1.popFront();
			if(s2.length()<=p&&p!=-1) {
			int b=Character.getNumericValue(ch[k]);
			ll2.pushFront(b);
			y=ll2.popFront();
			p--;
			}
			int z=x+y+q;
			/*if(z>9)
			{
				z=z%10;
				l3.pushFront(z);
			}
			 q=z/10;*/
			 if(k==0)
			 {
				 if(z>9)
					{
						z=z%10;
						l3.pushFront(z);
						q=z/10;
						 l3.pushFront(q);
					}
				 else
				 {
					 l3.pushFront(z);
				 }
					 
			 }
			 else
			 {
				 if(z>9)
					{
						z=z%10;
						l3.pushFront(z);
						 q=z/10; 
					}
				 else
					 l3.pushFront(z);
				 
					
			 }
		}
	}
	else if(s.length()<s2.length())
	{
		int q=0;
		for(int k=s2.length();k!=-1;k--)
		{
			int x=0;
			if(s.length()<=l&&l!=-1)
			{
				int a=Character.getNumericValue(c[k]);
				ll1.pushFront(a);
						x=ll1.popFront();
			}
			int b=Character.getNumericValue(ch[k]);
			ll2.pushFront(b);
			int y=ll2.popFront();
			int z=x+y+q;
			if(k==0)
			 {
				 if(z>9)
					{
						z=z%10;
						l3.pushFront(z);
						q=z/10;
						 l3.pushFront(q);
					}
				 else
				 {
					 l3.pushFront(z);
				 }
					 
			 }
			 else
			 {
				 if(z>9)
					{
						z=z%10;
						l3.pushFront(z);
						 q=z/10; 
					}
				 else
					 l3.pushFront(z);
				 
					
			 }
		}
	}
	else
	{
		int x,y,q=0;
		for(int k=s.length();k!=-1;k--)
		{
			int a=Character.getNumericValue(c[k]);
			ll1.pushFront(a);
			x=ll1.popFront();
			int b=Character.getNumericValue(ch[k]);
			ll2.pushFront(b);
			y=ll2.popFront();
			int z=x+y+q;
			if(k==0)
			 {
				 if(z>9)
					{
						z=z%10;
						l3.pushFront(z);
						q=z/10;
						 l3.pushFront(q);
					}
				 else
				 {
					 l3.pushFront(z);
				 }
					 
			 }
			 else
			 {
				 if(z>9)
					{
						z=z%10;
						l3.pushFront(z);
						 q=z/10; 
					}
				 else
					 l3.pushFront(z);
				 
					
			 }
			
		}
	}
//	for(int i=0;i<ll1.)
	
	
}


private static String digitsToNumber(String s) {
	// TODO Auto-generated method stub
	
	char[] c=s.toCharArray();
	Llist l1=new Llist();
	for(int i=s.length();i!=-1;i--)
	{
		int x=Character.getNumericValue(c[i]);
		
		l1.pushFront(x);
		
	}
	 l1.disp();
	String s1=c.toString();
		return s1;
	

}

private static void numberToDigits(String s) {
	
	char[] c=s.toCharArray();
	Llist l1=new Llist();
	for(int i=s.length()-1;i!=-1;i--)
	{
		int x=Character.getNumericValue(c[i]);
		
		l1.pushFront(x);
		
	}
	 l1.disp();
	
}
}
