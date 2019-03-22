package easy;

//翻转一棵二叉树。
public class Q654
{
	public TreeNode invertTree(TreeNode root)
	{
		fun(root);
		return root;
	}

	public void fun(TreeNode cur)
	{
		if (cur != null)
		{
			fun(cur.left);
			fun(cur.right);
			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;
		}
	}

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
}
