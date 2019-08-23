package jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class PrintFromTopToBottom
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

	public ArrayList<Integer> printFromTopToBottom(TreeNode root)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null)
		{
			return list;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			TreeNode cur = queue.poll();
			list.add(cur.val);
			if (cur.left != null)
			{
				queue.add(cur.left);
			}
			if (cur.right != null)
			{
				queue.add(cur.right);
			}
		}
		return list;
	}

	// 分行打印
	public ArrayList<ArrayList<Integer>> print(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
		{
			return list;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty())
		{
			ArrayList<Integer> level = new ArrayList<>();
			int count = queue.size();
			while(count > 0)
			{
				TreeNode cur = queue.poll();
				level.add(cur.val);
				if (cur.left != null)
				{
					queue.add(cur.left);
				}
				if (cur.right != null)
				{
					queue.add(cur.right);
				}
				count--;
			}
			list.add(level);
		}
		return list;
	}
}
