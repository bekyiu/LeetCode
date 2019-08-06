package other.chapter5;

public class Page276
{
	public static void main(String[] args)
	{
		Page276 obj = new Page276();
		String str = obj.removeDuplicateLetters("baacbaccac");
		System.out.println(str);
	}
	public String removeDuplicateLetters(String s)
	{
		char[] str = s.toCharArray();
		// 词频统计
		int[] map = new int[26];
		for(int i = 0; i < str.length; i++)
		{
			map[str[i] - 'a']++;
		}
		char[] res = new char[26];
		int index = 0;
		int l = 0;
		int r = 0;
		while(r < str.length)
		{
			if(map[str[r] - 'a'] == -1 || --map[str[r] - 'a'] > 0)
			{
				r++;
			}
			else
			{
				// 在[l, r]的范围上找到最小的字母
				int pick = -1;
				for(int i = l; i <= r; i++)
				{
					if(map[str[i] - 'a'] != -1 && (pick == - 1 || str[i] < str[pick]))
					{
						pick = i;
					}
				}
				res[index++] = str[pick];
				// 把词频次数重新加回来
				for(int i = pick + 1; i <= r; i++)
				{
					if(map[str[i] - 'a'] != -1)
					{
						map[str[i] - 'a']++;
					}
				}
				
				map[str[pick] - 'a'] = -1;
				l = pick + 1;
				r = l;
			}
		}
		return new String(res, 0, index);
	}
}
