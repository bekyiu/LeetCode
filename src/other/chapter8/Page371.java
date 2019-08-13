package other.chapter8;

import java.util.Arrays;

public class Page371
{
    public static int findUnsortedSubarray1(int[] nums) 
    {
    	int[] temp = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(temp);
    	boolean first = true;
    	int left = 0;
    	int right = -1;
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(first && nums[i] != temp[i])
    		{
    			left = i;
    			first = false;
    		}
    		if(!first && nums[i] != temp[i])
    		{
    			right = i;
    		}
    	}
    	return right - left + 1;
    }
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length < 2)
        {
            return 0;
        }
    	int min = nums[nums.length - 1];
    	int left = -1;
    	for(int i = nums.length - 2; i >= 0; i--)
    	{
    		if(nums[i] > min)
    		{
    			left = i;
    		}
    		else
    		{
    			min = nums[i];
    		}
    	}
    	if(left == -1)
    	{
    		return 0;
    	}
    	int max = nums[0];
    	int right = -1;
    	for(int i = 1; i < nums.length; i++)
    	{
    		if(nums[i] < max)
    		{
    			right = i;
    		}
    		else
    		{
    			max = nums[i];
    		}
    	}
    	return right - left + 1;
    }
    public static void main(String[] args)
	{
    	int[] arr = {2, 6, 4, 8, 10, 9, 15};
    	System.out.println(Arrays.toString(arr));
    	Arrays.sort(arr);
    	System.out.println(Arrays.toString(arr));
	}
}
