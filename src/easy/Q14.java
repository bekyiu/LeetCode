package easy;

public class Q14
{
	public String longestCommonPrefix(String[] strs) 
    {
		int minLen = strs[0].length();
		for (String string : strs)
		{
			if(string.length() < minLen)
			{
				minLen = string.length();
			}
		}
		
		String result = "";
		String temp = strs[0];
		for (int i = 0; i < minLen; i++)
		{
			for(int j = 1; j < strs.length; j++)
			{
				if(!(temp.charAt(i) == strs[j].charAt(i)))
				{
					return result;
				}
			}
			result += temp.charAt(i);
		}
		return result;
    }
	
	public static void main(String[] args)
	{
		String[] strs = {"abcd", "abm", "abc"};
		String s = new Q14().longestCommonPrefix(strs);
		System.out.println(s);
	}
}
