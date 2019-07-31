package hard;
// page233
public class Q97
{
	public boolean isInterleave(String s1, String s2, String s3) 
    {
		if(s1 == null || s2 == null || s3 == null)
		{
			return false;
		}
		
		if(s1.length() + s2.length() != s3.length())
		{
			return false;
		}
		
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char[] chaim = s3.toCharArray();
		
		boolean[][] dp = new boolean[ch1.length + 1][ch2.length + 1];
		dp[0][0] = true;
		for(int i = 1; i < dp.length; i++)
		{
			if(ch1[i - 1] != chaim[i - 1])
			{
				break;
			}
			dp[i][0] = true;
		}
		
		for(int j = 1; j < dp[0].length; j++)
		{
			if(ch2[j - 1] != chaim[j - 1])
			{
				break;
			}
			dp[0][j] = true;
		}
		
		for(int i = 1; i < dp.length; i++)
		{
			for(int j = 1; j < dp[0].length; j++)
			{
				if((chaim[i + j - 1] == ch1[i - 1] && dp[i - 1][j]) || 
						(chaim[i + j - 1] == ch2[j - 1] && dp[i][j - 1]))
				{
					dp[i][j] = true;
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
    }
}
