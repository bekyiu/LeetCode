package other.chapter5;

public class Page261
{
	public boolean f(char[] chs)
	{
		boolean[] map = new boolean[256];
		for(int i = 0; i < chs.length; i++)
		{
			if(map[chs[i]])
			{
				return false;
			}
			else
			{
				map[chs[i]] = true;
			}
		}
		return true;
	}
}
