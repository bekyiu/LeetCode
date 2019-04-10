package other.chapter2;

import java.util.HashSet;
import java.util.Set;

public class Page77
{
	public static void main(String[] args)
	{
		
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
	//hash 时间复杂度On 空间复杂度On
	public void removeRep1(ListNode head)
	{
		ListNode cur = head.next;
		ListNode pre = head;
		Set<Integer> set = new HashSet<>();
		set.add(head.val);
		while(cur != null)
		{
			if(set.contains(cur.val))
			{
				pre.next = cur.next;
			}
			else
			{
				set.add(cur.val);
				pre = cur;
			}
			cur = cur.next;
		}
	}
	//时间复杂度n^2, 空间复杂度O1
	public void removeRep2(ListNode head)
	{
		ListNode cur = head;
		ListNode next = null;
		ListNode pre = null;
		while(cur != null)
		{
			pre = cur;
			next = cur.next;
			while(next != null)
			{
				if(next.val == cur.val)
				{
					pre.next = next.next;
				}
				else
				{
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
	}
}
