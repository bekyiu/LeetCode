package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * 给定一个二叉树，返回它的 前序 遍历。
 * 非递归思路:
 * 		从栈中弹出一个结点, 输出他
 * 		如果有右孩子先压右孩子
 * 		如果有左孩子, 再压左孩子
 */
public class Q144
{
	private List<Integer> res = new ArrayList<>();
	//递归版本
//	public List<Integer> preorderTraversal(TreeNode root)
//	{
//		if(root == null)
//		{
//			return res;
//		}
//		fun(root);
//		return res;
//	}
//	public void fun(TreeNode cur)
//	{
//		if(cur != null)
//		{
//			res.add(cur.val);
//			fun(cur.left);
//			fun(cur.right);
//		}
//	}
	//非递归版本
	public List<Integer> preorderTraversal(TreeNode root)
	{
		if(root == null)
		{
			return res;
		}
		TreeNode cur = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(cur);
		while(!stack.isEmpty())
		{
			cur = stack.pop();
			res.add(cur.val);
			if(cur.right != null)
			{
				stack.push(cur.right);
			}
			if(cur.left != null)
			{
				stack.push(cur.left);
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
