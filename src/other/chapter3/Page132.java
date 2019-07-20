package other.chapter3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Q102, Q103
public class Page132
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

	// 与书上的解法不同
	public void printByLevel(TreeNode head)
	{
		if (head == null)
		{
			return;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(head);
		while (!queue.isEmpty())
		{
			// 一层 有多少个节点
			int count = queue.size();
			while (count > 0)
			{
				TreeNode cur = queue.poll();
				System.out.print(cur.val + " ");
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
			// 打印完一层之后换行
			System.out.println();
		}
	}

	// 与书上的解法不同
	public void printByZigZag(TreeNode head)
	{
		if(head == null)
		{
			return;
		}
		Deque<TreeNode> deque = new ArrayDeque<>();
		// true表示从左往右打印, false表示从右往左打印
		boolean direct = true;
		deque.addLast(head);
		while(!deque.isEmpty())
		{
			int count = deque.size();
			List<TreeNode> list = new ArrayList<>();
			while(count > 0)
			{
				TreeNode cur = deque.poll();
				if(direct)
				{
					System.out.print(cur.val + " ");
				}
				else
				{
					list.add(0, cur);
				}
				if (cur.left != null)
				{
					deque.add(cur.left);
				}
				if (cur.right != null)
				{
					deque.add(cur.right);
				}
				count--;
			}
			if(!direct)
			{
				for (TreeNode treeNode : list)
				{
					System.out.print(treeNode.val);
				}
			}
			direct = !direct;
			System.out.println();
		}
	}
}
