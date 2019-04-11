package other.chapter2;


//LeetCode237
public class Page86
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
    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.val = temp.val;
        //删temp
        node.next = temp.next;
    }
}
