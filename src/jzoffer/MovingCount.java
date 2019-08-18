package jzoffer;

public class MovingCount
{
	private boolean[][] v;

	public int movingCount(int threshold, int rows, int cols)
	{
		v = new boolean[rows][cols];
		return p(threshold, 0, 0, rows, cols);
	}

	// 从i, j位置开始走, 能走进几个盒子
	public int p(int k, int i, int j, int rows, int cols)
	{
		// 能走进的盒子总数
		int box = 0;
		int curSum = getOneSum(i) + getOneSum(j);
		if (i < 0 || i >= rows || j < 0 || j >= cols || v[i][j] || curSum > k)
		{
			return 0;
		}
		box++;
		v[i][j] = true;
		box += p(k, i + 1, j, rows, cols) + p(k, i - 1, j, rows, cols) + p(k, i, j + 1, rows, cols)
				+ p(k, i, j - 1, rows, cols);
		return box;
	}

	// 给定一个数614, 返回位数和11
	public int getOneSum(int num)
	{
		int sum = 0;
		while (num != 0)
		{
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}
}
