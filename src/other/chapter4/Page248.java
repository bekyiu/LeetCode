package other.chapter4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Page248
{
	// n
	public int longestConsecutive(int[] nums)
	{
		// 这样crud都是O(1)
		Set<Integer> set = new HashSet<>();
		for (int num : nums)
		{
			set.add(num);
		}
		int res = 0;
		for (Integer num : nums)
		{
			if (set.remove(num))
			{
				// 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
				int max = 1;
				int cur = num;
				while (set.remove(cur - 1))
				{
					cur--;
				}
				max += (num - cur);
				// 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
				cur = num;
				while (set.remove(cur + 1))
				{
					cur++;
				}
				max += (cur - num);
				// 更新最大值
				res = Math.max(res, max);
			}
		}
		return res;
	}

	// nlogn, 样本量小的时候快一些
	public int longestConsecutive2(int[] nums)
	{
		if (nums.length == 0)
		{
			return 0;
		}

		Arrays.sort(nums);

		int longestStreak = 1;
		int currentStreak = 1;

		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] != nums[i - 1])
			{
				if (nums[i] == nums[i - 1] + 1)
				{
					currentStreak += 1;
				} 
				else
				{
					longestStreak = Math.max(longestStreak, currentStreak);
					currentStreak = 1;
				}
			}
		}
		// 有可能最长的是最后一坨
		return Math.max(longestStreak, currentStreak);
	}
}
