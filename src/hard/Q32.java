package hard;
// Page32
public class Q32
{
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2)
    	{
    		return 0;
    	}
    	int[] dp = new int[s.length()];
    	char[] chs = s.toCharArray();
    	int res = -1;
    	for(int i = 1; i < dp.length; i++)
    	{
    		if(chs[i] == '(')
    		{
    			dp[i] = 0;
    		}
    		else
    		{
    			int pre = i - dp[i - 1] - 1;
    			if(pre >= 0 && chs[pre] == '(')
    			{
    				dp[i] = dp[i - 1] + 2;
    				if(pre - 1 >= 0)
    				{
    					dp[i] += dp[pre - 1];
    				}
    			}
    		}
    		res = Math.max(res, dp[i]);
    	}
    	return res;
    }
}
