package other.chapter3;
//打印二叉树的边界节点
public class Page100
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
	
	//1. 求树的高度
	//2. 填边界数组
	//3. 打印左边界
	//4. 打印叶子但不是左右边界
	//5. 打印右边界但不是左边界
	public void printEdge1(TreeNode head)
	{
		int h = getHeight(head, 0);
		TreeNode[][] edgeMap = new TreeNode[h][2];
		setMap(head, 0, edgeMap);
		for(int i = 0; i < edgeMap.length; i++)
		{
			System.out.print(edgeMap[i][0].val + " ");
		}
		System.out.println();
		printLeaf(head, 0, edgeMap);
		System.out.println();
		for(int i = edgeMap.length - 1; i >= 0; i--)
		{
			if(edgeMap[i][0] != edgeMap[i][1])
			{
				System.out.print(edgeMap[i][1].val + " ");
			}
		}
		
	}
	
	public void setMap(TreeNode head, int h, TreeNode[][] map)
	{
		if(head == null)
		{
			return;
		}
		map[h][0] = map[h][0] == null ? head : map[h][0];
		map[h][1] = head;
		setMap(head.left, h + 1, map);
		setMap(head.right, h + 1, map);
	}
	
	//h初始值应该是0
	public int getHeight(TreeNode head, int h)
	{
		if(head == null)
		{
			return h;
		}
		return Math.max(getHeight(head.left, h), getHeight(head.right, h)) + 1;
	}
	
	public void printLeaf(TreeNode head, int h, TreeNode[][] map)
	{
		if(head == null)
		{
			return;
		}
		if(head.left == null && head.right == null && head != map[h][0] && head != map[h][1])
		{
			System.out.print(head.val + " ");
		}
		printLeaf(head.left, h + 1, map);
		printLeaf(head.right, h + 1, map);
	}
}
