package other.chapter5;

import java.util.ArrayList;
import java.util.List;

public class Page302
{
	public static String pointNewchar(String s, int k)
	{
		List<String> list = new ArrayList<>();
		char[] chs = s.toCharArray();
		int i = 0;
		while (i < chs.length)
		{
			// 如果是大写字母一定会后他后面一个构成一组
			if (isBig(chs[i]))
			{
				String temp = "" + chs[i] + chs[i + 1];
				list.add(temp);
				i += 2;
			} 
			else
			{
				// 如果是小写一定自己一组
				list.add(String.valueOf(chs[i++]));
			}
		}
		int len = 0;
		for (String str : list)
		{
			len += str.length();
			if(len - 1 >= k)
			{
				return str;
			}
		}
		return "sb";
	}

	public static boolean isBig(char c)
	{
		if (c >= 'a' && c <= 'z')
		{
			return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		String z = Page302.pointNewchar("aaABCDEcBCg", 3);
		System.out.println(z);
	}
}
