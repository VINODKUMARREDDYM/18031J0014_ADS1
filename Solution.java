import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Book
{
	String Name;
	String Author;
	double Price;
	Book(String Name,String Author,double d)
		{
		this.Name=Name;
		this.Author=Author;
		this.Price=d;
		}
	@Override
	public String toString() {
		return Name+", "+Author+", "+Price;
	}
	
}
class Node
{
	public Book key;
	public int value;
	Node left;
	public Node right;
	public Node(Book key,int value)
	{
		this.key=key;
		this.value=value;
	}
}
public class Solution {
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
		//root.
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
	public Book min()
	{
		
	    return min(root).key;
	}
	private Node min(Node current) { 
	    if (current.left == null) return current; 
	    else                      return min(current.left); 
	}
	public Book max() {
	    
	    return max(root).key;
	} 
	
	private Node max(Node current) {
	    if (current.right == null) return current; 
	    else                       return max(current.right); 
	}
	public  Book floor(Book key)
	{
		Node x = floor(root, key);
	    if (x == null) return null;   // if empty, return null
	    else           return x.key;
	}
	private Node floor(Node current, Book key) {
	    if (current == null) return null;
	    if(key.Name.compareTo(current.key.Name)==0)
	    	return current;
	    if(key.Name.compareTo(current.key.Name)<0)
	    	return floor(current.left,key);
	    
	    
	    Node t = floor(current.right, key); 
	    if (t != null) return t;
	    else           return current;
	}
	public Book ceiling(Book key) {
	  
	    Node x = ceiling(root, key);
	    if (x == null) return null;   // if empty, return null
	    else return x.key;
	}
	
	private Node ceiling(Node current, Book key) {
	    if (current == null) return null;
	    if(key.Name.compareTo(current.key.Name)==0)
	    {
	    	//System.out.println("*****");
	    	return current;}
	    if(key.Name.compareTo(current.key.Name)<0)
	    {
	    	Node t = ceiling(current.left, key); 
			    if (t != null) return t;
			    else           return current;
	    }
	    return ceiling(current.right,key);
	}
	void select(int k)
	{
	ArrayList<Book> al=new ArrayList<Book>();
		select(root,al,k);
		for(int i=0;i<al.size()&&i<=k;i++)
			if(i==k)
				System.out.println(al.get(i));
		//System.out.println(j);
		
	}
	
	
	void select(Node a,ArrayList al,int k)
	{
		/*if(al.size()-1==k) {
			System.out.println(al.get(k));
			return ;
		}*/
		if(a!=null)
		{
			select(a.left,al,k);
			al.add(a.key);
			select(a.right,al,k);
		}
		
		
	}
	Book deleteMin()
	{
		root= deleteMin(root);
		return root.key;
	}
	private Node deleteMin(Node x)
	{
		if(x.left==null)
			return x.right;
		x.left=deleteMin(x.left);
		return x;
	}
	Book deleteMax()
	{
		root=deleteMax(root);
		return root.key;
	}
	private Node deleteMax(Node x)
	{
		if(x.right==null)
			return x.left;
		x.right=deleteMax(x.right);
		return x;
	}
	Book delete(Book key)
	{
		root=delete(root,key);
		return root.key;
	}
	private Node delete(Node x,Book key)
	{
		if(x==null)
			return null;
		if(key.Name.compareTo(x.key.Name)<0)
			x.left=delete(x.left,key);
		else if(key.Name.compareTo(x.key.Name)>0)
			x.right=delete(x.right,key);
		else
		{
			if(x.right==null)
				return x.left;
			
			Node t=x;
			x=min(t.right);
			x.right=deleteMin(t.right);
			x.left=t.left;
		}
		return x;
	}
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		Solution or=new Solution();
		
		
				
		while(scan.hasNext())
		{
			String s = scan.nextLine();
			String [] array = s.split(",");
			String Operation = array[0];
			switch (Operation)
			{
			case "put" :Book book = new Book(array[1],array[2],Double.parseDouble(array[3]));
							or.put(book,Integer.parseInt(array[4]));
						break;
			case "get" :Book book1 = new Book(array[1],array[2],Double.parseDouble(array[3]));
							if(or.get(book1)!=0)
							System.out.println(or.get(book1));
						else
							System.out.println("null");
						break;
			case "min":System.out.println(or.min());
						break;
			case "max":System.out.println(or.max());
						break;
			case "floor":Book book11 = new Book(array[1],array[2],Double.parseDouble(array[3]));
							System.out.println(or.floor(book11));
						break;
			case "ceiling":Book book111 = new Book(array[1],array[2],Double.parseDouble(array[3]));
			System.out.println(or.ceiling(book111));
						break;
			case "select":or.select(Integer.parseInt(array[1]));
								break;
			case "deleteMin":or.deleteMin();//System.out.println("deletemin:"+or.deleteMin());
							break;
			case "deleteMax":or.deleteMax();//System.out.println("deleteMax"+or.deleteMax());
							break;
			case "delete":Book book1111 = new Book(array[1],array[2],Double.parseDouble(array[3]));
							or.delete(book1111);//System.out.println("delete"+or.delete(book1111));
			}
		}
	}

}
