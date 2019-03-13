package easy;

public class Q7
{
    public int reverse(int x) 
    {
    	int result = 0;
        while(x != 0)
        {
        	int last = x % 10;
        	int res = result * 10 + last;
        	if((res - last) / 10 != result)
        	{
        		return 0;
        	}
        	result = res;
        	x /= 10;
        }
       
        return result;
    }
	public static void main(String[] args)
	{
		System.out.println(new Q7().reverse(153426469));
	}
}
