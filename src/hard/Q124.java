package hard;

/*
 * 这道题的难点在于 递归函数的返回值并不是最终问题的解
 * 需要使用另外一个变量来记录这个解
 */
public class Q124
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
	public int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        p(root);
        return max;
    }
    
    // 返回当前节点和左右子树相加组成的最大值
    public int p(TreeNode node)
	{
        if(node == null)
        {
            return 0;
        }
        
		int left = p(node.left);
		int right = p(node.right);
		max = Math.max(max, left + right + node.val);
		int temp = Math.max(left, right) + node.val;
		/*
		 *  temp 必须要大于0才返回temp, 否则返回0(代表这条路径不选择), 不然会影响最大值的决策
		 *  考虑		2   这种情况, 显然最大值是2
		 *  	   / \
		 *  	 -1  -1 
		 *  但如果左右返回的left和right都是-1, 那么计算最大值就变成了0
		 *  
		 */
		return temp > 0 ? temp : 0;
	}
}
