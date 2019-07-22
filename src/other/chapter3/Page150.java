package other.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Page150
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
	
	public boolean isBST(TreeNode head)
	{
		TreeNode cur = head;
		Deque<TreeNode> stack = new ArrayDeque<>();
		long pre = Long.MIN_VALUE;
		while(!stack.isEmpty() || cur != null)
		{
			if(cur != null)
			{
				stack.push(cur);
				cur = cur.left;
			}
			else
			{
				cur = stack.pop();
				if(pre >= cur.val)
				{
					return false;
				}
				else
				{
					pre = (long)cur.val;
				}
				cur = cur.right;
			}
		}
		return true;
	}
	
	public boolean isCBT(TreeNode head)
	{
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(head);
		boolean flag = false;
		while(!queue.isEmpty())
		{
			TreeNode cur = queue.poll();
			if(flag)
			{
				if(cur.left != null || cur.right != null)
				{
					return false;
				}
			}
			if(!flag && cur.left == null && cur.right != null)
			{
				return false;
			}
			if(!flag && (cur.left == null || cur.right == null))
			{
				flag = true;
			}
			if(cur.left != null)
			{
				queue.add(cur.left);
			}
			if(cur.right != null)
			{
				queue.add(cur.right);
			}
		}
		return true;
	}
	
}
