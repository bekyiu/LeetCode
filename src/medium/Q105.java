package medium;


public class Q105
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
	
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
        {
        	return null;
        }
        return p(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode p(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd)
    {
    	TreeNode node = new TreeNode(pre[preStart]);
    	node.left = null;
    	node.right = null;
    	// 说明是叶节点
    	if(preStart == preEnd && inStart == inEnd)
    	{
    		return node;
    	}
    	// 找到node在中序遍历中的位置
    	int root = 0;
    	for(root = inStart; root <= inEnd; root++)
    	{
    		if(pre[preStart] == in[root])
    		{
    			break;
    		}
    	}
    	// 找出左右子树的区间
    	int leftLength = root - inStart;
    	int rightLength = inEnd - root;
    	// 如果还有左右子树的话
    	if(leftLength > 0)
    	{
    		node.left = p(pre, in, preStart + 1, preStart + leftLength, inStart, root - 1);
    	}
    	if(rightLength > 0)
    	{
    		node.right = p(pre, in, preStart + leftLength + 1, preEnd, root + 1, inEnd);
    	}
    	return node;
    }
}
