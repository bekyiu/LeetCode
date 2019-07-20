package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Page132
public class Q103
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
		if(root == null)
		{
			return new ArrayList<>();
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		List<List<Integer>> res = new ArrayList<>();
		// true表示从左往右打印, false表示从右往左打印
		boolean direct = true;
		queue.addLast(root);
		while(!queue.isEmpty())
		{
			int count = queue.size();
			// 因为涉及元素移动, 还可能有扩容问题 所以不用ArrayList
			List<Integer> list = new LinkedList<>();
			while(count > 0)
			{
				TreeNode cur = queue.poll();
				if(direct)
				{
					list.add(cur.val);
				}
				else
				{
					// LinkedList会把 [0, n]位置的数向后平移一个位置, 然后插入cur.val
					list.add(0, cur.val);
				}
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
			res.add(list);
			direct = !direct;
		}
		return res;
    }
}
