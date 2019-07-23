package other.chapter3;

public class Page153
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x)
		{
			val = x;
		}
	}
	
	public TreeNode getNextNode(TreeNode node)
	{
		if(node == null)
		{
			return null;
		}
		// 情况1: node的后继是右子树上最左的节点
		if(node.right != null)
		{
			TreeNode cur = node.right;
			while(cur.left != null)
			{
				cur = cur.left;
			}
			return cur;
		}
		// 情况2: 如果没有右子树, 先看当前node是不是parent的左孩子, 如果是
		// parent就为后继
		if(node.parent.left == node)
		{
			return node.parent;
		}
		// 情况2: 没有右子树, 且当前node不是parent的左孩子
		// 就顺着parent往上找, 一直找到一个节点s, 他的parent是p, 且s是p的左孩子
		// 那么p就是当前node的后继
		TreeNode cur = node;
		TreeNode parent = cur.parent;
		while(parent != null)
		{
			if(parent.left != cur)
			{
				cur = parent;
				parent = cur.parent;
			}
			else
			{
				return parent;
			}
		}
		// 情况3: 找到null了都没找到s和p, 说明没得后继, 返回空
		return null;
	}
}
