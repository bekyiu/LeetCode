package hard;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 二叉树的序列化和反序列化
 * 序列化:
 * 	先序遍历方式
 * 		遇到结点拼出val_
 * 		遇到空拼出#_
 * 反序列化:
 * 		把序列化字符串按_分割得到每一个结点
 * 		按先序的顺序一个个构建结点
 */
public class Q297
{
    //先序遍历的方式
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root == null)
        {
            return "#_";
        }
        // 可以改为StringBuilder
        String res = root.val + "_";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        String[] vals = data.split("_");
        Deque<String> queue = new LinkedList<>();
        for (String str : vals)
		{
			queue.add(str);
		}
        return fun(queue);
    }
    public TreeNode fun(Deque<String> queue)
    {
    	String val = queue.poll();
    	if(val.equals("#"))
    	{
    		return null;
    	}
    	TreeNode head = new TreeNode(Integer.valueOf(val));
    	head.left = fun(queue);
    	head.right = fun(queue);
    	return head;
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
