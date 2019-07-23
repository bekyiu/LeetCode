package easy;


public class Q108
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
    public TreeNode sortedArrayToBST(int[] nums) 
    {
        if(nums == null || nums.length == 0)
        {
            return null;
        }
        return p(nums, 0, nums.length - 1);
    }
    public TreeNode p(int[] arr, int start, int end)
	{
		if(start > end)
		{
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode head = new TreeNode(arr[mid]);
		head.left = p(arr, start, mid - 1);
		head.right = p(arr, mid + 1, end);
		return head;
	}
}
