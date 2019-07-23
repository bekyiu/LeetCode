package other.chapter3;


public class Page155
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
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
    	if(root == null || root == p || root == q)
    	{
    		return root;
    	}
    	TreeNode left = lowestCommonAncestor(root.left, p, q);
    	TreeNode right = lowestCommonAncestor(root.right, p, q);
    	
    	if(left != null && right != null)
    	{
    		return root;
    	}
    	// 如果左右有一个不为空, 那个不为空的节点就是p或q或最近的公共祖先
    	// 都为空的话说明当前root节点的左右子树中没有p或q, 所以返回空
    	return left != null ? left : right;
    }
}
