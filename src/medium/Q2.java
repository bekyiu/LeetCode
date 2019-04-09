package medium;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

public class Q2
{
	public static void main(String[] args)
	{
		
	}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
    	ListNode c1 = l1;
    	ListNode c2 = l2;
    	int n1 = 0;
    	int n2 = 0;
    	int n = 0;
    	int ca = 0;
    	ListNode pre = null;
    	ListNode node = null;
    	//用于记录生成的那个链表的头
    	ListNode res = null;
    	while(c1 != null || c2 != null)
    	{
    		n1 = c1 == null ? 0 : c1.val;
    		n2 = c2 == null ? 0 : c2.val;
    		n = n1 + n2 + ca;
    		pre = node;
    		node = new ListNode(n % 10);
    		//第一次一定会进入这个if
    		if(pre == null)
    		{
    			pre = node;
    			res = node;
    		}
    		else
    		{
    			pre.next = node;
    		}
    		ca = n / 10;
    		c1 = c1 == null ? null : c1.next;
    		c2 = c2 == null ? null : c2.next;
    	}
    	if(ca == 1)
    	{
    		pre = node;
    		node = new ListNode(1);
    		pre.next = node;
    	}
    	return res;
    }
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
		}
	}
}


