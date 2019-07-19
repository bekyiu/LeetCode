package other.chapter3;

import java.util.HashMap;
import java.util.Map;

public class Page119
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
	
	private Map<Integer, Integer> map = new HashMap<>();
	public int getMaxLength(TreeNode head, int aim)
	{
		map.put(0, 0); // 在第0层可以累加出0, head在第一层
		return p(head, aim, 0, 1, 0);
	}
	public int p(TreeNode head, int aim, int preSum, int level, int maxLen)
	{
		if(head == null)
		{
			return maxLen;
		}
		int curSum = preSum + head.val;
		if(!map.containsKey(curSum))
		{
			map.put(curSum, level);
		}
		if(map.containsKey(curSum - aim))
		{
			maxLen = Math.max(level - map.get(curSum - aim), maxLen);
		}
		maxLen = p(head.left, aim, curSum, level + 1, maxLen);
		maxLen = p(head.right, aim, curSum, level + 1, maxLen);
		if(map.get(curSum) == level)
		{
			map.remove(curSum);
		}
		return maxLen;
	}
}
