package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 思路1:
 * 		层序遍历, 如果遍历到空, 还有节点没有遍历, 那么就不是完全二叉树
 * 思路2:
 * 		层序遍历该树, 
 * 		如果当前节点有右子树但是没有左子树, return false;
 * 		如果当前节点两个子树都没有或者有左子树没有右子树, 那么当前节点的后面所有的节点, 一定是叶节点
 */
public class Q958
{
	public boolean isCompleteTree2(TreeNode root)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		boolean leaf = false;
		TreeNode cur = root;
		TreeNode l;
		TreeNode r;
		queue.add(cur);
		while (!queue.isEmpty())
		{
			cur = queue.poll();
			l = cur.left;
			r = cur.right;
			// 如果已经开启 后续节点遇到的都应当是叶节点 这个阶段,
			if ((leaf && (l != null || r != null)) // 那么只要 左右子树有一个不空就返回false
					|| (l == null && r != null))
			{
				return false;
			}
			if (l != null)
			{
				queue.add(cur.left);
			}
			if (r != null)
			{
				queue.add(cur.right);
			}
			if (l == null || r == null)// 前面已经排除左空右不空的情况
			{
				leaf = true;// 开启阶段
			}
		}
		return true;
	}

	public boolean isCompleteTree1(TreeNode root)
	{
		// 这个可以存null
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = root;
		queue.add(cur);
		while (true)
		{
			cur = queue.poll();
			if (cur == null)
			{
				break;
			}
			queue.add(cur.left);
			queue.add(cur.right);
		}
		while (!queue.isEmpty())
		{
			TreeNode temp = queue.poll();
			if (temp != null)
			{
				return false;
			}
		}
		return true;
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
