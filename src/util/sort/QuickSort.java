package util.sort;

import java.util.Arrays;

public class QuickSort
{
	// <= num 放左边 > num放右边
	public static void fun(int[] arr, int num)
	{
		//双指针, i永远指向小于等于范围的最后一个元素
		int i = -1;
		for (int j = 0; j < arr.length; j++)
		{
			if(arr[j] <= num)
			{
				//与小于等于范围的下一个位置的数交换
				int temp = arr[j];
				arr[j] = arr[i + 1];
				arr[i + 1] = temp;
				i++;
			}
		}
	}
	//荷兰国旗问题 小于num放左边 等于num放中间 大于num放右边
	public static void fun2(int[] arr, int num)
	{
		//less指向小于区域的最后一个元素
		int less = -1;
		//more指向大于区域的第一个元素
		int more = arr.length;
		int cur = 0;
		while(cur < more)
		{
			if(arr[cur] == num)
			{
				cur++;
			}
			else if(arr[cur] < num)
			{
				swap(arr, less + 1, cur);
				less++;
				cur++;
			}
			else
			{
				swap(arr, cur, more - 1);
				more--;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args)
	{
		int[] arr = {5, 2, 99 , -1, 614, 5, 0, 5, 6, 7, -6};
		fun2(arr, 5);
		System.out.println(Arrays.toString(arr));
	}
}
