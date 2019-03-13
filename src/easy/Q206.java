package easy;


/*
 * 反转一个单链表。
 * 方式一: 新建一个头结点, 每次都查在头结点的后面
 * 方式二: 原地翻转, 使用三个指针
 */
public class Q206
{
	//原地翻转
	public ListNode reverseList(ListNode head) 
    {
        if(head == null)
        {
            return null;
        }
        if(head.next == null)
        {
            return head;
        }
        
        ListNode n1 = head;
        ListNode n2 = head.next;
        ListNode n3 = null;//用于保存下一个待翻转的节点
        n1.next = null;
        while(n2 != null)
        {
        	n3 = n2.next;//先保存
        	n2.next = n1;//翻转
        	n1 = n2;
        	n2 = n3;
        }
        return n1;
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
