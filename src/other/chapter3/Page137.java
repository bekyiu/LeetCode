package other.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Page137
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
	// 改非递归中序遍历
	public TreeNode[] p(TreeNode head)
	{
		TreeNode[] errs = new TreeNode[2];
		if(head == null)
		{
			return errs;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = head;
		TreeNode pre = null;
		while(cur != null || !stack.isEmpty())
		{
			if(cur != null)
			{
				stack.push(cur);
				cur = cur.left;
			}
			else
			{
				cur = stack.pop();
				//..
				if(pre != null && pre.val > cur.val)
				{
					errs[0] = errs[0] == null ? pre : errs[0];
					errs[1] = cur;
				}
				pre = cur;
				cur = cur.right;
			}
		}
		return errs;
	}
}
