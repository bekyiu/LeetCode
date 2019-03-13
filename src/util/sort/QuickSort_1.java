package util.sort;

import java.util.Arrays;

import util.DSQ;

//经典快排
public class QuickSort_1
{
	//经典快排
	public static void quickSort(int[] arr, int L, int R)
	{
		if (L < R)
		{
			//返回值是 less的下一个位置, 因为这个位置实现被换成了基准值
			int mid = partition(arr, L, R);
			quickSort(arr, L, mid - 1);
			quickSort(arr, mid + 1, R);
		}
	}
	public static int partition(int[] arr, int L, int R)
	{
		// 默认是以最后一个数为基准
		int less = L - 1;
		// 基准
		int threshold = arr[R];
		int cur = L;
		while (cur < R)
		{
			if (arr[cur] <= threshold)
			{
				DSQ.swap(arr, ++less, cur++);
			} else
			{
				cur++;
			}
		}
		DSQ.swap(arr, less + 1, R);
		return less + 1;
	}

	public static void main(String[] args)
	{
		for(int i = 0; i < 1000000; i++)
		{
			int[] arr = DSQ.generateRandomArray(50, 100);
			int[] arr1 = DSQ.copyArray(arr);
			int[] arr2 = DSQ.copyArray(arr);
			QuickSort_1.quickSort(arr1, 0, arr1.length - 1);
			DSQ.okMethod(arr2);
			if(!DSQ.isEqual(arr1, arr2))
			{
				System.out.println("sb");
				System.out.println(Arrays.toString(arr));
				break;
			}
//			System.out.println(Arrays.toString(arr1));
		}
		System.out.println("finish...");
	}
}
