package jzoffer;

import java.util.ArrayList;

public class FindPath
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
	// 链接：https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca?f=discussion
	// 来源：牛客网

	private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target)
	{
		if (root == null)
			return listAll;
		list.add(root.val);
		target -= root.val;
		// 走到这一步后, target等于零并且是叶节点, 说明找到一条路径
		if (target == 0 && root.left == null && root.right == null)
			listAll.add(new ArrayList<Integer>(list));
		findPath(root.left, target);
		findPath(root.right, target);
		// 回退一步
		list.remove(list.size() - 1);
		return listAll;
	}
}
