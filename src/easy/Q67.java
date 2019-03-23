package easy;


/*
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
      输入为非空字符串且只包含数字 1 和 0。
 */
public class Q67
{
	/* 
	 *  1 1 -> 0
	 *  1 0 -> 1
	 *  0 1 -> 1
	 *  0 0 -> 0
	 *  一共四种情况
	 */
    public static String addBinary(String a, String b) 
    {
    	//num1 存较大的数
    	char[] num1;
    	char[] num2;
    	if(a.length() > b.length())
    	{
    		num1 = a.toCharArray();
    		num2 = b.toCharArray();
    	}
    	else
    	{
    		num2 = a.toCharArray();
    		num1 = b.toCharArray();
    	}
    	//结果
    	StringBuilder sb = new StringBuilder(num1.length + 1);
    	//是否需要进位
    	boolean isAdd = false;
    	//i指向num2最后一位, j指向num1最有后一位, 手动模拟加法
    	for(int i = num2.length - 1, j = num1.length - 1; i >= 0; i--, j--)
    	{
    		if(num1[j] == '0' && num2[i] == '0')
    		{
    			if(!isAdd)
    			{
    				sb.append("0");
    			}
    			else
    			{
    				sb.append("1");
    				//此时计算下一轮时肯定不用进位 所以改变状态
    				isAdd = false;
    			}
    		}
    		else if((num1[j] == '1' && num2[i] == '0') || (num1[j] == '0' && num2[i] == '1'))
    		{
    			if(!isAdd)
    			{
    				sb.append("1");
    			}
    			else
    			{
    				//需要进位
    				sb.append("0");
    			}
    		}
    		else
    		{
    			if(!isAdd)
    			{
    				sb.append("0");
    				isAdd = true;
    			}
    			else
    			{
    				sb.append("1");
    			}
    		}
    	}
    	//处理num1多出来的数字
    	for(int i = num1.length - num2.length - 1; i >= 0; i--)
    	{
    		if(!isAdd)
    		{
    			sb.append(num1[i]);
    		}
    		else
    		{
    			if(num1[i] == '1')
    			{
    				sb.append("0");
    			}
    			else
    			{
    				sb.append("1");
    				isAdd = false;
    			}
    		}
    	}
    	//如果最后还有进位, 记得加1 
    	//比如 11 + 1
    	if(isAdd)
    	{
    		sb.append("1");
    	}
    	return sb.reverse().toString();
    }
    public static void main(String[] args)
	{
    	String s = addBinary("110010", "100");
    	System.out.println(s);
	}
}
