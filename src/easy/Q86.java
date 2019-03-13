package easy;


/*
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 思路, 准备一个less头结点和一个other头结点
 * 遍历链表, 如果这个值小于x就挂在less后面, 如果大于等于就挂在other后面
 * 最后让less的最后一个节点指向other.next即可
 */
public class Q86
{
    public ListNode partition(ListNode head, int x) 
    {
        if(head == null)
        {
        	return null;
        }
        if(head.next == null)
        {
        	return head;
        }
        ListNode less = new ListNode(-1);
        ListNode other = new ListNode(-1);
        ListNode p1 = less;
        ListNode p2 = other;
        ListNode p3 = head;
        while(p3 != null)
        {
        	//先记录下一个位置
        	ListNode tmp = p3.next;
        	//取下当前节点, 准备插入less或者other
        	p3.next = null;
        	if(p3.val < x)
        	{
        		p1.next = p3;
        		p1 = p1.next;
        	}
        	else
        	{
        		p2.next = p3;
        		p2 = p2.next;
        	}
        	p3 = tmp;
        }
        //将两个链表连起来
        p1.next = other.next;
        return less.next;
    }
    
    public static void main(String[] args)
	{
		
	}
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
}
