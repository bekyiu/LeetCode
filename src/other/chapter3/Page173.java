package other.chapter3;

import java.util.LinkedList;
import java.util.List;

public class Page173
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
	// n个节点的二叉搜索树有多少种可能
	public int numTrees(int n)
	{
		if (n <= 1)
		{
			return 1;
		}
		int sum = 0;
		// 以每一个节点为头
		for (int i = 1; i <= n; i++)
		{
			sum += numTrees(i - 1) * numTrees(n - i);

		}
		return sum;
	}

	// dp版本
	public int dpMethod(int n)
	{
		if (n <= 1)
		{
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		//dp[i]表示: n = i的时候, 构成的二叉树有dp[i]种可能
		for (int i = 2; i < dp.length; i++)
		{
			// 以每一个节点为头
			for (int j = 1; j <= i; j++)
			{
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

	// 生成对应的树
    public List<TreeNode> generateTrees(int n) 
    {
    	if(n == 0)
    	{
    		return new LinkedList<>();
    	}
    	return g(1, n);
    }
    // 返回[start, end]生成的所有bst的head的集合
    public List<TreeNode> g(int start, int end)
    {
    	List<TreeNode> res = new LinkedList<>();
    	if(start > end)
    	{
    		res.add(null);
    	}
    	TreeNode head = null;
    	// 以每个位置为头生成树
    	for(int i = start; i <= end; i++)
    	{
    		head = new TreeNode(i);
    		List<TreeNode> left = g(start, i - 1);
    		List<TreeNode> right = g(i + 1, end);
    		for (TreeNode l : left)
			{
				for (TreeNode r : right)
				{
					head.left = l;
					head.right = r;
					res.add(clone(head));
				}
			}
    	}
    	return res;
    }
    
    // 复制出一颗新树, 是的每一刻树都是独立的, 不互相交叉
    public TreeNode clone(TreeNode head)
    {
    	if(head == null)
    	{
    		return null;
    	}
    	TreeNode res = new TreeNode(head.val);
    	res.left = clone(head.left);
    	res.right = clone(head.right);
    	return res;
    }
    
	public static void main(String[] args)
	{
		int z = new Page173().numTrees(3);
		System.out.println(z);
	}

}
