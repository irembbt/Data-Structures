
public class LinkedQueue {
	
	private Node front = null;
	private Node rear = null;
	private int numberElements = 0;
	
	public void Enqueue(Object item)
	{
		if(front==null)
		{
			Node newNode = new Node(item);
			rear= newNode;
			front = newNode;
		}		
		else 
		{
			Node newNode = new Node(item);
			rear.setLink(newNode);
			rear = newNode;
		}
		numberElements++;
	}
	
	public Object Dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return null;
		}
		else
		{
			Object data = front.getData();
			front = front.getLink();
			numberElements--;
			return data;
		}
	}
	
	public Node peek()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return null;
		}
		else
		{
			return front;
		}
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	public int size()
	{
		return numberElements;
	}
	
	public void display()
	{
		if(front==null)
		{
			System.out.print("Empty");
			
		}
		else
		{
			Node temp = front;
			while(temp != null)
			{
				System.out.print(temp.getData() + "-");
				temp=temp.getLink();
			}
			
		}
	}

}
