/*
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED   = true;
    private static final boolean BLACK = false;

    private Node root; 
    
    
    private boolean isRed(Node node)
    {
        if (node == null)
        {
        	return false;
        }
        return node.color == RED;
    }
    
    public boolean isEmpty() 
    {
        return root == null;
    }
   
    private int Size(Node node)
    {
        if (node == null)
        {
        	return 0;
        }
        return node.size;
    } 
    
    public int Size() 
    {
        return Size(root);
    }

    public Value GetVal(Key key) 
    {
        if (key == null) 
        {
        	throw new IllegalArgumentException("Argument is null");
        }
        return GetVal(root, key);
    }

    private Value GetVal(Node node, Key key) 
    {
        while (node != null) 
        {
            int cmp = key.compareTo((Key) node.key);
            if(cmp < 0) 
            {
            	node = node.left;
            }
            else if(cmp > 0)
            {
            	node = node.right;
            }
            else
            {
            	return (Value) node.val;
            }
        }
        return null;
    }
    
    public void PutVal(Key key, Value val) {
        if (key == null)
        {
        	throw new IllegalArgumentException("Argument is null");
        }
        if (val == null) 
        {
            return;
        }

        root = PutVal(root, key, val);
        root.color = BLACK;
    }

    private Node PutVal(Node node, Key key, Value val) 
    { 
        if (node == null) 
        {
        	return new Node(key, val, RED, 1);
        }

        int cmp = key.compareTo((Key) node.key);
        
        if(cmp < 0) 
        {
        	node.left  = PutVal(node.left,  key, val); 
        }
        else if(cmp > 0) 
        {
        	node.right = PutVal(node.right, key, val); 
        }
        else
        {
        	node.val   = val;
        }

        if (isRed(node.right) && !isRed(node.left))      node = RotateLeft(node);
        
        if (isRed(node.left)  &&  isRed(node.left.left)) node = RotateRight(node);
        
        if (isRed(node.left)  &&  isRed(node.right))     FlipColors(node);
        
        
        
        node.size = Size(node.left) + Size(node.right) + 1;

        return node;
    }
    
    private Node RotateRight(Node node)
    {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = temp.right.color;
        temp.right.color = RED;
        temp.size = node.size;
        node.size = Size(node.left) + Size(node.right) + 1;
        return temp;
    }

    private Node RotateLeft(Node node) 
    {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = temp.left.color;
        temp.left.color = RED;
        temp.size = node.size;
        node.size = Size(node.left) + Size(node.right) + 1;
        return temp;
    }

    private void FlipColors(Node node) 
    {
    	node.color = !node.color;
    	node.left.color = !node.left.color;
    	node.right.color = !node.right.color;
    }
    
    
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        return get(root, key);
    }

    // value associated with the given key in subtree rooted at x; null if no such key
    
    
    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo((Key) x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return (Value) x.val;
        }
        return null;
    }


    
    
    
}

