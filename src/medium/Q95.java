package medium;

import java.util.LinkedList;
import java.util.List;
// Page173
public class Q95
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
    	{
    		return new LinkedList<>();
    	}
        return g(1, n);
    }
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
}
