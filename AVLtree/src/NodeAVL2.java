
public class NodeAVL2 {	
	public int key;
	public int balance;
	public int height;
	public int sum;
	public NodeAVL2 left;
	public NodeAVL2 right;
	public NodeAVL2 parent;
	
	public NodeAVL2(int k)
	{
		left=null;
		right =null;
		parent =null;
		balance = 0;
		key =k;
		height =0;
		sum=0;
	}
	public String toString()
	{
		return "" + key;
	}

}
