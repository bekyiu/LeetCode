package other.chapter4;

// Q321
public class Page204
{
	// 打爆arr[l..r]范围上的所有气球, 返回分数最大的
	// 假设arr[l - 1] 和 arr[r + 1]一定没有被打爆
	public int p(int[] arr, int l, int r)
	{
		if(l == r)
		{
			return arr[l - 1] * arr[l] * arr[r + 1];
		}
		int max = Math.max(arr[l - 1] * arr[r] * arr[r + 1] + p(arr, l, r - 1), // 最后打爆arr[r]
				arr[l - 1] * arr[l] * arr[r + 1] + p(arr, l + 1, r)); //最后打爆arr[l]
		// 中间位置被最后打爆
		for(int i = l + 1; i < r; i++)
		{
			max = Math.max(p(arr, l, i - 1) + p(arr, i + 1, r) + arr[l - 1] * arr[i] * arr[r + 1], max);
		}
		return max;
	}
	// 递归
	public int maxCoins1(int[] arr)
	{
		if(arr == null || arr.length == 0)
		{
			return 0;
		}
		if(arr.length == 1)
		{
			return arr[0];
		}
		int[] help = new int[arr.length + 2];
		help[0] = 1;
		help[help.length - 1] = 1;
		for(int i = 0; i < arr.length; i++)
		{
			help[i + 1] = arr[i];
		}
		return p(help, 1, help.length - 2);
	}
	
	// dp
    public int maxCoins(int[] arr) 
    {
        if(arr == null || arr.length == 0)
		{
			return 0;
		}
		if(arr.length == 1)
		{
			return arr[0];
		}
		int n = arr.length;
		int[] help = new int[n + 2];
		help[0] = 1;
		help[n + 1] = 1;
		for(int i = 0; i < n; i++)
		{
			help[i + 1] = arr[i];
		}
		int[][] dp = new int[n + 2][n + 2];
		for(int i = 1; i <= n; i++)
		{
			dp[i][i] = help[i - 1] * help[i] * help[i + 1];
		}
		for(int l = n; l >= 1; l--)
		{
			for(int r = l + 1; r <= n; r++)
			{
				int finalL = help[l - 1] * help[l] * help[r + 1] + dp[l + 1][r];
				int finalR = help[l - 1] * help[r] * help[r + 1] + dp[l][r - 1];
				dp[l][r] = Math.max(finalL, finalR);
				for(int i = l + 1; i < r; i++)
				{
					dp[l][r] = Math.max(dp[l][r], help[l - 1] * help[i] * help[r + 1] + dp[l][i - 1] + dp[i + 1][r]);
				}
			}
		}
		return dp[1][n];
		
    }
}
