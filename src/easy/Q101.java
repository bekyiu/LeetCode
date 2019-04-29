package easy;

//层序遍历 检查每一层是不是回文
//判断这棵树是否和他的镜像相等
public class Q101
{
	class TreeNode
	{
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val)
		{
			this.val = val;
		}
	}
	
    public boolean isSymmetric(TreeNode root) 
    {
    	if(root == null)
    	{
    		return true;
    	}
    	return fun(root, root);
    }
    //两种先根的遍历 根 左 右, 根 右 左
    public boolean fun(TreeNode p, TreeNode q)
    {
    	if(p == null && q == null)
    	{
    		return true;
    	}
    	if(p == null && q != null)
    	{
    		return false;
    	}
    	if(p != null && q == null)
    	{
    		return false;
    	}
    	if(p.val != q.val)
    	{
    		return false;
    	}
    	return fun(p.left, q.right) && fun(p.right, q.left);
    }
    
}
