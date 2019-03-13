package easy;


/*
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 思路:
 * 		如果当前节点的左子树是平衡二叉树, 并且当前节点的右子树是平衡二叉树
 * 		并且abs(左子树高度 - 右子树高度) <= 1 那么以当前节点为根的二叉树就是平衡二叉树
 * 所以, 我们需要收集左右子树的两个信息: 是否是平衡二叉树, 以及他们的高度
 */
public class Q110
{
	// 用于存储收集来的信息
	class ReturnType
	{
		boolean isB;
		int h;
		public ReturnType(boolean isB, int h)
		{
			this.isB = isB;
			this.h = h;
		}
	}
	public ReturnType fun(TreeNode cur)
	{
		if (cur == null)
		{
			return new ReturnType(true, 0);
		}
		ReturnType left = fun(cur.left);
		if (!left.isB)
		{
			return new ReturnType(false, 0);
		}
		ReturnType rigth = fun(cur.right);
		if (!rigth.isB)
		{
			return new ReturnType(false, 0);
		}
		if(Math.abs(left.h - rigth.h) > 1)
		{
			return new ReturnType(false, 0);
		}
		return new ReturnType(true, Math.max(left.h, rigth.h) + 1);
	}
	public boolean isBalanced(TreeNode root)
	{
		return fun(root).isB;
	}

	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}

}
