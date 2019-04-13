package other.chapter3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Page93
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

	private List<Integer> res = new ArrayList<>();

	public List<Integer> preorderTraversal(TreeNode root)
	{
		if (root == null)
		{
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty())
		{
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if (cur.right != null)
			{
				stack.push(cur.right);
			}
			if (cur.left != null)
			{
				stack.push(cur.left);
			}
		}
		return res;
	}

	public List<Integer> inorderTraversal(TreeNode root)
	{
		if (root == null)
		{
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null)
		{
			if (cur != null)
			{
				stack.push(cur);
				cur = cur.left;
			} else
			{
				cur = stack.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}

	public List<Integer> postorderTraversal(TreeNode root)
	{
		if (root == null)
		{
			return res;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		Deque<TreeNode> help = new ArrayDeque<>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode cur = stack.pop();
			help.push(cur);
			if(cur.left != null)
			{
				stack.push(cur.left);
			}
			if(cur.right != null)
			{
				stack.push(cur.right);
			}
		}
		while(!help.isEmpty())
		{
			res.add(help.pop().val);
		}
		return res;
	}
}
