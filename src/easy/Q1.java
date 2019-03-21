package easy;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Q1
{
	public int[] twoSum(int[] nums, int target)
	{
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++)
		{
			//存当前数和当前数的下标
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++)
		{
			int complement = target - nums[i];
			//不能重复利用这个数组中同样的元素
			if (map.containsKey(complement) && map.get(complement) != i)
			{
				return new int[]
				{ i, map.get(complement) };
			}
		}

		throw new IllegalArgumentException("No two sum solution");
	}
}
