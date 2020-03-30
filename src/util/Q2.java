package util;

import java.util.Arrays;

public class Q2
{
	public static void main(String[] args)
	{
		int[] arr = {6, 1, 4, -1, 0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void heapInsert(int[] arr, int index)
	{
		int fatherIndex = (index - 1) / 2;
		while(arr[index] > arr[fatherIndex])
		{
			DSQ.swap(arr, fatherIndex, index);
			index = fatherIndex;
			fatherIndex = (index - 1) / 2;
		}
	}

	// [0, heapSize - 1]
	public static void heapify(int[] arr, int index, int heapSize)
	{
		int left = 2 * index + 1;
		while(left < heapSize)
		{
			int right = left + 1;
			int maxIndex;
			if(right < heapSize && arr[right] > arr[left])
			{
				maxIndex = right;
			}
			else
			{
				maxIndex = left;
			}
			maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;
			if(maxIndex == index)
			{
				return;
			}
			DSQ.swap(arr, maxIndex, index);
			index = maxIndex;
			left = 2 *index + 1;
		}
	}
	
	public static void sort(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			heapInsert(arr, i);
		}
		
		int heapSize = arr.length;
		while(heapSize > 0)
		{
			DSQ.swap(arr, 0, heapSize - 1);
			heapify(arr, 0, --heapSize);
		}
		
	}
	
}
