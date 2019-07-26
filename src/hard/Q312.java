package hard;
// page204
public class Q312
{
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
