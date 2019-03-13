package easy;

/*
 * 给定一个链表，判断链表中是否有环。
 * 快慢指针, 如果有环一定会相遇, 如果没环, 末尾一定为null
 */
public class Q141
{
	public boolean hasCycle(ListNode head)
	{
		if(head == null || head.next == null)
		{
			return false;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		//至少保证跳两次, 不然会报空指针
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
            fast = fast.next;
            fast = fast.next;
			if(slow == fast)
			{
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args)
	{

	}
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
