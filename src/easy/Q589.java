package easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */
public class Q589
{
	public List<Integer> preorder(Node root)
	{
		List<Integer> res = new ArrayList<>();
		if (root == null)
		{
			return res;
		}

		fun(res, root);
		return res;
	}

	public void fun(List<Integer> res, Node cur)
	{
		if (cur != null)
		{
			res.add(cur.val);
			for (int i = 0; i < cur.children.size(); i++)
			{
				fun(res, cur.children.get(i));
			}
		}
	}
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
}
