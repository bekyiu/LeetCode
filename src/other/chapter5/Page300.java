package other.chapter5;

public class Page300
{
	public int lengthOfLongestSubstring(String s)
	{
		if(s == null || s.equals(""))
		{
			return 0;
		}
		char[] chs = s.toCharArray();
		int[] map = new int[256];
		for(int i = 0; i < 256; i++)
		{
			map[i] = -1;
		}
		int len = 0;
		int cur = 0;
		int pre = -1;
		
		for(int i = 0; i < chs.length; i++)
		{
			pre = Math.max(pre, map[chs[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[chs[i]] = i;
		}
		return len;
	}
}
