package other.chapter2;

public class Page69
{
	class Node
	{
		public int value;
		public Node next;

		public Node(int value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args)
	{

	}

	// 判断这个链表是否有环, 如果有环, 返回第一个入环的节点
	// 否则返回null, 空间复杂度O1
	public Node getLoopNode(Node head)
	{
		if (head == null || head.next == null || head.next.next == null)
		{
			return null;
		}
		// 先人为移动一次, 不然进不去while
		Node slow = head.next;
		Node fast = head.next.next;
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

	// 判断两个无换链表是否相交
	// 相交就返回第一个相交的节点, 否则返回null
	public Node noLoop(Node head1, Node head2)
	{
		if (head1 == null || head2 == null)
		{
			return null;
		}
		Node cur1 = head1;
		int len1 = 1;
		Node cur2 = head2;
		int len2 = 1;
		while(cur1.next != null)
		{
			len1++;
			cur1 = cur1.next;
		}
		while(cur2.next != null)
		{
			len2++;
			cur2 = cur2.next;
		}
		if(cur1 != cur2)
		{
			return null;
		}
		//cur1是长的那一个
		cur1 = len1 - len2 > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		int n = Math.abs(len1 - len2);
		while(n != 0)
		{
			n--;
			cur1 = cur1.next;
		}
		while(cur1 != cur2)
		{
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	//判断两个有环链表是否相交
	//相交返回第一个相交的节点, 否则返回null
	public Node bothLoop(Node head1, Node loop1, Node head2, Node loop2)
	{
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2)
		{
			cur1 = head1;
			cur2 = head2;
			int len1 = 0;
			int len2 = 0;
			while(cur1 != loop1)
			{
				len1++;
				cur1 = cur1.next;
			}
			while(cur2 != loop2)
			{
				len2++;
				cur2 = cur2.next;
			}
			cur1 = len1 - len2 > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			int n = Math.abs(len1 - len2);
			while(n != 0)
			{
				n--;
				cur1 = cur1.next;
			}
			while(cur1 != cur2)
			{
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}
		else
		{
			cur1 = loop1.next;
			while(cur1 != loop1)
			{
				if(cur1 == loop2)
				{
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	
	//主方法
	public Node getIntersectNode(Node head1, Node head2)
	{
		if(head1 == null || head2 == null)
		{
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null)
		{
			return noLoop(head1, head2);
		}
		if(loop1 != null && loop2 != null)
		{
			return bothLoop(head1, loop1, head2, loop2);
		}
		//一个有环一个无环是不可能相交的
		return null;
	}
}










