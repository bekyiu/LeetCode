package jzoffer;

// 按 根 左 右, 和 根 右 左的顺序遍历比较(null也要比, 因为数值可能全部一样), 相同则是对称的
public class IsSymmetrical
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
	
    public boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot, pRoot);
    }
    
    public boolean isSymmetrical(TreeNode r1, TreeNode r2)
    {
        if(r1 == null && r2 == null)
        {
            return true;
        }
        // 此时说明r1, r2至少有一个不为null
        if(r1 == null || r2 == null)
        {
            return false;
        }
        if(r1.val != r2.val)
        {
            return false;
        }
        return isSymmetrical(r1.left, r2.right) && isSymmetrical(r1.right, r2.left);
    }
}
