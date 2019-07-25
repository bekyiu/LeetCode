package other.chapter3;

public class Page176
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
	
	// 看node节点一直往左走能走到哪一次
	public int mostLeftLevel(TreeNode node, int level)
	{
		while(node != null)
		{
			level++;
			node = node.left;
		}
		return level - 1;
	}
	
	// 返回以node为头结点的完全二叉树的结点数是多少
	// h是树的高度, l是node所在的层数
	public int bs(TreeNode node, int l, int h)
	{
		if(l == h)
		{
			return 1;
		}
		if(mostLeftLevel(node.right, l + 1) == h)
		{
			return (1 << (h - l)) + bs(node.right, l + 1, h);
		}
		else
		{
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}
	}
    public int countNodes(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }
        return bs(root, 1, mostLeftLevel(root, 1));
    }
}
