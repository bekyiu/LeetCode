package easy;

import java.util.Arrays;

/*
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 [ n/2 ] 的元素。
      你可以假设数组是非空的，并且给定的数组总是存在众数。
   1: 枚举每个位置出现的次数 O(n^2)
   2: map记录每个位置出现的次数O(n)
   3: 根据题意, 可以排序nlogn
 * 
 */
public class Q169
{
	//7ms
    public int majorityElement(int[] nums) 
    {
    	Arrays.sort(nums);
    	return nums[nums.length / 2];
    }
    //32ms
//    public int majorityElement(int[] nums) 
//    {
//    	int threshold = nums.length / 2;
//    	Map<Integer, Integer> map = new HashMap<>();
//    	for (int i = 0; i < nums.length; i++)
//    	{
//    		Integer count = map.get(nums[i]);
//    		if(count == null)
//    		{
//    			map.put(nums[i], 1);
//    		}
//    		else
//    		{
//    			map.put(nums[i], count + 1);
//    		}
//    	}
//    	for(Integer key : map.keySet())
//    	{
//    		int count = map.get(key);
//    		if(count > threshold)
//    		{
//    			return key;
//    		}
//    	}
//    	return -1;
//    }
    //2000ms+
//    public int majorityElement(int[] nums) 
//    {
//    	int threshold = nums.length / 2;
//    	int count = 0;
//    	for (int i = 0; i < nums.length; i++)
//    	{
//    		for(int j = 0; j < nums.length; j++)
//    		{
//    			if(nums[j] == nums[i])
//    			{
//    				count++;
//    			}
//    		}
//    		if(count > threshold)
//    		{
//    			return nums[i];
//    		}
//    		count = 0;
//    	}
//    	return -1;
//    	
//    }
}
