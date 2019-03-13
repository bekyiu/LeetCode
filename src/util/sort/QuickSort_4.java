package util.sort;

import java.util.Arrays;

import util.DSQ;

//随机快排
//每次用于比较的基准都是随机的, 而不是固定的
//概率算下来 nlogn
public class QuickSort_4
{
	public static void quickSort(int[] arr, int L, int R)
	{
		if (L < R)
		{
			//每次都在待排序的位置中随机选择一个, 和R位置交换 注意加上L这个偏移
			int randomIndex = (int) (Math.random() * (R - L + 1)) + L;
			//randomIndex∈[L, R]
			DSQ.swap(arr, randomIndex, R);
			//返回的是等于部分的位置
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0] - 1);
			quickSort(arr, p[1] + 1, R);
		}
	}
	public static int[] partition(int[] arr, int L, int R)
	{
		// 默认是以最后一个数为基准
		int less = L - 1;
		int more = R;
		// 基准
		int threshold = arr[R];
		int cur = L;
		while (cur < more)
		{
			if (arr[cur] < threshold)
			{
				DSQ.swap(arr, ++less, cur++);
			} 
			else if(arr[cur] == threshold)
			{
				cur++;
			}
			else
			{
				DSQ.swap(arr, cur, --more);
			}
		}
		DSQ.swap(arr, more, R);
		return new int[] {less + 1,  more};
	}

	public static void main(String[] args)
	{
		for(int i = 0; i < 1000000; i++)
		{
			int[] arr = DSQ.generateRandomArray(20, 50);
			int[] arr1 = DSQ.copyArray(arr);
			int[] arr2 = DSQ.copyArray(arr);
			QuickSort_4.quickSort(arr1, 0, arr1.length - 1);
			DSQ.okMethod(arr2);
			if(!DSQ.isEqual(arr1, arr2))
			{
				System.out.println("sb");
				System.out.println(Arrays.toString(arr));
				System.out.println(Arrays.toString(arr1));
				break;
			}
//			System.out.println(Arrays.toString(arr1));
		}
		System.out.println("finish...");
	}
}
