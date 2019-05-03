package other.chapter3;

import util.TreeNode;

public class Page121
{
	class ReturnType
	{
		public int size;
		public TreeNode head;
		public int max;
		public int min;
		public ReturnType(int size, TreeNode head, int max, int min)
		{
			this.size = size;
			this.head = head;
			this.max = max;
			this.min = min;
		}
	}
	
	public TreeNode getMaxBST(TreeNode head)
	{
		return p(head).head;
	}
	
	public ReturnType p(TreeNode node)
	{
		if(node == null)
		{
			return new ReturnType(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		ReturnType leftInfo = p(node.left);
		ReturnType rightInfo = p(node.right);
		
		int curSize = -1;
		TreeNode newHead = null;
		int max = 0;
		int min = 0;
		if(leftInfo.head == node.left && rightInfo.head == node.right 
				&& leftInfo.max < node.val && rightInfo.min > node.val)
		{
			curSize = leftInfo.size + rightInfo.size + 1;
			newHead = node;
			max = rightInfo.max;
			min = leftInfo.min;
		}
		curSize = Math.max(Math.max(leftInfo.size, rightInfo.size), curSize);
		if(newHead == null)
		{
			newHead = curSize == leftInfo.size ? leftInfo.head : rightInfo.head;
			max = curSize == leftInfo.size ? leftInfo.max : rightInfo.max;
			min = curSize == leftInfo.size ? leftInfo.min : rightInfo.min;
		}
		
		return new  ReturnType(curSize, newHead, max, min);
	}
	
	public ReturnType p2(TreeNode node)
	{
		if(node == null)
		{
			return new ReturnType(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		ReturnType leftInfo = p(node.left);
		ReturnType rightInfo = p(node.right);
		int max = Math.max(Math.max(leftInfo.max, rightInfo.max), node.val);
		int min = Math.min(Math.min(leftInfo.min, rightInfo.min), node.val);
		int size = Math.max(leftInfo.size, rightInfo.size);
		TreeNode newHead = leftInfo.size > rightInfo.size ? leftInfo.head : rightInfo.head;
		//第三种可能性
		if(leftInfo.head == node.left && rightInfo.head == node.right 
				&& leftInfo.max < node.val && rightInfo.min > node.val)
		{
			size = leftInfo.size + rightInfo.size + 1;
			newHead = node;
		}
		return new ReturnType(size, newHead, max, min);
	}
}
