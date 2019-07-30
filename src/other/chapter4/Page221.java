package other.chapter4;

public class Page221
{

	public int[][] getdp(char[] str1, char[] str2)
	{
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for(int i = 1; i < str1.length; i++)
		{
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for(int j = 1; j < str2.length; j++)
		{
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}
		for(int i = 1; i < str1.length; i++)
		{
			for(int j = 1; j < str2.length; j++)
			{
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if(str1[i] == str2[j])
				{
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp;
	}
	
	public String lcs(String str1, String str2)
	{
		char[] chs1 = str1.toCharArray();
		char[] chs2 = str2.toCharArray();
		int[][] dp = getdp(chs1, chs2);
		
		int m = chs1.length - 1;
		int n = chs2.length - 1;
		
		char[] res = new char[dp[m][n]];
		int index = res.length - 1;
		while(index >= 0)
		{
			if(n > 0 && dp[m][n] == dp[m][n - 1])
			{
				n--;
			}
			else if(m > 0 && dp[m][n] == dp[m - 1][n])
			{
				m--;
			}
			else
			{
				res[index--] = chs1[m];
				m--;
				n--;
			}
		}
		return String.valueOf(res);
	}
	
	public static void main(String[] args)
	{
		Page221 obj = new Page221();
		String lcs = obj.lcs("1a2b3cddd", "91o2rt3sss");
		System.out.println(lcs);
	}
}
