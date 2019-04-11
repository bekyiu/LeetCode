package easy;
//合并两个有序链表
public class Q21
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
        {
            return null;
        }
        ListNode root = new ListNode(-1);
        ListNode ptr = root;
        while(l1 != null && l2 != null)
        {
            int l1Val = l1.val;
            int l2Val = l2.val;
            if(l1Val <= l2Val)
            {

                ptr.next = l1;
                l1 = l1.next;
            }
            else
            {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if(l1 != null)
        {
            ptr.next = l1;

        }
        if(l2 != null)
        {
            ptr.next = l2;
        }
        return root.next;
    }
}
