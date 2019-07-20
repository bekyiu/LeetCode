package easy;

//爬楼梯
/*
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	解法: 求斐波那契数列
	1 2 3 4 5 6 ... 层数
	1 2 3 5 8 13 ...不同方案的总数
 */
public class Q70
{
	// 记忆优化解法
	private int[] cache = new int[100];

	public int climbStairs(int n)
	{
		if (n == 0 || n == 1)
		{
			return 1;
		}
		if (n == 2)
		{
			return 2;
		}
		if (cache[n - 1] == 0)
		{
			cache[n - 1] = climbStairs(n - 1);
		}
		if (cache[n - 2] == 0)
		{
			cache[n - 2] = climbStairs(n - 2);
		}
		return cache[n - 1] + cache[n - 2];
	}

	// 迭代解法
	public int climbStairs2(int n)
	{
		if (n == 0 || n == 1)
		{
			return 1;
		} else if (n == 2)
		{
			return 2;
		} else
		{
			int k = 3;
			int num1 = 1;
			int num2 = 2;
			int sum = 0;
			while (k <= n)
			{
				sum = num1 + num2;
				int temp = num2;
				num2 = sum;
				num1 = temp;
				k++;
			}
			return sum;
		}
	}

	// 暴力递归
	// 共有n个台阶  当前在第i个台阶 找到了几种走法
	// 调用 f(n, 0);
	public int f(int n, int i)
	{
		if (i == n)
		{
			return 1;
		}
		if (i > n)
		{
			return 0;
		}
		return f(n, i + 1) + f(n, i + 2);
	}

	// dp
	public int dpMethod(int n)
	{
		int[] dp = new int[n + 2];
		dp[dp.length - 1] = 0;
		dp[dp.length - 2] = 1;
		for (int i = dp.length - 3; i >= 0; i--)
		{
			dp[i] = dp[i + 1] + dp[i + 2];
		}
		return dp[0];
	}
}
