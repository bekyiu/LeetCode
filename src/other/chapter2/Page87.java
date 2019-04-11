package other.chapter2;

public class Page87
{
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
	
	public ListNode insertNum(ListNode head, int num)
	{
		ListNode node = new ListNode(num);
		if(head == null)
		{
			node.next = node;
			return node;
		}
		ListNode pre = head;
		ListNode cur = head.next;
		boolean flag = false;
		while(cur != head)
		{
			if(pre.val <= num && num <= cur.val)
			{
				flag = true;
				pre.next = node;
				node.next = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		if(!flag)
		{
			//此时cur指向head
			pre.next = node;
			node.next = cur;
			if(num <= cur.val)
			{
				return node;
			}
		}
		return head;
		
	}
}
