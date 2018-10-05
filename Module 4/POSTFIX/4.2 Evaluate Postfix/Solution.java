
import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String args[])
	{
		
		Scanner s=new Scanner(System.in);
		String a=s.nextLine();
		int num=a.length();
		StackOfStrings sta=new StackOfStrings(num);
		String b[]=a.split(" ");
		//System.out.println(b.length);
			
		for(int i=0;i<b.length;i++)
		{
			
			if(b[i].equals("*"))
			{
				int n1=sta.pop();
				int n2=sta.pop();
				int n3=n1*n2;
				sta.push(n3);
				
			}
			
			else if(b[i].equals("+"))
			{
				int  n1=sta.pop();
				int n2=sta.pop();
				int n3=n1+n2;
				sta.push(n3);
			
			}
			
			else
			{
				int m=Integer.parseInt(b[i]);
				sta.push(m);
			}
		
		
		}
		
		//System.out.println("top is"+sta.top);
	/*	for(int i=0;i<sta.top;i++)	
			{
			System.out.println("top is"+sta.top);
				//System.out.println(sta.s[i]);
			}*/
		System.out.println(sta.pop());
}
	
}

 class StackOfStrings 
{
	 int[] s;
	 int top=-1;
	StackOfStrings(int num)
	{
		s=new int[num];
	}
	public void push(int item)
	{
		if(!isfull())
		{
			s[++top]=item;
		}
		
	
	}
	public int pop()
	{
		if(!isempty())
		{
			return s[top--];
		}
		return s[--top];
	}
	public boolean isempty()
	{
		if(top==-1)

		return true;
	
		else 
		return false;
	}
	public boolean isfull()
	{	
		if(top==20)
		return true;
		else 
		return false;
	}
	
}
