package other.chapter4;

public class Page250
{
	public int num1(int n)
	{
		if(n < 1)
		{
			return 0;
		}
		
		// 第i行的皇后处于record[i]列
		int[] record = new int[n];
		return p(0, record, n);
	}
	// 一行一行的放
	public int p(int i, int[] record, int n)
	{
		if(i == n)
		{
			return 1;
		}
		int res = 0;
		for(int j = 0; j < n; j++)
		{
			if(isValid(record, i, j))
			{
				record[i] = j;
				res += p(i + 1, record, n);
			}
		}
		return res;
	}
	
	public boolean isValid(int[] record, int i, int j)
	{
		for(int k = 0; k < i; k++)
		{
			if(record[k] == j || Math.abs(k - i) == Math.abs(record[k] - j))
			{
				return false;
			}
		}
		return true;
	}
}
