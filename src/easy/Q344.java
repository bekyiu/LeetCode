package easy;
//原地翻转字符串
public class Q344
{
    public void reverseString(char[] s) 
    {
    	int i = 0, j = s.length - 1;
    	while(i < j)
    	{
    		char temp = s[i];
    		s[i] = s[j];
    		s[j] = temp;
    		i++;
    		j--;
    	}
    }
}
