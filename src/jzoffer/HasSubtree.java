package jzoffer;

public class HasSubtree
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
	// 先找到 root2的根在root1中出现的位置, 然后开始比较
    public boolean hasSubtree(TreeNode root1,TreeNode root2) 
    {
    	if(root1 == null || root2 == null)
    	{
    		return false;
    	}
    	return check(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }
    
    public boolean check(TreeNode h, TreeNode root2)
    {
    	// 空树是任何一棵树的子结构
    	if(root2 == null)
    	{
    		return true;
    	}
    	// 此时说明root2不为null, 但h为null, 说明肯定不是子树结构
    	if(h == null || h.val != root2.val)
    	{
    		return false;
    	}
    	return check(h.left, root2.left) && check(h.right, root2.right);
    }
}
