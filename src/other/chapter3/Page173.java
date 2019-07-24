package other.chapter3;

public class Page173
{
	// n个节点的二叉搜索树有多少种可能
	public int numTrees(int n)
	{
		if (n <= 1)
		{
			return 1;
		}
		int sum = 0;
		// 以每一个节点为头
		for (int i = 1; i <= n; i++)
		{
			sum += numTrees(i - 1) * numTrees(n - i);

		}
		return sum;
	}

	// dp版本
	public int dpMethod(int n)
	{
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

	public static void main(String[] args)
	{
		int z = new Page173().numTrees(3);
		System.out.println(z);
	}

}
