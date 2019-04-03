package medium;

/*
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Q19
{
	
	public static void main(String[] args)
	{
		
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n)
	{
		if(head == null || n < 1)
		{
			return null;
		}
		ListNode cur = head;
		int k = n;
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
			return head.next;
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
			cur.next = cur.next.next;
			//return head;
		}
		return head;
	}

	class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x)
		{
			val = x;
		}
	}
}
