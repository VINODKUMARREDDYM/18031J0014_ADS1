import java.util.Scanner;

class Stack
{
	int N=0;
	char [] s;
	public Stack(int cap)
	{
		s=new char[cap];
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public void push(char a)
	{
		if(!isFull())
		s[N++]=a;
	}
	public char pop()
	{
		char b = 0;
		if(!isEmpty())
		{
		 b=s[--N];
		return b;
		}
		return b;
	}
	public boolean isFull()
	{
		return N==s.length;
	}
	public int peek()
	{
		return s[N];
	}
	public void Empty()
	{
		N=0;
	}
}
class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String N=sc.nextLine();
		//Stack st=new Stack(N);
		char r;
		int count=0;
		boolean t=true;
		while(sc.hasNext())
		{
			String s=sc.nextLine();
			Stack st=new Stack(s.length());
			for(int i=0;i<s.length();i++)
			{
				char c=s.charAt(i);
				switch(c)
				{
				case '{':
					st.push(c);
					break;
				case '[':
					st.push(c);
					break;
				case '(':
					st.push(c);
					break;
				case '}':
					r=st.pop();
					t=(r=='{');
					//System.out.println("case 1  :"+t);
					break;
				case ']':
					r=st.pop();
					t=(r=='[');
					//System.out.println("case 2  :"+t);
					break;
				case ')':
					r=st.pop();
					t=(r=='(');
					//System.out.println("case 3 :"+t);
					break;
				}
				if(t==false)
				{
					break;
				}
				
			}
			if(t==false)
			{
				t=true;
				System.out.println("NO");
				count++;
			}
			else
			{
				System.out.println("YES");
				count++;
			}
			//System.out.println(count);
			st.Empty();
		}
		/*if(t==true)
		{
			System.out.print(true);
		}
		else
		{
			System.out.print(false);
		}*/
		//System.out.println(count);
	}
}