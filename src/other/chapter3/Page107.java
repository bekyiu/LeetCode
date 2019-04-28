package other.chapter3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Page107
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
	//先序序列化
	public String serialByPre(TreeNode head)
	{
		if(head == null)
		{
			return "#!";
		}
		String res = head.val + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	public TreeNode reconByPreString(String preStr)
	{
		String[] values = preStr.split("!");
		Deque<String> q = new ArrayDeque<>();
		for(int i = 0; i < values.length; i++)
		{
			q.addLast(values[i]);
		}
		return reconPreOrder(q);
	}
	
	public TreeNode reconPreOrder(Deque<String> q)
	{
		String val = q.removeFirst();
		if(val.equals("#"))
		{
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(val));
		node.left = reconPreOrder(q);
		node.right = reconPreOrder(q);
		return node;
	}
	
	//层序序列化, 很慢
	public String serialByLevel(TreeNode head)
	{
        if(head == null)
		{
			return "#!";
		}
		Deque<TreeNode> q = new ArrayDeque<>();
		String res = head.val + "!";
//		String res = "";
		q.addLast(head);
		while(!q.isEmpty())
		{
			TreeNode node = q.removeFirst();
			if(node.left != null)
			{
                res += (node.left.val + "!");
				q.addLast(node.left);
			}
			else
			{
				res += "#!";
			}
			if(node.right != null)
			{
                res += (node.right.val + "!");
				q.addLast(node.right); 
			}
			else
			{
				res += "#!";
			}
		}
		return res;
	}
	
	public TreeNode reconByLevelString(String levelStr)
	{
		String[] values = levelStr.split("!");
		int index = 0;
		TreeNode head = generateNode(values[index++]);
		Deque<TreeNode> q = new ArrayDeque<>();
		if(head != null)
		{
			q.addLast(head);
		}
		TreeNode node = null;
		while(!q.isEmpty())
		{
			node = q.removeFirst();
			node.left = generateNode(values[index++]);
			node.right = generateNode(values[index++]);
			if(node.left != null)
			{
				q.addLast(node.left);
			}
			if(node.right != null)
			{
				q.addLast(node.right);
			}
		}
		return head;
	}
	
	public TreeNode generateNode(String val)
	{
		if("#".equals(val))
		{
			return null;
		}
		return new TreeNode(Integer.valueOf(val));
	}
}
