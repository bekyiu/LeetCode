package util.tree;

/*
 * 给定一个带parent指针的二叉树, 给定一个节点x, 求他的后继节点和前驱节点 
 * 后继节点:在中序遍历中x的后一个节点就叫后继节点
 * 前驱节点:在中序遍历中x的前一个节点就叫前驱节点
 * 根结点的parent指向null
 * 如何寻找后继节点:
 * 		一个节点x, 如果有右子树, 那么x的后继节点一定是他的右子树的最左侧的节点
 *		如果没有右子树, 那么就是在考察x是哪一个节点y的左子树的最后一个节点, y就是x的后继 如何找?
 *		找x的parent 如果x是parent的左孩子, 那么parent就是他的后继
 *		如果不是, x来到parent的位置, 继续和当前位置的parent比较
 * 如何寻找前驱节点:
 * 		一个节点x, 如果有左子树, 那么x的前驱节点一定是他左子树最右侧的节点
 * 		如果没有左子树, 那么就是在考察x是哪一个节点y的右子树的第一个节点, y就是x的前驱 如何找?
 * 		一直往上窜, 知道当前节点作为他父节点的右孩子
 */
public class Find
{

	public Node getSuccessor(Node cur)
	{
		if (cur == null)
		{
			return null;
		}
		if (cur.right != null)
		{
			return getMostLeft(cur.right);
		} 
		else
		{
			Node parent = cur.parent;
			while (parent != null && parent.left != cur)
			{
				cur = parent;
				parent = cur.parent;
			}
			return parent;
		}
	}

	public Node getMostLeft(Node cur)
	{
		if (cur == null)
		{
			return null;
		}
		while (cur.left != null)
		{
			cur = cur.left;
		}
		return cur;
	}

	public Node getPredecessor(Node cur){
		if (cur == null){
			return null;
		}
		if (cur.left != null){
			return getMostRight(cur.left);
		} 
		else
		{
			Node parent = cur.parent;
			while (parent != null && parent.right != cur)
			{
				cur = parent;
				parent = cur.parent;
			}
			return parent;
		}
	}
	public Node getMostRight(Node cur){
		if (cur == null)
		{
			return null;
		}
		while (cur.right != null)
		{
			cur = cur.right;
		}
		return cur;
	}

	public static void main(String[] args)
	{

	}

	class Node
	{
		int val;
		Node left;
		Node right;
		Node parent;

		public Node(int val)
		{
			this.val = val;
		}
	}
}
