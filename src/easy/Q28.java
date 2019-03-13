package easy;

public class Q28
{
    public int strStr(String haystack, String needle) {
    	int iLen = haystack.length();
    	int jLen = needle.length();
        if(haystack == null || needle == null || (iLen < jLen))
        {
            return -1;
        }
    	char[] str1 = haystack.toCharArray();
    	char[] str2 = needle.toCharArray();
    	int i = 0, j = 0;
    	int[] next = this.getNext(str2);
        if(next == null)
        {
            return 0;
        }
    	while(i < iLen && j < jLen)
    	{
    		//j == -1 说明已经退到str2的第一个字符了的左边了
    		if(j == -1 || str1[i] == str2[j])
    		{
    			i++;
    			j++;
    		}
    		else
    		{
    			j = next[j];
    		}
    	}
    	return j == jLen ? i - j : -1;
    }
	public int[] getNext(char[] str2)
	{
        if(str2.length == 0)
        {
            return null;
        }
		if(str2.length == 1)
		{
			return new int[] {-1};
		}
		int[] next = new int[str2.length];
		next[0] = -1;
		next[1] = 0;
		//用来遍历next
		int i = 2;
		//str2[]的索引, 当前跳到的位置
		int cn = 0;
		while(i < next.length)
		{
			if(str2[i - 1] == str2[cn])
			{
				next[i] = ++cn;
				i++;
			}
			else
			{
				if(cn > 0)
				{
					cn = next[cn];
				}
				else
				{
					next[i++] = 0;
				}
			}
		}
		return next;
	}
	public static void main(String[] args)
	{

	}
}
