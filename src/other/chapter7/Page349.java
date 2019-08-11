package other.chapter7;

public class Page349
{
	public static void main(String[] args)
	{
		
	}
	// 输入0返回1, 输入1返回0
	public int flip(int n)
	{
		return n ^ 1;
	}
	// n >= 0返回1, 否则返回0
	public int sign(int n)
	{
		return flip((n >> 31) & 1);
	}
	
	// 不考虑a - b可能会溢出
	public int getMax1(int a, int b)
	{
		int c = a - b;
		int scA = sign(c);
		int scB = flip(scA);
		return scA * a + scB * b;
	}
	
	// 考虑溢出情况
	public int getMax2(int a, int b)
	{
		int sa = sign(a);
		int sb = sign(b);
		int sc = sign(a - b);
		// 只有a和b不是同符号的时候a - b才可能溢出
		int difSab = sa ^ sb;
		int sameSab = flip(difSab);
		int returnA = difSab * sa + sameSab * sc;
		int returnB = flip(returnA);
		return returnA * a + returnB * b;
	}
}
