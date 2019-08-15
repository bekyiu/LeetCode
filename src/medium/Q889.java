package medium;


public class Q889
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) 
    {
        if(pre == null || post == null || pre.length == 0 || post.length == 0)
        {
        	return null;
        }
        return p(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }
    public TreeNode p(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd)
    {
    	TreeNode node = new TreeNode(pre[preStart]);
    	// 说明是叶节点
    	if(preStart == preEnd && postStart == postEnd)
    	{
    		return node;
    	}
    	// 当前根的左子树的根结点在后序数组中的位置, 可以把后续数组的左子树和右子树分开
    	int val = pre[preStart + 1];
    	int root = 0;
    	for(root = postStart; root <= postEnd; root++)
    	{
    		if(post[root] == val)
    		{
    			break;
    		}
    	}
    	// 找出左右子树的区间
    	int leftLength = root - postStart + 1;
    	int rightLength = postEnd - root - 1;
    	// 如果还有左右子树的话
    	if(leftLength > 0)
    	{
    		node.left = p(pre, post, preStart + 1, preStart + leftLength, postStart, root);
    	}
    	if(rightLength > 0)
    	{
    		node.right = p(pre, post, preStart + leftLength + 1, preEnd, root + 1, postEnd - 1);
    	}
    	return node;
    }
}
