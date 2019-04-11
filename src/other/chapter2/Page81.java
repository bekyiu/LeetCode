package other.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Page81
{
	class Node
	{
		public int val;
		public Node left;
		public Node right;
		public Node(int val)
		{
			this.val = val;
		}
	}
	public static void main(String[] args)
	{
		
	}
	public Node convert1(Node head)
	{
		Deque<Node> queue = new ArrayDeque<>();
		inOrder(queue, head);
		Node cur = null;
		Node pre = null;
		Node next = null;
		Node newHead = null;
		while(!queue.isEmpty())
		{
			pre = cur;
			cur = queue.pollFirst();
			newHead = newHead == null ? cur : newHead;
			next = queue.peekFirst();
			
			cur.left = pre;
			cur.right = next;
		}
		return newHead;
	}
	
	private void inOrder(Deque<Node> queue, Node head)
	{
		if(head == null)
		{
			return;
		}
		inOrder(queue, head.left);
		queue.addLast(head);
		inOrder(queue, head.right);
	}
	//用递归
}
