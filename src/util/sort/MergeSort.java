package util.sort;

import java.util.Arrays;

import util.DSQ;

public class MergeSort
{
	public static void mergeSort(int[] arr)
	{
		process(arr, 0, arr.length - 1);
	}
	
	private static void process(int[] arr, int L, int R)
	{
		if(L == R)
		{
			return;
		}
		int mid = (L + R) / 2;
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	private static void merge(int[] arr, int L, int mid, int R)
	{
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		while(p1 <= mid && p2 <= R)
		{
			if(arr[p1] < arr[p2])
			{
				help[i] = arr[p1];
				p1++;
			}
			else
			{
				help[i] = arr[p2];
				p2++;
			}
			i++;
		}
		while(p1 <= mid)
		{
			help[i++] = arr[p1++];
		}
		while(p2 <= R)
		{
			help[i++] = arr[p2++];
		}
		
		for(int j = 0; j < help.length; j++)
		{
			arr[L + j] = help[j];
		}
	}

	public static void main(String[] args)
	{
		for (int i = 0; i < 1000; i++)
		{
			int[] arr = DSQ.generateRandomArray(10000, 1000);
			int[] arr1 = DSQ.copyArray(arr);
			int[] arr2 = DSQ.copyArray(arr);
			int[] arr3 = DSQ.copyArray(arr);
			mergeSort(arr1);
			DSQ.okMethod(arr2);
			if(!DSQ.isEqual(arr1, arr2))
			{
				System.out.println(Arrays.toString(arr3));
				System.out.println("fuck");
				break;
			}
		}
		System.out.println("finish..");

	}
}
