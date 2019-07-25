package other.chapter4;
// 生牛问题
public class Page184
{
	
	public int cl(int n)
	{
		if(n < 1)
		{
			return 0;
		}
		if(n == 1 || n == 2 || n == 3)
		{
			return n;
		}
		return cl(n - 1) + cl(n - 3);
	}
}
