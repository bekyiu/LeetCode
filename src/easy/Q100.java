package easy;
/*
给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Q100
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
//	public static void main(String[] args)
//	{
//		TreeNode p = new TreeNode(1);
//		TreeNode a = new TreeNode(2);
//		a.left = null;
//		a.right = null;
//		TreeNode b = new TreeNode(3);
//		b.left = null;
//		b.right = null;
//		p.left = a;
//		p.right = b;
//		
//		TreeNode q = new TreeNode(1);
//		TreeNode c = new TreeNode(2);
//		c.left = null;
//		c.right = null;
//		TreeNode d = new TreeNode(3);
//		d.left = null;
//		d.right = null;
//		q.left = c;
//		q.right = d;
//		
//		System.out.println(new Q100().isSameTree(p, q));
//	}
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
		{
			return true;
		}
		if (p == null && q != null)
		{
			return false;
		}
		if (p != null && q == null)
		{
			return false;
		}
		if (p.val != q.val)
		{
			return false;
		}
		boolean b1 = isSameTree(p.left, q.left);
		boolean b2 = isSameTree(p.right, q.right);
		return b1 && b2;
	}

}
