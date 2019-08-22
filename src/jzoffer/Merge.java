package jzoffer;


public class Merge
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
    public ListNode merge(ListNode list1,ListNode list2) 
    {
    	if(list1 == null || list2 == null)
    	{
    		return list1 != null ? list1 : list2;
    	}
    	
    	ListNode head = new ListNode(-1);
    	ListNode cur = head;
    	while(list1 != null && list2 != null)
    	{
    		if(list1.val < list2.val)
    		{
    			cur.next = list1;
    			list1 = list1.next;
    		}
    		else
    		{
    			cur.next = list2;
    			list2 = list2.next;
    		}
    		cur = cur.next;
    	}
    	while(list1 != null)
    	{
    		cur.next = list1;
    		list1 = list1.next;
    		cur = cur.next;
    	}
    	while(list2 != null)
    	{
    		cur.next = list2;
    		list2 = list2.next;
    		cur = cur.next;
    	}
    	return head.next;
    	
    }
}
