package other.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;
//Q2, 比这个简单
public class Page66
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
	
	public Node addList1(Node head1, Node head2)
	{
		Deque<Integer> s1 = new ArrayDeque<>();
		Deque<Integer> s2 = new ArrayDeque<>();
		Node cur = head1;
		while(cur != null)
		{
			s1.push(cur.value);
			cur = cur.next;
		}
		cur = head2;
		while(cur != null)
		{
			s2.push(cur.value);
			cur = cur.next;
		}
		
		int ca = 0; //表示进位
		int n1 = 0; //s1 pop出来的值
		int n2 = 0; //s2 pop出来的值
		int n = 0; // n1 + n2 + ca
		Node pre = null; //上一轮算出来的值
		Node node = null; //当前这个结点
		
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			n1 = s1.isEmpty() ? 0 : s1.pop();
			n2 = s2.isEmpty() ? 0 : s2.pop();
			n = n1 + n2 + ca;
			pre = node;
			//每个结点的值是0 ~ 9
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
		}
		if(ca == 1)
		{
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}
	
	public Node addList2(Node head1, Node head2)
	{
		head1 = reverse(head1);
		head2 = reverse(head2);
		
		int ca = 0; //表示进位
		int n1 = 0; 
		int n2 = 0; 
		int n = 0; // n1 + n2 + ca
		Node pre = null; //上一轮算出来的值
		Node node = null; //当前这个结点
		
		Node c1 = head1;
		Node c2 = head2;
		while(c1 != null || c2 != null)
		{
			n1 = c1 == null ? 0 : c1.value;
			n2 = c2 == null ? 0 : c2.value;
			
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n / 10;
			c1 = c1 == null ? null : c1.next;
			c2 = c2 == null ? null : c2.next;
		}
		if(ca == 1)
		{
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		reverse(head1);
		reverse(head2);
		return node;
	}
	
	private Node reverse(Node head)
	{
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur != null)
		{
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
