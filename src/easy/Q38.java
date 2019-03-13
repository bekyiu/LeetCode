package easy;

public class Q38
{
	public String countAndSay(int n) 
	{
        if(n == 1)
        {
            return "1";
        }
        //拿到上一次的值
        String str = countAndSay(n-1) + "*";//为了str末尾的标记，方便循环读数
        char[] c = str.toCharArray();
        int count = 1;
        //String s = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c.length - 1;i++)
        {
        	//这里的i + 1 因为前面加了* 就不会越界
        	if(c[i] == c[i+1])
        	{
        		count++;//计数增加
        	}
        	else
        	{
        		//s = s + count + c[i];//上面的*标记这里方便统一处理
                sb.append(count).append(c[i]);
        		count = 1;//初始化
        	}
        }
        //return s;
        return sb.toString();
    }
	public static void main(String[] args)
	{

	}
}
