package util.sort;

import java.util.Arrays;

import util.DSQ;

//给定一个数组 奇数放左边 偶数放右边
public class QS
{

	public static void fun(int[] arr)
	{
		int ji = -1;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
			{
				DSQ.swap(arr, i, ++ji);
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 6, 0, 3, 7, 9, 10, -2};
		fun(arr);
		System.out.println(Arrays.toString(arr));
	}
}
