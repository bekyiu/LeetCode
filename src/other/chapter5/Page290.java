package other.chapter5;

public class Page290
{
	// 判断括号字符串是否有效, 可以用栈
	public boolean isValid(String str)
	{
		if(str == null || str.equals(""))
		{
			return false;
		}
		char[] chs = str.toCharArray();
		int leftNum = 0;
		int rightNum = 0;
		for(int i = 0; i < chs.length; i++)
		{
			if(chs[i] == '(')
			{
				leftNum++;
			}
			if(chs[i] == ')')
			{
				rightNum++;
			}
			if(chs[i] != '(' && chs[i] != ')')
			{
				return false;
			}
			if(rightNum > leftNum)
			{
				return false;
			}
		}
		return leftNum == rightNum;
	}
	
    public int longestValidParentheses(String s) 
    {
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
