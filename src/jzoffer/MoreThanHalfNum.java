package jzoffer;

public class MoreThanHalfNum
{
	public static void main(String[] args)
	{
		MoreThanHalfNum obj = new MoreThanHalfNum();
		int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
		obj.moreThanHalfNum_Solution(arr);
	}
    public int moreThanHalfNum_Solution(int[] arr) 
    {
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        int res = arr[0];
        // 记录res出现的次数
        int times = 1;
        for(int i = 1; i < arr.length; i++)
        {
        	// 如果减到0了就记录下一个
        	if(times == 0)
        	{
        		res = arr[i];
        		times = 1;
        	}
        	else 
        	{
        		// 如果这个数和res相同次数就+1
        		// 因为有一个数出现的次数大于一半, 所以加一要多一些
        		if(arr[i] == res)
        		{
        			times++;
        		}
        		else
        		{
        			times--;
        		}
        	}
        }
        times = 0;
        for(int i = 0; i < arr.length; i++)
        {
        	if(res == arr[i]) 
        	{
        		times++;
        	}
        }
        return times > arr.length / 2 ? res : 0;
    }
    

}
