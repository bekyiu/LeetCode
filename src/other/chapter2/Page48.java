package other.chapter2;

//翻转部分单链表, Q92
public class Page48
{
	public static void main(String[] args)
	{

	}

	class Node
	{
		public int value;
		public Node next;

		public Node(int value)
		{
			this.value = value;
		}
	}

	public Node reversePart(Node head, int from, int to)
	{
		Node cur = head;
		int len = 0;
		Node fpre = null;
		Node tpos = null;
		while (cur != null)
		{
			len++;
			fpre = len == from - 1 ? cur : fpre;
			tpos = len == to + 1 ? cur : tpos;
			cur = cur.next;
		}
		if (from > to || from < 1 || to > len)
		{
			return head;
		}

		cur = fpre == null ? head : fpre.next;
		Node node2 = cur.next;
		cur.next = tpos;
		Node next = null;
		while (node2 != tpos)
		{
			next = node2.next;
			node2.next = cur;
			cur = node2;
			node2 = next;
		}
		if (fpre != null)
		{
			fpre.next = cur;
			return head;
		}
		return cur;
	}
	

}
