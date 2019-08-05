package medium;

public class Q151
{
	// 很慢, 可以用Page267的做法, 但是Page267没有处理多余的空格, 还应该删除多余的空格
    public String reverseWords(String s) 
    {
        if(s == null || s.length() == 0)
        {
            return "";
        }
        String[] strs = s.trim().split(" ");
        String res = "";
        for (int i = strs.length - 1; i >= 0; i--)
        {
            String a = strs[i].trim();
            if(a.equals(""))
            {
                continue;
            }
            res += a + " ";
        }
        
        return res.trim();
    }
}
