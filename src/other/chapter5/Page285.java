package other.chapter5;

public class Page285
{
	public int[][] getdp(char[] str)
	{
		int[][] dp = new int[str.length][str.length];
		for(int i = 0; i < dp.length; i++)
		{
			for(int j = i; j < dp[0].length; j++)
			{
				if(j - i == 1)
				{
					if(str[i] != str[j])
					{
						dp[i][j] = 1;
					}
				}
				if(j - i > 1)
				{
					if(str[i] == str[j])
					{
						dp[i][j] = dp[i + 1][j - 1];
					}
					else
					{
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) + 1;
					}
				}
			}
		}
		return dp;
	}
	
	public String getPalindrome1(String str)
	{
		if(str == null || str.length() < 2)
		{
			return str;
		}
		int[][] dp = getdp(str.toCharArray());
		char[] chs = str.toCharArray();
		int i = 0;
		int j = chs.length - 1;
		char[] res = new char[dp[0][str.length() - 1] + str.length()];
		int resl = 0;
		int resr = chs.length - 1;
		while(i <= j)
		{
			if(chs[i] == chs[j])
			{
				res[resl++] = chs[i++];
				res[resr--] = chs[j--];
			}
			else if(dp[i + 1][j] > dp[i][j - 1])
			{
				res[resl++] = chs[j];
				res[resr--] = chs[j--];
			}
			else
			{
				res[resl++] = chs[i];
				res[resr--] = chs[i++];
			}
		}
		return String.valueOf(res);
	}
}
