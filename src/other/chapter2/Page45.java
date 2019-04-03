package other.chapter2;

//删除链表的中间节点 和 a/b处的节点
public class Page45
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
	
	public Node removeMidNode(Node head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		if(head.next.next == null)
		{
			return head.next;
		}
		//要删除那个节点的前一个节点
		Node pre = head;
		Node cur = head.next.next;
		while(cur.next != null && cur.next.next != null)
		{
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}
	
	public Node removeByRatio(Node head, int a, int b)
	{
		if(a < 1 || a >b)
		{
			return head;
		}
		//求链表长度
		int n = 0;
		Node cur = head;
		while(cur != null)
		{
			n++;
			cur = cur.next;
		}
		//计算要删除的是第几个节点
		n = (int) Math.ceil((double)(a * n) / b);
		//删除
		if(n == 1)
		{
			return head.next;
		}
		if(n > 1)
		{
			//需要跳的次数
			n -= 2;
			cur = head;
			while(n != 0)
			{
				n--;
				cur = cur.next;
			}
			cur.next =  cur.next.next;
		}
		return head;
		
	}
}
