package medium;

import java.util.ArrayList;
import java.util.List;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
public class Q47
{
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    	p(nums, 0, nums.length);
    	return res;
    }
    public boolean isSwap(int nums[], int i, int len)
    {
    	for(int j = i + 1; j < len; j++)
    	{
    		if(nums[j] == nums[i])
    		{
    			return false;
    		}
    	}
    	return true;
    }
    public void p(int[] nums, int cur, int len)
    {
    	//cur == len - 1也行
    	if(cur == len)
    	{
    		List<Integer> list = new ArrayList<>();
    		for (int i : nums)
			{
				list.add(i);
			}
    		res.add(list);
    		return;
    	}
    	for(int i = cur; i < len; i++)
    	{
    		if(isSwap(nums, i, len))
    		{
        		swap(nums, cur, i);
        		p(nums, cur + 1, len);
        		swap(nums, cur, i);
    		}
    	}
    }
	public void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
