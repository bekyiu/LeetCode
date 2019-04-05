package other.chapter2;

//环形单链表的约瑟夫环问题
public class Page50
{
	public static void main(String[] args)
	{
		
	}
	
	//报数报到m就kill O(m*n)
	public Node josephus(Node head, int m)
	{
		if(head == null || head.next == null || m < 1)
		{
			return head;
		}
		Node last = head;
		while(last.next != head)
		{
			last = last.next;
		}
		int count = 0;
		while(last != head)
		{
			count++;
			if(count == m)
			{
				last.next = head.next;
				count = 0;
			}
			else
			{
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
	
	//进阶, 如果链表节点数为N, 实现O(N)的方法
	//...
	class Node
	{
		public int value;
		public Node next;

		public Node(int value)
		{
			this.value = value;
		}
	}
}
