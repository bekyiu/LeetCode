package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * 给定一个二叉树，返回它的 后序 遍历。
 * 非递归思路:
 * 		非递归先序遍历是 根 左 右的顺序
 * 		那么我们可以根据非递归先序遍历 改出一个是 根 右 左的遍历顺序
 * 		只不过在本该打印的时候不打印, 而是把这个节点放入辅助栈中
 * 		知道遍历完成
 * 		最后再从辅助栈全部pop出来 就是 左 右 根的顺序 即后续遍历
 */
public class Q145
{
	private List<Integer> res = new ArrayList<>();
	
//    public List<Integer> postorderTraversal(TreeNode root) {
//    	if(root == null)
//		{
//			return res;
//		}
//    	fun(root);
//    	return res;
//    }
//    public void fun(TreeNode cur)
//    {
//    	if(cur != null)
//    	{
//    		fun(cur.left);
//    		fun(cur.right);
//    		res.add(cur.val);
//    	}
//    }
	
    public List<Integer> postorderTraversal(TreeNode root) {
    	if(root == null)
		{
			return res;
		}
		TreeNode cur = root;
		Deque<TreeNode> stack = new ArrayDeque<>();
		Deque<TreeNode> help = new ArrayDeque<>();
		stack.push(cur);
		while(!stack.isEmpty())
		{
			cur = stack.pop();
			help.push(cur);
			if(cur.left != null)
			{
				stack.push(cur.left);
			}
			if(cur.right != null)
			{
				stack.push(cur.right);
			}
		}
		while(!help.isEmpty())
		{
			res.add(help.pop().val);
		}
    	return res;
    }
    
	public static void main(String[] args)
	{

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
