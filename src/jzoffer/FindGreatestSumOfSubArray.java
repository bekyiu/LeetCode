package jzoffer;

// 子数组的最大和
public class FindGreatestSumOfSubArray
{
	// 递归解法
	public int solution(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++)
		{
			int z = p(arr, i);
			System.out.println(i + ": " + z);
			max = Math.max(max, z);
		}
		return max;
	}
	
	// 以end位置结尾的子数组的最大和
	public int p(int[] arr, int end)
	{
		if(end == 0)
		{
			return arr[0];
		}
		int pre = p(arr, end - 1);
		if(pre < 0)
		{
			return arr[end];
		}
		return pre + arr[end];
	}
	
	//dp 解法
	public int findGreatestSumOfSubArray(int[] arr)
	{
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int max = dp[0];
		for(int i = 1; i < dp.length; i++)
		{
			if(dp[i - 1] < 0)
			{
				dp[i] = arr[i];
			}
			else
			{
				dp[i] = dp[i - 1] + arr[i];
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
