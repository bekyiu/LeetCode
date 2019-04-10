package other.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;

//LeetCode 25
public class Page74
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
    public ListNode reverseKGroup(ListNode head, int k) 
    {
        if(k < 2)
        {
        	return head;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        ListNode newHead = head;
        while(cur != null)
        {
        	next = cur.next;
        	stack.push(cur);
        	if(stack.size() == k)
        	{
        		pre = resign1(stack, pre, next);
        		newHead = newHead == head ? cur : newHead;
        	}
        	cur = next;
        }
        return newHead;
    }
    
    private ListNode resign1(Deque<ListNode> stack, ListNode left, ListNode right)
    {
    	ListNode cur = stack.pop();
    	if(left != null)
    	{
    		left.next = cur;
    	}
    	ListNode next = null;
    	while(!stack.isEmpty())
    	{
    		next = stack.pop();
    		cur.next = next;
    		cur = next;
    	}
    	cur.next = right;
    	return cur;
    }
    //额外空间 O 1
    public ListNode reverseKGroup2(ListNode head, int k) 
    {
        if(k < 2)
        {
        	return head;
        }
        ListNode cur = head;
        ListNode next = null;
        ListNode start = null;
        ListNode pre = null;
        int count = 1;
        while(cur != null)
        {
        	next = cur.next;
        	if(count == k)
        	{
        		start = pre == null ? head : pre.next;
        		head = pre == null ? cur : head;
        		reverse(pre, start, cur, next);
        		pre = start;
        		count = 0;
        	}
        	cur = next;
        	count++;
        }
        return head;
    }
    
    private void reverse(ListNode left, ListNode start, ListNode end, ListNode right)
    {
    	//这三个变量是翻转链表用的, 和上面同名变量的意义并不一样
    	ListNode pre = start;
    	ListNode cur = start.next;
    	ListNode next = null;
    	while(cur != right)
    	{
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	if(left != null)
    	{
    		left.next = end;
    	}
    	start.next = right;
    }
}
