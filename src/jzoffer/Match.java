package jzoffer;

public class Match
{
    public boolean match(char[] str, char[] pattern)
    {
        return p(str, pattern, 0, 0);
    }
    // 从str[i]和pattern[j]开始往后配直到结尾, 能不能成功
    public boolean p(char[] str, char[] pattern, int i, int j)
    {
    	// 如果pattern用完了, 那么str也必须要用完才算是匹配成功
    	if(j == pattern.length)
    	{
    		return i == str.length;
    	}
    	// 如果 j是最pattern的后一个位置 或者 j + 1位置不是*
    	if(j + 1 == pattern.length || pattern[j + 1] != '*')
    	{
    		return i != str.length && (str[i] == pattern[j] || pattern[j] == '.')
    				&& p(str, pattern, i + 1, j + 1);
    	}
    	// 此时j之后必定还有字符 且 这个字符一定是*
    	while(i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
    	{
    		if(p(str, pattern, i, j + 2))
    		{
    			return true;
    		}
    		i++;
    	}
    	return p(str, pattern, i, j + 2);
    }
}
