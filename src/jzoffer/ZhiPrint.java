package jzoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

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

public class ZhiPrint
{
	// 思路还是带换行的层序遍历
	public ArrayList<ArrayList<Integer>> print(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		if (root == null)
		{
			return list;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int flag = 1;
		while (!queue.isEmpty())
		{
			ArrayList<Integer> level = new ArrayList<>();
			int count = queue.size();
			while (count > 0)
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
			// 奇数 从左向右打印, 偶数从右向左打印
			if((flag & 1) == 1)
			{
				list.add(level);
			}
			else
			{
				Collections.reverse(level);
				list.add(level);
			}
			flag++;
		}
		return list;
	}
}
