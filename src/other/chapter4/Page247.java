package other.chapter4;
// Q45
public class Page247
{
	public static int[] arr =
	{ 3, 2, 3, 1, 1, 4 };
	// public static int[] arr =
	// { 2, 3, 0, 1, 4 };

	public static void main(String[] args)
	{
		System.out.println(dpMethod());
	}

	// 从i位置跳到最后, 最少需要跳几次
	public static int p(int i)
	{
		if (i >= arr.length - 1)
		{
			return 0;
		}
		// 考虑 arr[i] == 0的情况, 下面那个for不会执行, 直接把Integer.MAX_VALUE返回
		// 然后在上一层+1, 溢出得到一个负数
		int min = Integer.MAX_VALUE - 10;
		for (int m = 1; m <= arr[i]; m++)
		{
			min = Math.min(min, p(i + m) + 1);
		}
		return min;
	}

	// 依然过不了
	public static int dpMethod()
	{
		int[] dp = new int[arr.length];
		for (int i = dp.length - 2; i >= 0; i--)
		{
			int min = Integer.MAX_VALUE - 10;
			for (int m = 1; m <= arr[i]; m++)
			{
				if (i + m < dp.length)
				{
					min = Math.min(min, dp[i + m] + 1);
				} else
				{
					min = Math.min(min, 1);
				}
			}
			dp[i] = min;
		}
		// System.out.println(Arrays.toString(dp));
		return dp[0];
	}

	// 贪心 每次在可跳范围内选择可以使得跳的更远的位置
	public int jump(int[] nums)
	{
		int end = 0;
		int maxPosition = 0;
		int steps = 0;
		for (int i = 0; i < nums.length - 1; i++)
		{
			// 找能跳的最远的
			maxPosition = Math.max(maxPosition, nums[i] + i);
			// 遇到边界，就更新边界，并且步数加一
			// 每一次更新边界的时候, 都会找到可跳范围内选择可以使得跳的更远的位置
			if (i == end)
			{
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}

}
