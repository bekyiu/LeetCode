package other.chapter3;

public class Page148
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
//			left = null;
//			right = null;
		}
	}
	
	public boolean isPostArray(int[] arr)
	{
		return p(arr, 0, arr.length - 1);
	}
	
	// arr[start..end]这个范围是能重建成bst
	public boolean p(int[] arr, int start, int end)
	{
		if(start == end)
		{
			return true;
		}
		// 小于部分的右边界
		int less = -1;
		// 大于部分的左边界
		int more = end;
		for(int i = start; i < end; i++)
		{
			if(arr[i] < arr[end])
			{
				less = i;
			}
			else
			{
				more = more == end ? i : more;
			}
		}
		// 无左子树或右子树
		if(less == -1 || more == end)
		{
			return p(arr, start, end - 1);
		}
		if(less != more - 1)
		{
			return false;
		}
		return p(arr, start, less) && p(arr, more, end - 1);
	}
	
	// 此时已知了arr一定是后序遍历的结果
	public TreeNode generate(int[] arr)
	{
		return p2(arr, 0, arr.length - 1);
	}
	
	public TreeNode p2(int[] arr, int start, int end)
	{
//		if(start == end)
//		{
//			return new TreeNode(arr[start]);
//		}
		// 多算一层, 把叶子结点左右儿子的null也赋上
		// 因为TreeNode的构造函数可能是改不了的
		if(start > end)
		{
			return null;
		}
		
		int less = -1;
		int more = end;
		for(int i = start; i < end; i++)
		{
			if(arr[i] < arr[end])
			{
				less = i;
			}
			else
			{
				more = more == end ? i : more;
			}
		}
		TreeNode left = p2(arr, start, less);
		TreeNode right = p2(arr, more, end - 1);
		TreeNode cur = new TreeNode(arr[end]);
		cur.left = left;
		cur.right = right;
		return cur;
	}
}
