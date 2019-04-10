package other.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;

//LeetCode 203
public class Page79
{
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
    public ListNode removeElements(ListNode head, int val) 
    {
    	Deque<ListNode> stack = new ArrayDeque<>();
    	ListNode cur = head;
    	while(cur != null)
    	{
    		if(cur.val != val)
    		{
    			stack.push(cur);
    		}
    		cur = cur.next;
    	}
    	while(!stack.isEmpty())
    	{
    		stack.peek().next = cur;
    		cur = stack.pop();
    	}
    	return cur;
    	
    }
    //空间复杂度O 1
    public ListNode removeElements2(ListNode head, int val) 
    {
    	while(head != null)
    	{
    		if(head.val != val)
    		{
    			break;
    		}
    		head = head.next;
    	}
    	ListNode cur = head;
    	ListNode pre = null;
    	while(cur != null)
    	{
    		if(cur.val != val)
    		{
    			pre = cur;
    		}
    		else
    		{
    			pre.next = cur.next;
    		}
    		cur = cur.next;
    	}
    	return head;
    }
}
