
public class AugmentedTree {
	
	NodeAVL2 root;
	public void insert(int number)
	{
		NodeAVL2 node = new NodeAVL2(number);
		AVLinsert(root,node);
		
	}
	public void AVLinsert(NodeAVL2 root1, NodeAVL2 newnode)
	{
		if(root1==null)//root boþsa
		{
			root=newnode;
		}
		else//root doluysa
		{
			if(newnode.key<root1.key)//root keyden büyükse sola
			{
				if(root1.left==null)
				{
					root1.left=newnode;
					newnode.parent=root1;
					Balance(root1); //Balance hesaplama
				}
				else
				{
					AVLinsert(root1.left,newnode);//root un solu doluysa kökün soluna ekle ve yeni deðeri gönder					
				}
			}
			else if(newnode.key>root1.key)//saða ekle
			{
				if(root1.right==null)
				{
					root1.right=newnode;
					newnode.parent=root1;
					Balance(root1);//Balance hesaplama
				}
				else
				{
					AVLinsert(root1.right,newnode);
				}
			}
			
		}//else sonu
		
		getSumSmaller(newnode);
	}
	
	public void Balance(NodeAVL2 number)
	{
		findBalance(number);
		int balance = number.balance;
		if(balance==-2)
		{
			if(height(number.left.left)>=height(number.left.right))
			{
				number = rotateRight(number);
			}
			else
			{
				number = rotateLeftRight(number);
			}
		}
		else if(balance==2)
		{
			if(height(number.right.right)>=height(number.right.left))
			{
				number=rotateLeft(number);
			}
			else
			{
				number=rotateRightLeft(number);
			}
		}
		if(number.parent!=null)
		{
			Balance(number.parent);
		}
		else
		{
			root=number;
		}
	}
	
	public void findBalance(NodeAVL2 numbeer)////numbeer yerine number?
	{
		numbeer.balance=height(numbeer.right)-height(numbeer.left);
	}
	public int height(NodeAVL2 numbeer)
	{
		if(numbeer==null)
		{
		    return -1;
		   }
		   if(numbeer.left==null && numbeer.right==null) 
		   {
		    return 0;
		   } 
		   else if(numbeer.left==null) 
		   {
		    return 1+height(numbeer.right);
		    
		   } 
		   else if(numbeer.right==null) 
		   {
		    return 1+height(numbeer.left);
		   } 
		   else 
		   {
		    return 1+max(height(numbeer.left),height(numbeer.right));//
		   }
	}
	
	public int max(int number1, int number2)
	{
		if(number1>=number2)
		{
			return number1;
		}
		else
		{
			return number2;
		}
	}
	public NodeAVL2 rotateLeft(NodeAVL2 k) //double rotate
	{
		NodeAVL2 k2 = k.right;
		k2.parent=k.parent;
		k.right=k2.left;
		if(k.right!=null)
		{
			k.right.parent=k;
		}
		k2.left=k;
		k.parent=k2;
		
		if(k2.parent!=null)
		{
			if(k2.parent.right==k)
			{
				k2.parent.right=k;
			}
			else if(k2.parent.left==k)
			{
				k2.parent.left=k;
			}	
		}
		if(root==k)
		{
			root=k2;
		}
		findBalance(k);
		findBalance(k2);
		return k2;
	}
	
	public NodeAVL2 rotateRight(NodeAVL2 k) //single rotate
	{
		NodeAVL2 k2 = k.left;
		k2.parent=k.parent;
		k.left=k2.right;
		
		if(k.left!=null)
		{
			k.left.parent=k;
		}
		k2.right=k;
		k.parent=k2;
		
		if(k2.parent!=null)
		{
			if(k2.parent.right==k)
			{
				k2.parent.right=k2;
			}
			else if(k2.parent.left==k)
			{
				k2.parent.left=k2;
			}
		}
		if(k.left!=null)
		{
			k.left.parent=k;
		}
		findBalance(k);
		findBalance(k2);
		return k2;
		
	}
	
	public NodeAVL2 rotateLeftRight(NodeAVL2 k) //double rotate
	{
		k.left=rotateLeft(k.left);
		return rotateRight(k);
	}
	public NodeAVL2 rotateRightLeft(NodeAVL2 k) //double rotate
	{
		k.right=rotateRight(k.right);
		return rotateLeft(k);
	}
	
	public int getMax(NodeAVL2 root)
	{
		if(root.right== null)
		{
			return root.key;
		}
		else
		{
			return getMax(root.right);
		}
		
	}
	public int getMin(NodeAVL2 root)
	{
		if(root.left==null)
		{
			return root.key;
		}
		else
		{
			return getMin(root.left);
		}
		
	}
	public int getSum(NodeAVL2 root)
	{
		if(root==null)
		{
			return 0;
		}
		else
		{
			return root.key + getSum(root.left) + getSum(root.right);
		}
		
	}
	
	public int getSumSmaller(NodeAVL2 newnode)
	{		
		NodeAVL2 temp = newnode;
		int sum=0;
		if(root.right!= null)
		{
			while (temp != root){
			sum = newnode.parent.key + getMax(root.right);
			}
		}
		return sum;
		
			
	  }
				
	
	
	//print
	
	public void inOrder(NodeAVL2 root) //sýrala ve yazdýr.
	{
		if(root!= null)
		{
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
		
	}
	public NodeAVL2 getRoot() {
		return root;
	}
	
	

}
