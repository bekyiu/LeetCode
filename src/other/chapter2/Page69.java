package other.chapter2;

public class Page69
{
	class Node
	{
		public int value;
		public Node next;
		public Node(int value)
		{
			this.value = value;
		}
	}
	public static void main(String[] args)
	{
		
	}
	
	//判断这个链表是否有环, 如果有环, 返回第一个入环的节点
	//否则返回null, 空间复杂度O1
	public Node getLoopNode(Node head)
	{
		if(head == null || head.next == null || head.next.next == null)
		{
			return null;
		}
		//先人为移动一次, 不然进不去while
		Node slow = head.next;
		Node fast = head.next.next;
		while(slow != fast)
		{
			if(fast.next == null || fast.next.next == null)
			{
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		
		//这样操作一定会在第一个入环节点相遇
		fast = head;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}
}
