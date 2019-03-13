package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个没有重复数字的序列，返回其所有可能的全排列。
public class Q46
{
//	private List<List<Integer>> res = new ArrayList<List<Integer>>();
//    public List<List<Integer>> permute(int[] nums) {
//    	p(nums, 0, nums.length);
//    	return res;
//    }
//    public void p(int[] nums, int cur, int len)
//    {
//    	//cur == len - 1也行
//    	if(cur == len)
//    	{
//    		List<Integer> list = new ArrayList<>();
//    		for (int i : nums)
//			{
//				list.add(i);
//			}
//    		res.add(list);
//    		return;
//    	}
//    	for(int i = cur; i < len; i++)
//    	{
//    		swap(nums, cur, i);
//    		p(nums, cur + 1, len);
//    		swap(nums, cur, i);
//    	}
//    }
//	public void swap(int[] arr, int i, int j)
//	{
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}
	
	private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private Set<Integer> visit = new HashSet<>();
    private int[] box;
	public List<List<Integer>> permute(int[] nums) {
    	box = new int[nums.length];
		dfs(0, nums);
    	return res;
    }
	//dfs解法
	public void dfs(int cur, int nums[])
	{
		if(cur == nums.length)
		{
    		List<Integer> list = new ArrayList<>();
    		for (int i : box)
			{
				list.add(i);
			}
    		res.add(list);
    		return;
		}
		for (int i = 0; i < nums.length; i++)
		{
			if(!visit.contains(nums[i]))
			{
				box[cur] = nums[i];
				visit.add(nums[i]);
				dfs(cur + 1, nums);
				visit.remove(nums[i]);
			}
		}
	}
	
	
}
