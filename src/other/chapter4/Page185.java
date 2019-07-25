package other.chapter4;

public class Page185
{
	public int num(int[][] map)
	{
		return p(map, 0, 0);
	}

	// 从m行n列开始走, 走到右下角的最小路径和
	public int p(int[][] map, int m, int n)
	{
		if (m == map.length - 1 && n == map[0].length - 1)
		{
			return map[m][n];
		}
		if (m == map.length - 1)
		{
			return map[m][n] + p(map, m, n + 1);
		}
		if (n == map[0].length - 1)
		{
			return map[m][n] + p(map, m + 1, n);
		}
		return Math.min(map[m][n] + p(map, m + 1, n), map[m][n] + p(map, m, n + 1));
	}

	public int dpMethod(int[][] map)
	{
		// dp[i][j] 表示 从i行j列出发 到右下角的最短路径和
		int[][] dp = new int[map.length][map[0].length];
		dp[dp.length - 1][dp[0].length - 1] = map[map.length - 1][map[0].length - 1];
		// 最后一行
		for(int i = dp[0].length - 2; i >= 0; i--)
		{
			dp[dp.length - 1][i] = map[dp.length - 1][i] + dp[dp.length - 1] [i + 1];
		}
		// 最后一列
		for(int i = dp.length - 2; i >= 0; i--)
		{
			dp[i][dp[0].length - 1] = map[i][dp[0].length - 1] + dp[i + 1][dp[0].length - 1];
		}
		for(int i = dp.length - 2; i >= 0; i--)
		{
			for(int j = dp[0].length - 2; j >= 0; j--)
			{
				dp[i][j] = Math.min(map[i][j] + dp[i + 1][j], map[i][j] + dp[i][j + 1]);
			}
		}
		return dp[0][0];
	}
	public static void main(String[] args)
	{
		int[][] map = new int[][]
		{
				{ 1, 3, 5, 9 },
				{ 8, 1, 3, 4 },
				{ 5, 0, 6, 1 },
				{ 8, 8, 4, 0 } };
		int z = new Page185().num(map);
		System.out.println(z);
	}
}
