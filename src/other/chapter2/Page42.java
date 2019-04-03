package other.chapter2;

//在单链表和双链表中删除倒数第K个节点
//LeetCode 19
public class Page42
{
	public static void main(String[] args)
	{
		
	}
	
	//只写双链表版本
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
	
	public static DoubleNode removeLstKthNode(DoubleNode head, int k)
	{
		if(head == null || k < 1)
		{
			return null;
		}
		DoubleNode cur = head;
		while(cur != null)
		{
			k--;
			cur = cur.next;
		}
		if(k > 0)
		{
			return head;
		}
		if(k == 0)
		{
			head = head.next;
			//注意!!
			head.last = null;
			return head;
		}
		if(k < 0)
		{
			cur = head;
			k++;
			while(k != 0)
			{
				k++;
				cur = cur.next;
			}
			DoubleNode th = cur.next.next;
			cur.next = th;
			//注意这个if!!!
			if(th != null)
			{
				th.last = cur;
			}
		}
		return head;
	}
}
