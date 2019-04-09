package medium;

//给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
//它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
public class Q445
{
	public ListNode addTwoNumbers(ListNode head1, ListNode head2)
	{
		head1 = reverse(head1);
		head2 = reverse(head2);

		int ca = 0; // 表示进位
		int n1 = 0;
		int n2 = 0;
		int n = 0; // n1 + n2 + ca
		ListNode pre = null; // 上一轮算出来的值
		ListNode node = null; // 当前这个结点

		ListNode c1 = head1;
		ListNode c2 = head2;
		while (c1 != null || c2 != null)
		{
			n1 = c1 == null ? 0 : c1.val;
			n2 = c2 == null ? 0 : c2.val;

			n = n1 + n2 + ca;
			pre = node;
			node = new ListNode(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 == null ? null : c1.next;
			c2 = c2 == null ? null : c2.next;
		}
		if (ca == 1)
		{
			pre = node;
			node = new ListNode(1);
			node.next = pre;
		}
		// reverse(head1);
		// reverse(head2);
		return node;
	}

	private ListNode reverse(ListNode head)
	{
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;
		while (cur != null)
		{
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
}
