package other.chapter8;

import java.util.Arrays;

// 遇到基本可以放弃
public class Page386
{
	public static int fun(int[] arr, int aim)
	{
		// sums[i]表示从 arr的i位置向右扩的最小累加和是多少
		int[] sums = new int[arr.length];
		// ends[i]表示sum[i]对应的累加和是从i位置扩到什么(ends[i])位置
		int[] ends = new int[arr.length];
		// 例如 arr: -1, -2, 3, 4
		// sums[0] = -1 + -2 = -3, ends[0] = 1
		// 现在开始从后往前填这两个数组, 实际上是个dp
		sums[arr.length - 1] = arr[arr.length - 1];
		ends[arr.length - 1] = arr.length - 1;
		for(int i = arr.length - 2; i >= 0; i--)
		{
			if(sums[i + 1] < 0)
			{
				sums[i] = sums[i + 1] + arr[i];
				ends[i] = ends[i + 1];
			}
			else
			{
				sums[i] = arr[i];
				ends[i] = i;
			}
		}
		// 开始求满足题意的最长子数组的长度
		
		// 右边界
		int r = 0;
		int sum = 0;
		int len = -1;
		for(int start = 0; start < arr.length; start++)
		{
			// 向右一直扩到不能再扩为止
			while(r < arr.length && sum + sums[r] <= aim)
			{
				sum += sums[r];
				r = ends[r] + 1;
			}
			// r > start 说明扩动了, 减去左边在范围里的第一个数
			// 在下一轮循环中, 尝试是否能以start + 1开头从r位置开始扩
			sum -= r > start ? arr[start] : 0;
			len = Math.max(len, r - start);
			// r可能扩不动, 至少得保证r不能再start左边, 因为r是从start开始扩的右边界
			// 例如 arr = 100, 200, -10; aim = 7
			// 第一轮 r = 0, start = 0, sums[0] = 100 > 7, 扩不动, 说明从0位置开始不可能找到累加和小于等于7的子数组
			// 下一轮start++就从1开始了, 但r还是0
			// 所以
			r = Math.max(r, start + 1);
		}
		return len;
	}

	// 填数组的递归版本
	public static int f(int[] arr, int index, int[] res)
	{
		if (index == arr.length - 1)
		{
			res[index] = arr[index];
			return res[index];
		}
		int temp = f(arr, index + 1, res);
		if(temp < 0)
		{
			res[index] = arr[index] + temp;
		}
		else
		{
			res[index] = arr[index];
		}
		return res[index];
	}

	public static void main(String[] args)
	{
		int[] arr =
		{ -1, -2, 3, -1, -2 };
		int[] res = new int[arr.length];
		System.out.println(f(arr, 0, res));
		System.out.println(Arrays.toString(res));
	}
}
