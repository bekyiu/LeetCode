package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/*
 * 二叉树的层次遍历
 */
public class Q102
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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
        {
        	return res;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
        	//一层节点的个数
        	int count = queue.size();
        	List<Integer> level = new ArrayList<>();
        	while(count > 0)
        	{
            	TreeNode cur = queue.poll();
            	TreeNode left = cur.left;
            	TreeNode right = cur.right;
            	level.add(cur.val);
            	if(left != null)
            	{
            		queue.add(left);
            	}
            	if(right != null)
            	{
            		queue.add(right);
            	}
            	count--;
        	}
        	res.add(level);
        }
        return res;
    }
    
    
}
