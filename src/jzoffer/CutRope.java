package jzoffer;

public class CutRope
{
	// 有点问题 淦
	public static int p(int n)
	{
//		if (n <= 2)
//		{
//			return 1;
//		}
		if (n <= 3)
		{
			return n;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++)
		{

			max = Math.max(p(i) * p(n - i), max);

		}
		return max;
	}

	public static int getMaxResult(int n)
	{
		if (n < 2)
		{
			return 0;
		}
		if (n <= 2)
		{
			return 1;
		}
		if (n == 3)
		{
			return 2;
		}

		int[] products = new int[n + 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;

		int max = 0;
		for (int i = 4; i <= n; i++)
		{
			max = 0;
			// j < i也可以, 但是j <= i / 2会省去一些情况
			// 比如i = 4, product[1] * products[3] 和 products[3] * products[1]的结果是一样
			for (int j = 1; j <= i / 2; j++)
			{
				int product = products[j] * products[i - j];
				if (max < product)
				{
					max = product;
				}
				products[i] = max;
			}
		}
		max = products[n];
		return max;
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 120; i++)
		{
			System.out.println("绳子长度: " + i);
			System.out.println(CutRope.p(i));
			System.out.println(CutRope.getMaxResult(i));
			System.out.println();
		}

	}
}
