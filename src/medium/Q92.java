package medium;


/*
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 采用原地翻转
 */
public class Q92
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
		ListNode cur = head;
		int len = 0;
		ListNode fpre = null;
		ListNode tpos = null;
		while (cur != null)
		{
			len++;
			fpre = len == m - 1 ? cur : fpre;
			tpos = len == n + 1 ? cur : tpos;
			cur = cur.next;
		}
		if (m > n || m < 1 || n > len)
		{
			return head;
		}

		cur = fpre == null ? head : fpre.next;
		ListNode node2 = cur.next;
		//反转后cur的后继是tpos
		cur.next = tpos;
		ListNode next = null;
		while (node2 != tpos)
		{
			next = node2.next;
			node2.next = cur;
			cur = node2;
			node2 = next;
		}
		if (fpre != null)
		{
			//指向翻转前, 待翻转区域的最后一个结点
			fpre.next = cur;
			return head;
		}
		return cur;
	}
	
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
			next = null;
		}
	}
}
