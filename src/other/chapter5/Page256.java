package other.chapter5;

public class Page256
{
	public int myAtoi(String str)
	{
		if(str == null)
		{
			return 0;
		}
		str = str.trim();
		if(str.equals(""))
		{
			return 0;
		}
		char[] chs = str.toCharArray();
		if(!isValid(chs))
		{
			return 0;
		}
		boolean posi = chs[0] == '-' ? false : true;
		int minq = Integer.MIN_VALUE / 10;
		int minr = Integer.MIN_VALUE % 10;
		int res = 0;
		int cur = 0;
		for(int i = posi ? 0 : 1; i < chs.length; i++)
		{
			// 用负数表示
			cur = '0' - chs[i];
			// |res| > |minq| -> 10 * |res| > 10 * |Integer.MIN_VALUE| 越界
			// |res| = |minq|, |cur| > |minr| -> |res| * 10 + |cur| > |Integer.MIN_VALUE| 越界
			if((res < minq) || (res == minq && cur < minr))
			{
				return 0;
			}
			res = res * 10 + cur;
		}
		// |Integer.MIN_VALUE| - |Integer.MAX_VALUE| = 1
		if(posi && res == Integer.MIN_VALUE)
		{
			return 0;
		}
		return posi ? -res : res;
	}

	public boolean isValid(char[] chs)
	{
		// a12
		if (chs[0] != '-' && (chs[0] < '0' || chs[0] > '9'))
		{
			return false;
		}
		// -, -0
		if (chs[0] == '-' && (chs.length == 1 || chs[1] == '0'))
		{
			return false;
		}
		// 0123
		if (chs[0] == '0' && chs.length > 1)
		{
			return false;
		}
		for (int i = 1; i < chs.length; i++)
		{
			if (chs[i] < '0' || chs[i] > '9')
			{
				return false;
			}
		}
		return true;
	}
}
