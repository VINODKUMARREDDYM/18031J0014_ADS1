import java.util.Scanner;

class Node1
{
	int data;
	Node1 next;
	Node1(int a)
	{
		this.data=a;
		this.next=null;
	}
}
class list
{
	int size=0;
	Node1 Head;
	list()
	{
		Head=null;
	}
	public void addFirst(int a)
	{
		Node1 value=new Node1(a);
		size++;
		if(Head==null)
		{
			Head=value;
		}
		else
		{
			value.next=Head;
			Head=value;
		}
	}
	public void add(int a)
	{
		Node1 value=new Node1(a);
		size++;
		if(Head==null)
		Head=value;
		else
		{
			Node1 temp=Head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=value;
		}
		
	}
	public int popEnd()
	{
		size--;
		Node1 temp=Head;
		if(Head==null)
		{
			int c=0;
			return c;
		}
		else
		{
		if(temp.next==null)
		{
			int b=temp.data;
			Head=null;
			return b;
		}
		else
		{
			
			while(temp.next.next!=null)
			{
				temp=temp.next;
			}
			int a=temp.next.data;
			temp.next=null;
			return a;
		}
		}
		}
	public int popFirst()
	{
		if(Head==null)
		{
			return -1;
		}
		else
		{
		if(Head.next==null)
		{
			int a=Head.data;
			Head=null;
			return -1;
		}
		else
		{
			int a= Head.data;
			Head=Head.next;
			return a;
		}
		}
				
	}
	public String Disp()
	{
		Node1 temp1=Head;
		String s="";
		if(temp1==null)
		{
			return null;
		}
		else
		{
		while(temp1.next!=null)
		{
			s+=temp1.data;
			
			System.out.print(temp1.data+", ");
			temp1=temp1.next;
		}
		System.out.print(temp1.data);
		System.out.println("");
		}
		
		return s;
	}
}
class Solution
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String N=sc.nextLine();
		list l=new list();
		int count=0;
		while(sc.hasNext())
		{
			
			String s=sc.nextLine();
			String[] b=s.split(" ");
			switch(b[0])
			{
			case "push" :
				int a=Integer.parseInt(b[1]);
				l.addFirst(a);
				l.Disp();
				break;
			case "enqueue":
				a=Integer.parseInt(b[1]);
				l.add(a);
				l.Disp();
				break;
			case "pop":
				a=l.popFirst();
				count++;
				if(a==-1)
				{
					System.out.println("Steque is empty.");
				}
				else
				{
					l.Disp();
				}
				break;
			case "" :
				l.Head=null;
				
				System.out.println("");
				break;
			
			}
			
		}
	}
}