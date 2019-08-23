package jzoffer;

public class ReConstructBinaryTree
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
    public TreeNode reConstructBinaryTree(int[] pre,int[] in) 
    {
    	if(pre == null || in == null || pre.length == 0 || in.length == 0)
    	{
    		return null;
    	}
    	return p(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
    
    public TreeNode p(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd)
    {
    	if(preStart > preEnd || inStart > inEnd)
    	{
    		return null;
    	}
    	TreeNode head = new TreeNode(pre[preStart]);
    	int index = 0;
    	for(int i = inStart; i <= inEnd; i++)
    	{
    		if(pre[preStart] == in[i])
    		{
    			index = i;
    			break;
    		}
    	}
    	int leftNum = index - inStart;
    	int rightNum = inEnd - index;
    	if(leftNum > 0)
    	{
    		head.left = p(pre, preStart + 1, preStart + leftNum, in, inStart, index - 1);
    	}
    	if(rightNum > 0)
    	{
    		head.right = p(pre, preStart + leftNum + 1, preEnd, in, index + 1, inEnd);
    	}
    	return head;
    }
}
