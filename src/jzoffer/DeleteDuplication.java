package jzoffer;

public class DeleteDuplication
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

	// 删除所有的重复节点
	public ListNode deleteDuplication(ListNode pHead)
	{
		if (pHead == null)
		{
			return null;
		}
		ListNode cur = pHead;
		// 永远指向当前节点的前一个节点, 方便删除
		ListNode pre = null;
		while (cur != null)
		{
			boolean needDelete = false;
			ListNode pNext = cur.next;
			if (pNext != null && pNext.val == cur.val)
			{
				needDelete = true;
			}
			if (!needDelete)
			{
				pre = cur;
				cur = pNext;
			} 
			else
			{
				ListNode tobeDelete = pNext;
				while (tobeDelete != null && tobeDelete.val == cur.val)
				{
					tobeDelete = tobeDelete.next;
				}
				// 此时tobeDelete指向的是跳过了一堆和cur重复的节点之后
				// 第一个和cur不等的节点
				cur = tobeDelete;
				// 从头结点开始一直都是重复的
				if (pre == null)
				{
					pHead = cur;
				} 
				else
				{
					pre.next = cur;
				}
			}
		}
		return pHead;
	}
	
	// 一组重复的节点中留一个
	public ListNode deleteDuplication2(ListNode pHead)
	{
		if (pHead == null)
		{
			return null;
		}
		ListNode cur = pHead;
		// 永远指向当前节点的前一个节点, 方便删除
		ListNode pre = null;
		while (cur != null)
		{
			boolean needDelete = false;
			ListNode pNext = cur.next;
			if (pNext != null && pNext.val == cur.val)
			{
				needDelete = true;
			}
			if (!needDelete)
			{
				pre = cur;
				cur = pNext;
			} 
			else
			{
				// 差异
				ListNode tobeDelete = cur;
				while (tobeDelete.next != null && tobeDelete.next.val == cur.val)
				{
					tobeDelete = tobeDelete.next;
				}
				// 此时tobeDelete指向的一堆和cur重复的节点中的最后一个节点
				cur = tobeDelete;
				// 从头结点开始一直都是重复的
				if (pre == null)
				{
					pHead = cur;
				} 
				else
				{
					pre.next = cur;
				}
			}
		}
		return pHead;
	}
}
