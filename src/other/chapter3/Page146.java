package other.chapter3;


public class Page146
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
	
	class ReturnType
	{
		int h;
		boolean isB;
		public ReturnType(int h, boolean isB)
		{
			this.h = h;
			this.isB = isB;
		}
	}
	
	public boolean isOk(TreeNode head)
	{
		return p(head).isB;
	}
	
	public ReturnType p(TreeNode head)
	{
		if(head == null)
		{
			return new ReturnType(0, true);
		}
		ReturnType left = p(head.left);
		ReturnType right = p(head.right);
		if(left.isB && right.isB && Math.abs(left.h - right.h) <= 1)
		{
			return new ReturnType(Math.max(left.h, right.h) + 1, true);
		}
		// return false的话高度已经无所谓了
		return new ReturnType(0, false);
	}
}
