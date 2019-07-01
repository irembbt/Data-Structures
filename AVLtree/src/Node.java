
public class Node {	
	public int key;
	public int balance;
	public int height;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(int k)
	{
		left=null;
		right =null;
		parent =null;
		balance = 0;
		key =k;
		height =0;
	}
	public String toString()
	{
		return "" + key;
	}

}
