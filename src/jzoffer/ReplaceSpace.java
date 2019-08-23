package jzoffer;

public class ReplaceSpace
{
    public String replaceSpace(StringBuffer str) 
    {
    	char[] chs = str.toString().toCharArray();
        int count = 0;
        // 计算有多少个空格
        for (int i = 0; i < chs.length; i++)
        {
            if(chs[i] == ' ')
            {
                count++;
            }
        }
        // 开始填新数组
        char[] res = new char[chs.length + 2 * count];
        int index = res.length - 1;
        for(int i = chs.length - 1; i >= 0; i--)
        {
            if(chs[i] != ' ')
            {
                res[index--] = chs[i];
            }
            else
            {
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            }
        }
        return new String(res);
    }
}
