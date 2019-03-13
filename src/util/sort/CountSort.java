package util.sort;

import java.util.Arrays;

//计数排数
/*
 * 给定一个数组arr, 每个数的范围是0~60, 要求把这个数组排序
 * 思路:
 * 我可以开一个大小是61的数组help, 用于存储arr数组中每个数出现的频次 
 * 例如 arr = [1, 3, 2, 2, 1, 1]
 * help[0] = 0 因为0一次也没有出现
 * help[1] = 3 因为1出现3次
 * help[2] = 2 因为2出现两次
 * help[3] = 1 因为3出现一次
 * 
 * 然后遍历help数组, 重新组织顺序
 */
public class CountSort
{
	
	public static void countSort(int[] arr)
	{
		int[] help = new int[61];
		for (int i = 0; i < arr.length; i++)
		{
			int helpIndex = arr[i];
			help[helpIndex]++;
		}

		int resultIndex = 0;
		//下面这段循环的复杂度是O(help.length + arr.length)
		//因为我的i每加1, 我的j就会走arr数组的一部分
		for (int i = 0; i < help.length; i++)
		{
			for(int j = 0; j < help[i]; j++)
			{
				arr[resultIndex] = i;
				resultIndex++;
			}
		}
	}
	
	public static void countSort2(int[] arr)
	{
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++)
		{
			max = arr[i] > max ? arr[i] : max;
			min = arr[i] < min ? arr[i] : min;
		}
		
		int[] help = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++)
		{
			int helpIndex = arr[i] - min;
			help[helpIndex]++;
		}
		
		int resultIndex = 0;
		for (int i = 0; i < help.length; i++)
		{
			for(int j = 0; j < help[i]; j++)
			{
				arr[resultIndex] = i + min;
				resultIndex++;
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 4, 23, 23, 60, 0, 6, 6, 1, 4, 9};
		CountSort.countSort2(arr);
		System.out.println(Arrays.toString(arr));
	}
}
