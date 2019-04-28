package other.chapter3;

public class Page104
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
//	public static void main(String[] args)
//	{
//		TreeNode root = new TreeNode(614);
//		TreeNode a = new TreeNode(6);
//		TreeNode b = new TreeNode(1);
//		TreeNode c = new TreeNode(4);
//		root.left = a;
//		root.right = b;
//		a.left = c;
//		a.right = null;
//		b.left = null;
//		b.right = null;
//		c.left = null;
//		c.right = null;
//		new Page104().printTree(root);
//	}
	public void printTree(TreeNode head)
	{
		fun(head, 0, "H", 17);
		System.out.println();
	}
	
	public void fun(TreeNode head, int height, String to, int len)
	{
		if(head == null)
		{
			return;
		}
		fun(head.right, height + 1, "v", len);
		
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = addSpace(lenL) + val + addSpace(lenR);
		System.out.println(addSpace(height * len) + val);
		
		fun(head.left, height + 1, "^", len);
	}
	
	public String addSpace(int num)
	{
		StringBuilder sb = new StringBuilder(num);
		for(int i = 0; i < num; i++)
		{
			sb.append(" ");
		}
		return sb.toString();
	}
}
