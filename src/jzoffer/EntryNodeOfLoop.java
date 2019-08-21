package jzoffer;


public class EntryNodeOfLoop
{
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
	
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        if((pHead == null) || (pHead.next == null) || (pHead.next.next == null))
    	{
    		return null;
    	}
        // 快指针一次走两步, 慢指针一次走一步
    	ListNode fast = pHead;
    	ListNode slow = pHead;
    	// 第一次走
    	slow = slow.next;
    	fast = fast.next.next;
    	while(slow != fast)
    	{
    		if(fast.next == null || fast.next.next == null)
    		{
    			return null;
    		}
    		slow = slow.next;
        	fast = fast.next.next;
    	}
    	// 一定会在第一个入环节点相遇
    	fast = pHead;
    	while(fast != slow)
    	{
    		slow = slow.next;
    		fast = fast.next;
    	}
    	return fast;
    }
}
