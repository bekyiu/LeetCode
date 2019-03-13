package util;

import java.util.Arrays;

public class DSQ
{
	//返回一个范围在[0, size]之间, 元素大小在[-value, +value]之间的数组
	public static int[] generateRandomArray(int size, int value)
	{
		//Math.random() -> double [0, 1)
		//arr -> [0, size]
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++)
		{
			//[0, value] - [0, value - 1] -> [1 - value, value]
			arr[i] = (int) ((value + 1) * Math.random()) - (int)(value * Math.random());
		}
		return arr;
	}
	
	public static int[] copyArray(int[] arr)
	{
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			temp[i] = arr[i];
		}
		return temp;
	}
	
	public static boolean isEqual(int[] arr1, int[] arr2)
	{
		if(arr1.length != arr2.length)
		{
			return false;
		}
		for (int i = 0; i < arr2.length; i++)
		{
			if(arr1[i] != arr2[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void okMethod(int[] arr)
	{
		Arrays.sort(arr);
	}
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
