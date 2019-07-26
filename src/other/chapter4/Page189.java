package other.chapter4;

public class Page189
{

	public static void main(String[] args)
	{
		int z = new Page189().minCoins1(new int[]
		{ 5, 2, 3 }, 20);
		System.out.println(z);
	}

	public int minCoins1(int[] arr, int aim)
	{
		return p(arr, 0, aim);
	}

	public int p(int[] arr, int i, int rest)
	{
		if (i == arr.length)
		{
			return rest == 0 ? 0 : -1;
		}
		int res = -1;
		for (int k = 0; k * arr[i] <= rest; k++)
		{
			int next = p(arr, i + 1, rest - k * arr[i]);
			if (next != -1)
			{
				res = res == -1 ? next + k : Math.min(res, next + k);
			}
		}
		return res;
	}
	
	public int minCoins2(int[] arr, int aim)
	{
		int n = arr.length;
		int[][] dp = new int[n + 1][aim + 1];
		for(int col = 1; col <= aim; col++)
		{
			dp[n][col] = -1;
		}
		for(int i = n - 1; i >= 0; i--)
		{
			for(int rest = 0; rest <= aim; rest++)
			{
				dp[i][rest] = -1;
				// 如果下面的值有效, 先设置成下面的值
				if(dp[i + 1][rest] != -1)
				{
					dp[i][rest] = dp[i + 1][rest];
				}
				// 如果左边的值不越界, 且有效
				if(rest - arr[i] >= 0 && dp[i][rest - arr[i]] != -1)
				{
					if(dp[i][rest] == -1)
					{
						dp[i][rest] = dp[i][rest - arr[i]] + 1;
					}
					else
					{
						dp[i][rest] = Math.min(dp[i][rest], dp[i][rest - arr[i]] + 1);
					}
				}
			}
		}
		return dp[0][aim];
	}
}
