package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
 * 给定一个二叉树，返回它的中序 遍历
 * 非递归思路:
 * 		当前节点不为空, 压栈, 然后往左走
 * 		当前节点为空, 从栈里取一个, 打印, 然后往右走
 * 		直到栈空了 并且当前节点为null
 */


public class Q94
{
	private List<Integer> res = new ArrayList<>();

	// 递归
	// public List<Integer> inorderTraversal(TreeNode root) {
	// if(root == null)
	// {
	// return res;
	// }
	// fun(root);
	// return res;
	// }
	//
	// public void fun(TreeNode cur)
	// {
	// if(cur != null)
	// {
	// fun(cur.left);
	// res.add(cur.val);
	// fun(cur.right);
	// }
	// }
	// 非递归
	public List<Integer> inorderTraversal(TreeNode root)
	{
		if (root == null)
		{
			return res;
		}
		TreeNode cur = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
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
				res.add(cur.val);
				cur = cur.right;
			}
		}
		return res;
	}

	public static void main(String[] args)
	{

	}

	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}
}
