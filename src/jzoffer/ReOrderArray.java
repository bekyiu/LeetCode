package jzoffer;

import java.util.Arrays;

public class ReOrderArray
{
	// 不能保证奇偶之间的相对顺序不变
	public void reOrderArray1(int[] array)
	{
		int odd = -1;
		int cur = 0;
		while (cur < array.length)
		{
			if (isOdd(array[cur]))
			{
				swap(array, ++odd, cur);
			}
			cur++;
		}
	}

	// 不能保证奇偶之间的相对顺序不变
	public void reOrderArray2(int[] array)
	{
		int i = 0, j = array.length - 1;
		while (i < j)
		{
			while (i < j && isOdd(array[i]))
			{
				i++;
			}
			while (i < j && !isOdd(array[j]))
			{
				j--;
			}
			if (i < j)
			{
				swap(array, i, j);
			}
		}
	}
	// 稳定的
	public void reOrderArray(int[] array)
	{
		// 当前奇数的个数
		// 实际指向的是奇数序列最后一个元素的下一个位置
		int k = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(isOdd(array[i]))
			{
				int j = i;
				while(j > k)
				{
					swap(array, j, j - 1);
					j--;
				}
				k++;
			}
		}
	}

	public void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public boolean isOdd(int num)
	{
		return (num & 1) == 1;
	}

	public static void main(String[] args)
	{
		ReOrderArray obj = new ReOrderArray();
		int[] arr =
		{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		obj.reOrderArray(arr);
		System.out.println(Arrays.toString(arr));
	}
}
