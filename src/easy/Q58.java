package easy;


/*
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
      如果不存在最后一个单词，请返回 0 
 */
public class Q58
{
    public static int lengthOfLastWord(String s) 
    {
    	s = trim(s);
    	int lastSpaceIndex = -1;
    	int result = 0;
    	for(int i = 0; i < s.length(); i++)
    	{
    		if(s.charAt(i) == ' ')
    		{
    			lastSpaceIndex = i;
    		}
    	}
    	for(int j = lastSpaceIndex + 1; j < s.length(); j++)
    	{
    		result++;
    	}
    	return result;
    }
    
    public static String trim(String s)
    {
    	int firstCharIndex = -1;
    	int lastCharIndex = -1;
    	for (int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) != ' ')
			{
				firstCharIndex = i;
				break;
			}
		}
    	for(int i = s.length() - 1; i >= 0; i--)
    	{
    		if(s.charAt(i) != ' ')
    		{
    			lastCharIndex = i;
    			break;
    		}
    	}
    	if(firstCharIndex == -1 && lastCharIndex == -1)
    	{
    		return "";
    	}
    	StringBuilder sb = new StringBuilder(lastCharIndex - firstCharIndex + 1);
    	for(int i = firstCharIndex; i <= lastCharIndex; i++)
    	{
    		sb.append(s.charAt(i));
    	}
    	return sb.toString();
    }
    
//可行    
//    public static int lengthOfLastWord(String s) 
//    {
//    	String strs[] = s.trim().split(" ");
//    	if(strs.length == 1)
//    	{
//    		return strs[0].length();
//    	}
//    	return strs[strs.length - 1].length();
//    }
    
    public static void main(String[] args)
	{
		String a = trim("a");
		System.out.println(a);
	}
}
