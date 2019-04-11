package other.chapter2;

public class Page84
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

	public static void main(String[] args)
	{

	}

	public ListNode selectionSort(ListNode head)
	{
		ListNode tail = null; // 排序部分的尾部
		ListNode cur = head; // 未排序部分的头部
		ListNode preMin = null; // 最小值节点的前一个节点
		ListNode min = null; // 最小值节点
		while (cur != null)
		{
			// 寻找未排序部分中的最小值节点的前一个节点
			min = cur;
			preMin = findSmallestPreNode(cur);
			// 如果找到了
			if (preMin != null)
			{
				min = preMin.next;
				preMin.next = min.next;
			}
			if (tail == null)
			{
				//只有第一次会进来, 第一次的min一定是最小的, 用于返回
				head = min;
			} 
			else
			{
				tail.next = min;
			}
			tail = min;
			//只有当cur是最小值的时候才往下走
			//不然选出的值可能并不是最小值
			cur = cur == min ? cur.next : cur;
		}
		return head;

	}

	private ListNode findSmallestPreNode(ListNode head)
	{
		// 最小值节点
		ListNode min = head;
		// 最小值节点的前面一个节点
		ListNode preMin = null;
		// 当前节点的前一个节点
		ListNode pre = head;
		// 当前节点
		ListNode cur = head.next;
		while (cur != null)
		{
			if (cur.val < min.val)
			{
				preMin = pre;
				min = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return preMin;
	}

}
