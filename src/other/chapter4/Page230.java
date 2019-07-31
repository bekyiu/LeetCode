package other.chapter4;

public class Page230
{
	public int minCost1(String str1, String str2, int ic, int dc, int rc)
	{
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		
		int[][] dp = new int[chs1.length + 1][chs2.length + 1];
		for(int i = 1; i < dp.length; i++)
		{
			dp[i][0] = i * dc;
		}
		for(int j = 1; j < dp[0].length; j++)
		{
			dp[0][j] = j * ic;
		}
		
		for(int i = 1; i < dp.length; i++)
		{
			for(int j = 1; j < dp[0].length; j++)
			{
				if(chs1[i - 1] == chs2[j - 1])
				{
					dp[i][j] = dp[i - 1][j - 1];
				}
				else
				{
					dp[i][j] = dp[i - 1][j - 1] + rc;
				}
				dp[i][j] = Math.min(dp[i][j], dc + dp[i - 1][j]);
				dp[i][j] = Math.min(dp[i][j], ic + dp[i][j - 1]);
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
