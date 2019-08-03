package hard;

import java.util.HashSet;
import java.util.Set;

public class Q128
{
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
}
