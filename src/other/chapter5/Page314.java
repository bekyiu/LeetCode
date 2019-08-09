package other.chapter5;

public class Page314
{
    public int minCut(String s) 
    {
    	if(s == null || s.equals(""))
    	{
    		return 0;
    	}
    	int len = s.length();
    	int[] dp = new int[len + 1];
    	dp[len] = -1;
    	boolean[][] p = new boolean[len][len];
    	char[] chs = s.toCharArray();
    	for(int i = len - 1; i >= 0; i--)
    	{
    		dp[i] = Integer.MAX_VALUE;
    		for(int j = i; j < len; j++)
    		{
    			if(chs[i] == chs[j] && (j - i < 2 || p[i + 1][j - 1]))
    			{
    				p[i][j] = true;
    				dp[i] = Math.min(dp[i], dp[j + 1] + 1);
    			}
    		}
    	}
    	return dp[0];
    }
}
