package util.sort;

import java.util.Arrays;

/*
 * 给定一个数组, 求 如果排序之后, 相邻两数的最大差值
 * 要求时间复杂度O(N), 且不能使用非基于比较的排序
 */
public class BucketProblem
{
	public static int fun(int[] arr)
	{
		int max = arr[0];
		int min = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		if(max == min)
		{
			System.out.println("zzz");
			return 0;
		}
		//准备n+1个桶
		int[] maxs = new int[arr.length + 1];
		int[] mins = new int[arr.length + 1];
		//默认全是false
		boolean[] hasNum = new boolean[arr.length + 1];
		//把数放进桶里
		for (int i = 0; i < arr.length; i++)
		{
			//得到当前述应该放到几号桶
			int bid = getBucketId(arr[i], arr.length, max, min);
			System.out.println(bid + ", num:" + arr[i]);
			if(hasNum[bid])
			{
				maxs[bid] = Math.max(maxs[bid], arr[i]);
				mins[bid] = Math.min(mins[bid], arr[i]);
			}
			else
			{
				maxs[bid] = mins[bid] = arr[i];
			}
			hasNum[bid] = true;
		}
		//指向当前非空桶最近的前一个非空桶
		int lastNotEmpty = 0;
		int result = 0;
		for(int i = 1; i < arr.length + 1; i++)
		{
			if(hasNum[i])
			{
				result = Math.max(mins[i] - maxs[lastNotEmpty], result);
				lastNotEmpty = i;
			}
		}
		return result;
	}
	
	public static int getBucketId(int num, int len, int max, int min)
	{
		//num - min 是相较于起点的位置 再除以每个桶可以放几个数 (max - min + 1) / (len + 1)
		return (int) ((num - min) * len) / (max - min);
	}
	public static void main(String[] args)
	{
		int[] arr = {3, 4, 1, 7, 9, -1, 2, 10, 20, 15, 13, -10};
		int max = fun(arr);
		System.out.println(max);
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
