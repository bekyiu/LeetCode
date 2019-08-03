package other.chapter5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Page252
{
	public static void main(String[] args)
	{
		System.out.println(Page252.f("1122336655", "2233661155"));
	}
	public static boolean f(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str1.length(); i++)
		{
			char ch = str1.charAt(i);
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch) + 1);
			}
			else
			{
				map.put(ch, 1);
			}
		}
		for(int i = 0; i < str2.length(); i++)
		{
			char ch = str2.charAt(i);
			if(map.containsKey(ch))
			{
				map.put(ch, map.get(ch) - 1);
			}
			else
			{
				return false;
			}
		}
		Collection<Integer> values = map.values();
		for (Integer integer : values)
		{
			if(integer != 0)
			{
				return false;
			}
		}
		return true;
	}
}
