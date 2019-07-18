package other.chapter5;

public class Page316
{
	
	public static char[] str = "abcccdefg".toCharArray();
	public static char[] exp = "ab.*d.*efg".toCharArray();
	
	public static boolean f(int i, int j)
	{
		if(j == exp.length)
		{
			return i == str.length;
		}
		
		if(j + 1 == exp.length || exp[j + 1] != '*')
		{
			return i != str.length && (exp[j] == '.' || exp[j] == str[i]) && f(i + 1, j + 1);
		}
		// 此时exp[j]之后一定还有字符并且这个字符一定是*
		while(i != str.length && (exp[j] == str[i] || exp[j] == '.'))
		{
			if(f(i, j + 2))
			{
				return true;
			}
			i++;
		}
		return f(i, j + 2);
	}
	
	public static void main(String[] args)
	{
		
	}
}
