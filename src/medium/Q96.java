package medium;
//page173
public class Q96
{
    public int numTrees(int n) {
		if (n <= 1)
		{
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		//dp[i]表示: n = i的时候, 构成的二叉树有dp[i]种可能
		for (int i = 2; i < dp.length; i++)
		{
			// 以每一个节点为头
			for (int j = 1; j <= i; j++)
			{
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
    }
}
