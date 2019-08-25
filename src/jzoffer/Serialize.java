package jzoffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Serialize
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
	private StringBuilder sb = new StringBuilder();
	public String serialize(TreeNode root)
	{
		p(root);
		return sb.toString();
	}

	private void p(TreeNode root)
	{
		if(root == null)
		{
			sb.append("#!");
			return;
		}
		sb.append(root.val).append("!");
		p(root.left);
		p(root.right);
	}
	
	public TreeNode deserialize(String str)
	{
		Deque<String> queue = new ArrayDeque<>();
		String[] nodes = str.split("!");
		for(int i = 0; i < nodes.length; i++)
		{
			queue.add(nodes[i]);
		}
		return rebuild(queue);
	}
	
	public TreeNode rebuild(Deque<String> queue)
	{
		String value = queue.poll();
		if("#".equals(value))
		{
			return null;
		}
		TreeNode head = new TreeNode(Integer.valueOf(value));
		head.left = rebuild(queue);
		head.right = rebuild(queue);
		return head;
	}
}
