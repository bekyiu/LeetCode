package medium;

//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
public class Q142
{
	public ListNode detectCycle(ListNode head)
	{
		if (head == null || head.next == null || head.next.next == null)
		{
			return null;
		}
		//一开始slow和fast都指向head
		//先人为移动一次, 不然进不去while
		ListNode slow = head.next;
		ListNode fast = head.next.next;
		while (slow != fast)
		{
			if (fast.next == null || fast.next.next == null)
			{
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		// 这样操作一定会在第一个入环节点相遇
		fast = head;
		while (slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
}
