package other.chapter2;

import java.util.HashMap;
import java.util.Map;

public class Page63
{
	class Node
	{
		public int value;
		public Node next;
		public Node random;
		public Node(int value)
		{
			this.value = value;
		}
	}
	//额外空间复杂度O N
	public Node copyListWithRand1(Node head)
	{
		Map<Node, Node> map = new HashMap<>();
		Node cur = head;
		while(cur != null)
		{
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur != null)
		{
			Node cpCur = map.get(cur);
			Node next = cur.next;
			Node nextRandom = cur.random;
			Node cpNext = map.get(next);
			Node cpNextRandom = map.get(nextRandom);
			cpCur.next = cpNext;
			cpCur.random = cpNextRandom;
			
			cur = cur.next;
		}
		return map.get(head);
	}
	
	//额外空间复杂度O 1
	public Node copyListWithRand2(Node head)
	{
		Node cur = head;
		while(cur != null)
		{
			Node next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node cpNode = null;
		while(cur != null)
		{
			cpNode = cur.next;
			cpNode.random = cur.random == null ? null : cur.random.next;
			cur = cur.next.next;
		}
		//拆分
		cur = head;
		Node res = cur.next;
		while(cur != null)
		{
			Node next = cur.next.next;
			cpNode = cur.next;
			cpNode.next = next == null ? null : next.next;
			cur.next = next;
			cur = next;
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		
	}
}
