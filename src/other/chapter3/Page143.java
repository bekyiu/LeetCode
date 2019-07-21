package other.chapter3;


public class Page143
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
	
	public boolean p(TreeNode t1, TreeNode t2)
	{
		// t2的值是不变的, 所以说t2为null的话说明一开始传进来就是null
		if(t2 == null)
		{
			return true;
		}
		// 因为此时t1 == null, 但是t2是肯定不为null的, 说明肯定配不上
		if(t1 == null)
		{
			return false;
		}
		return check(t1, t2) || p(t1.left, t2) || p(t1.right, t2);
	}
	// h是t1上的某个结点, 判断从h开始和t2配, 是否能配出t2
	public boolean check(TreeNode h, TreeNode t2)
	{
		// t2 == null && h == null
		if(t2 == null) 
		{
			return true;
		}
		// 如果h为null的话t2也必定为null, 但走到这一步显然是不可能了
		// 说明h都走到空节点了, 但t2还有只
		if(h == null || h.val != t2.val)
		{
			return false;
		}
		// 如果h.val == t2.val的话, 并不能确定从h开始可以配出整个t2, 还要交给后续过程判断
		// 先序遍历
		return check(h.left, t2.left) && check(h.right, t2.right);
	}
}
