package other.chapter3;

import util.TreeNode;

public class Page168
{
	class ReturnType
	{
		public int h;
		public int distance;
		public ReturnType(int h, int distance)
		{
			this.h = h;
			this.distance = distance;
		}
	}
	
	public int getMaxD(TreeNode head)
	{
		return p(head).distance;
	}
	
	public ReturnType p(TreeNode node)
	{
		if(node == null)
		{
			return new ReturnType(0, 0);
		}
		
		ReturnType left = p(node.left);
		ReturnType right = p(node.right);
		
		int h = Math.max(left.h, left.h) + 1;
		
		int p1 = left.h + 1 + right.h;
		int p2 = left.distance;
		int p3 = right.distance;
		
		int distance = Math.max(Math.max(p2, p3), p1);
		return new ReturnType(h, distance);
	}
}
