package other.chapter3;

import java.util.ArrayList;
import java.util.List;

//morris遍历
public class Page111
{

	//morris序 如果一个节点有左孩子, 那么会来到这个结点两次, 如果没有 只会来到这个结点一次
	public void morris(TreeNode head)
	{
		if(head == null)
		{
			return;
		}
		TreeNode cur = head;
		TreeNode mostRight = null;
		while(cur != null)
		{
			mostRight = cur.left;
			if(mostRight != null)
			{
				while(mostRight.right != null && mostRight.right != cur) 
				{
					mostRight = mostRight.right;
				}
				if(mostRight.right == null)
				{
					mostRight.right = cur;
					cur = cur.left;
					continue;
				}
				else
				{
					mostRight.right = null;
				}
			}
			cur = cur.right;
		}
	}
	
	//前序遍历, 把打印行为放在第一次来到这个结点的时候
	public void morrisPre(TreeNode head)
	{
		if(head == null)
		{
			return;
		}
		TreeNode cur = head;
		TreeNode mostRight = null;
		while(cur != null)
		{
			mostRight = cur.left;
			if(mostRight != null)
			{
				while(mostRight.right != null && mostRight.right != cur)
				{
					mostRight = mostRight.right;
				}
				if(mostRight.right == null)
				{
					System.out.println(cur.val + " ");
					mostRight.right = cur;
					cur = cur.left;
					continue;
				}
				else
				{
					mostRight.right = null;
				}
			}
			else
			{
				System.out.println(cur.val + " ");
			}
			cur = cur.right;
		}
	}
	
	//中序遍历, 把打印行为放在第二次来到这个结点的时候
	public void morrisIn(TreeNode head)
	{
		if(head == null)
		{
			return;
		}
		List<Integer> res = new ArrayList<>();
		TreeNode cur = head;
		TreeNode mostRight = null;
		while(cur != null)
		{
			mostRight = cur.left;
			if(mostRight != null)
			{
				while(mostRight.right != null && mostRight.right != cur) 
				{
					mostRight = mostRight.right;
				}
				if(mostRight.right == null)
				{
					mostRight.right = cur;
					cur = cur.left;
					continue;
				}
				else
				{
					mostRight.right = null;
				}
			}
			res.add(cur.val);
			cur = cur.right;
		}
	}
	
	//后续遍历, 不管只能来到一次的节点, 在能来到两次的节点中, 第二次来到改结点的时候, 逆序打印该节点左子树的右边界
	//逆序打印整棵树的右边界
	public void morrisPos(TreeNode head)
	{
		if(head == null)
		{
			return;
		}
		TreeNode cur = head;
		TreeNode mostRight = null;
		while(cur != null)
		{
			mostRight = cur.left;
			if(mostRight != null)
			{
				while(mostRight.right != null && mostRight.right != cur) 
				{
					mostRight = mostRight.right;
				}
				if(mostRight.right == null)
				{
					mostRight.right = cur;
					cur = cur.left;
					continue;
				}
				else
				{
					mostRight.right = null;
					printEdge(cur.left);
				}
			}
			cur = cur.right;
		}
		printEdge(head);
	}
	
	public void printEdge(TreeNode head)
	{
		TreeNode tail = reverse(head);
		TreeNode cur = tail;
		while(cur != null)
		{
			System.out.println(cur.val);
			cur = cur.right;
		}
		//还要调整回来
		reverse(tail);
	}
	
	public TreeNode reverse(TreeNode from)
	{
		TreeNode pre = null;
		TreeNode next = null;
		while(from != null)
		{
			next = from.right;
			from.right = pre;
			pre = from;
			from = next;
		}
		return pre;
	}
	
	
	class TreeNode
	{
		public int val;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int val)
		{
			this.val = val;
		}
	}
}
