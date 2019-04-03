package other.chapter2;


//翻转单链表和双链表
public class Page47
{
	public static void main(String[] args)
	{
		
	}
	class Node
	{
		public int value;
		public Node next;
		public Node(int value)
		{
			this.value = value;
		}
	}
	public Node reverseList(Node head)
	{
		Node pre = null;
		Node next = null;
		while(head != null)
		{
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	class DoubleNode
	{
		public int value;
		public DoubleNode last;
		public DoubleNode next;
		
		public DoubleNode(int value)
		{
			this.value = value;
		}
	}
	
	public DoubleNode reverseList(DoubleNode head)
	{
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null)
		{
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}

}
