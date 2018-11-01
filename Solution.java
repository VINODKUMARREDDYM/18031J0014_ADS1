import java.util.Scanner;

class Book
{
	String Name;
	String Author;
	float Price;
	Book(String Name,String Author,float Price)
		{
		this.Name=Name;
		this.Author=Author;
		this.Price=Price;
		}
	@Override
	public String toString() {
		return "Book [Name=" + Name + ", Author=" + Author + ", Price=" + Price + "]";
	}
	
}
class Node
{
	public Book key;
	public int value;
	public Node left,right;
	public Node(Book key,int value)
	{
		this.key=key;
		this.value=value;
	}
}
class BinarySearch
{
	Node root;
	public void put(Book key,int value)
	{
		root=put(root,key,value);
		/*Node temp=root;
		disp(temp);*/
	}
	public Node put(Node node,Book Key,int value)
	{
		if(node==null)
			return new Node(Key,value);
		if(Key.Name.compareTo(node.key.Name)<0)
			node.left=put(node.left,Key,value);
		if(Key.Name.compareTo(node.key.Name)>0)
			node.right=put(node.right,Key,value);
		if(Key.Name.compareTo(node.key.Name)==0)
			node.value=value;
		return node;
		
	}
	public int get(Book Key)
	{
		Node node=root;
		while(node!=null)
		{
			if(Key.Name.compareTo(node.key.Name)<0)
				node=node.left;
			else if(Key.Name.compareTo(node.key.Name)>0)
				node=node.right;
			else
				return node.value;
			
		}
		return 0;
	}
	public void disp(Node temp)
	{  if(temp!=null) {
		disp(temp.left);
		System.out.println(temp.key+""+temp.value);	
		disp(temp.right);
	}
	}
}
public class Solution {
public static void main(String args[])
{
	Scanner scan = new Scanner(System.in);
	BinarySearch bst = new BinarySearch();
	while(scan.hasNext())
	{
		String s = scan.nextLine();
		String [] array = s.split(",");
		String Operation = array[0];
		Book book = new Book(array[1],array[2],Float.parseFloat(array[3]));
		switch (Operation)
		{
		case "put" :
			bst.put(book,Integer.parseInt(array[4]));
			
			break;
		case "get" :
			if(bst.get(book)!=0)
				System.out.println(bst.get(book));
			else
				System.out.println("null");
			break;
		}
	}

	
}
}
