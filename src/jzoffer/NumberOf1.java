package jzoffer;

public class NumberOf1
{
    public int numberOf1(int n) 
    {
        int res = 0;
        // 把负数变成正数
        if(n < 0)
        {
            n = n & 0x7FFFFFFF;
            res++;
        }
        while(n != 0)
        {
            if((n & 1) == 1)
            {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }
}
