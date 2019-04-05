package other.chapter3;

//morris遍历
public class Page111
{

	
	//morris序
	public void morris(Node head)
	{
		if(head == null)
		{
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while(cur != null)
		{
			mostRight = cur.left;
			if(mostRight != null)
			{
				while(mostRight.right != null && mostRight.right != cur) 
				{
					mostRight = mostRight.right;
				}
				if(mostRight.right == null)
				{
					mostRight.right = cur;
					cur = cur.left;
					continue;
				}
				else
				{
					mostRight.right = null;
				}
			}
			cur = cur.right;
		}
	}
	
	
	
	
	class Node
	{
		public int value;
		public Node left;
		public Node right;
		public Node(int value)
		{
			this.value = value;
		}
	}
}
