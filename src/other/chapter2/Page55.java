package other.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Page55
{
	public static void main(String[] args)
	{
		
	}
	//利用栈
	public boolean isPalindrome1(Node head)
	{
		Deque<Node> stack = new ArrayDeque<>();
		Node cur = head;
		while(cur != null)
		{
			stack.push(cur);
			cur = cur.next;
		}
		cur = head;
		while(!stack.isEmpty())
		{
			if(stack.pop().value != cur.value)
			{
				return false;
			}
			cur = cur.next;
		}
		return true;
		
	}
	//只压有右半区的节点
	public boolean isPalindrome2(Node head)
	{
		Node cur = head;
		Node right = cur.next;
		while(cur.next != null && cur.next.next != null)
		{
			right = right.next;
			cur.next = cur.next.next;
		}
		Deque<Node> stack = new ArrayDeque<>();
		while(right != null)
		{
			stack.push(right);
			right = right.next;
		}
		cur = head;
		while(!stack.isEmpty())
		{
			if(stack.pop().value != cur.value) 
			{
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
	
	//O(1)的空间, 反转右部份的链表
	public boolean isPalindrome3(Node head)
	{
		//指向右部份第一个节点的前一个节点
		Node n1 = head;
		Node n2 = head;
		while(n2.next != null && n2.next.next != null)
		{
			n1 = n1.next;
			n2 = n2.next.next;
		}
		n1.next = null;
		n2 = n1.next;
		Node next = null;
		while(n2 != null)
		{
			next = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = next;
		}
		//现在n1指向尾
		n2 = head;
		while(n2 != null)
		{
			if(n2.value != n2.value)
			{
				return false;
			}
			n2 = n2.next;
			n1 = n1.next;
		}
		return true;
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
}
