package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 思路:
 * 		中序遍历后升序, 则为bst
 * 		使用非递归的版本
 */
public class Q98
{
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
    public boolean isValidBST(TreeNode root) {
    	if(root == null)
    	{
    		return false;
    	}
    	Long min = Long.MIN_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
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
        		//不能是等于, 因为bst的特性
        		if(cur.val > min)
        		{
        			min = (long) cur.val;
        		}
        		else
        		{
        			return false;
        		}
        		cur = cur.right;
        	}
        }
        return true;
    }
}
