package easy;

public class Q198
{

	public static void main(String[] args)
	{
		int r = new Q198().rob(new int[]
		{ 2, 1, 1, 2 });
		System.out.println(r);
	}
	
	// 递归版本 过不了
	public int rob(int[] nums)
	{
		return p(nums, 0);
	}

	// 从start位置开始决策, 能偷到的最大金额
	public int p(int[] nums, int start)
	{
		if (start >= nums.length)
		{
			return 0;
		}
		// 如果start位置偷
		int p1 = nums[start] + p(nums, start + 2);
		// 如果start位置不偷
		int p2 = p(nums, start + 1);
		return Math.max(p1, p2);
	}
	
	// dp版本
	public int robdp(int[] nums)
	{
		int[] dp = new int[nums.length + 2];
		dp[dp.length - 1] = 0;
		dp[dp.length - 2] = 0;
		for(int start = dp.length - 3; start >= 0; start--)
		{
			dp[start] = Math.max(nums[start] + dp[start + 2], dp[start + 1]);
		}
		return dp[0];
	}
}
