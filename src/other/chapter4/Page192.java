package other.chapter4;

public class Page192
{
	public static void main(String[] args)
	{
		int z = walk(7, 5, 9, 4);
		int z2 = walk2(7, 5, 9, 4);
		System.out.println(z);
		System.out.println(z2);
	}
	// 一共有 1~N的位置
	// cur最初数M, 即一开始站在哪个位置
	// K是要走多少步
	// P是最终停留的位置
	// 函数表示, 在cur位置走k步到p位置为, 一共有多少种走法
	// 递归解法
	public static int walk(int N, int P, int K, int cur)
	{
		if(K == 0)
		{
			return cur == P ? 1 : 0;
		}
		if(cur == 1)
		{
			return walk(N, P, K - 1, cur + 1);
		}
		if(cur == N)
		{
			return walk(N, P, K - 1, cur - 1);
		}
		return walk(N, P, K - 1, cur + 1) + walk(N, P, K - 1, cur - 1);
	}
	
	// dp解法
	public static int walk2(int N, int P, int K, int cur)
	{
		// 行: 剩余多少步, 列: 当前可以处于哪个位置
		int[][] dp = new int[K + 1][N];
		for(int i = 0; i < dp[0].length; i++)
		{
			dp[0][i] = (i + 1) == P ? 1 : 0;
		}
		for(int i = 1; i < dp.length; i++)
		{
			for(int j = 0; j < dp[0].length; j++)
			{
				if(j == 0)
				{
					dp[i][j] = dp[i - 1][j + 1];
				}
				else if(j == dp[0].length - 1)
				{
					dp[i][j] = dp[i - 1][j - 1];
				}
				else
				{
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
				}
			}
		}
		return dp[K][cur - 1];
	}

}
