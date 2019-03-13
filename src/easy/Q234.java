package easy;
/*
 * 请判断一个链表是否为回文链表。
 * 思路1:使用栈
 * 思路2:把后半段逆序, 然后从两边向中间遍历
 */
public class Q234
{
//	public boolean isPalindrome(ListNode head)
//	{
//		if(head == null)
//		{
//			return false;
//		}
//		if(head.next == null)
//		{
//			return true;
//		}
//		Deque<Integer> stack = new ArrayDeque<>();
//		ListNode p = head;
//		while(p != null)
//		{
//			stack.push(p.val);
//			p = p.next;
//		}
//		p = head;
//		while(p != null)
//		{
//			Integer num = stack.pop();
//			if(num != p.val)
//			{
//				return false;
//			}
//			p = p.next;
//		}
//		return true;
//	}
	public boolean isPalindrome(ListNode head)
	{
		if(head == null)
		{
			return false;
		}
		if(head.next == null)
		{
			return true;
		}
		ListNode n1 = head;
		ListNode n2 = head;
		while(n2.next != null && n2.next.next != null)
		{
			n1 = n1.next;
			n2 = n2.next.next;
		}
		//如果有奇数个节点 此时n1指向中间节点, 如果有偶数个节点 此时n1指向两个中间节点的前一个
		//-----------------
		n2 = n1.next;
		n1.next = null;
		ListNode n3 = null;
		while(n2 != null)
		{
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3;
		}
		//翻转完成后 n1指向整个链表的最后一个节点
		//----------------
		n3 = n1;
		n2 = head;
		while(n2 != null && n1 != null)
		{
			if(n2.val != n1.val)
			{
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		//完整做法 还要再将链表翻转回来
		return true;
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

