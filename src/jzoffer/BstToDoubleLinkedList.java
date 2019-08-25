package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class BstToDoubleLinkedList
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}
	
	private Deque<TreeNode> queue = new ArrayDeque<>();
	public TreeNode convert(TreeNode head) 
	{
		if(head == null)
		{
			return null;
		}
		// 中序遍历把节点放入队列
		inOrder(head);
		// 再连起来
		TreeNode pre = null;
		TreeNode cur = null;
		TreeNode newHead = null;
		TreeNode next = null;
		while(!queue.isEmpty())
		{
			cur = queue.pollFirst();
			next = queue.peekFirst();
			cur.left = pre;
			cur.right = next;
			pre = cur;
			newHead = newHead == null ? cur : newHead;
		}
		return newHead;
	}
	
	public void inOrder(TreeNode node)
	{
		if(node != null)
		{
			inOrder(node.left);
			queue.addLast(node);
			inOrder(node.right);
		}
	}
}
