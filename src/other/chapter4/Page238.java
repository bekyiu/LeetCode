package other.chapter4;

public class Page238
{

	public static void main(String[] args)
	{
		Page238 obj = new Page238();
		int z = obj.num("1121010");
		int k = obj.dpMethod("1121010".toCharArray());
		System.out.println(z);
		System.out.println(k);
	}

	public int num(String str)
	{
		char[] chs = str.toCharArray();
		return p(chs, 0);
	}

	public int p(char[] chs, int i)
	{
		if (i == chs.length)
		{
			return 1;
		}
		if (chs[i] == '0')
		{
			return 0;
		}
		int res = p(chs, i + 1);
		if (i + 1 < chs.length && (chs[i] - '0') * 10 + chs[i + 1] - '0' < 27)
		{
			res += p(chs, i + 2);
		}
		return res;
	}

	public int dpMethod(char[] chs)
	{
		int[] dp = new int[chs.length + 1];
		dp[chs.length] = 1;
		for (int i = dp.length - 2; i >= 0; i--)
		{
			if (chs[i] == '0')
			{
				dp[i] = 0;
			}
			else
			{
				dp[i] = dp[i + 1];
				if (i + 1 < chs.length && (chs[i] - '0') * 10 + chs[i + 1] - '0' < 27)
				{
					dp[i] += dp[i + 2];
				}
			}

		}
		return dp[0];
	}
}
