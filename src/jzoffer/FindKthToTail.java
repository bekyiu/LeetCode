package jzoffer;

public class FindKthToTail
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
    public ListNode findKthToTail(ListNode head,int k) 
    {
        if(head == null || k <= 0)
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先移动k - 1步, 然后慢指针和快指针一起移动
        for(int i = 0; fast != null && i < k - 1; i++)
        {
            fast = fast.next;
        }
        // 不存在倒数第k个节点
        if(fast == null)
        {
            return null;
        }
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
