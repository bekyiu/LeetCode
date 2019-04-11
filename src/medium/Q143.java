package medium;

//和Page90类似
public class Q143
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
	
	public void reorderList(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		//此时slow指向的是左边区域的最后一个节点
		ListNode l1 = head;
		//右半部分逆序
		ListNode l2 = reverse(slow.next);
		slow.next = null;
		
		ListNode root = new ListNode(-1);
		ListNode ptr = root;
		//先拼L1, 再拼L2
		int count = 2;
		while(l1 != null && l2 != null)
		{
			if(count % 2 == 0)
			{
				ptr.next = l1;
				l1 = l1.next;
			}
			else
			{
				ptr.next = l2;
				l2 = l2.next;
			}
			count++;
			ptr = ptr.next;
		}
		if(l1 != null)
		{
			ptr.next = l1;
		}
		if(l2 != null)
		{
			ptr.next = l2;
		}
		head = root.next;
	}
	
	private ListNode reverse(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		ListNode next = null;
		while(cur != null)
		{
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
