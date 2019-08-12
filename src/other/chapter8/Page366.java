package other.chapter8;

import java.util.Arrays;

import util.DSQ;

public class Page366
{
	public static void heapInsert(int[] arr, int index)
	{
		int fatherIndex = (index - 1) / 2;
		while(arr[fatherIndex] < arr[index])
		{
			DSQ.swap(arr, index, fatherIndex);
			index = fatherIndex;
			fatherIndex = (index - 1) / 2;
		}
	}
	
	public static void heapify(int[] arr, int index, int heapSize)
	{
		int left = index * 2 + 1;
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
			maxIndex = maxIndex > index ? maxIndex : index;
			if(maxIndex == index)
			{
				break;
			}
			DSQ.swap(arr, maxIndex, index);
			index = maxIndex;
			left = 2 * index + 1;
		}
	}
	
	public static void heapSort(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			heapInsert(arr, i);
		}
		
		int heapSize = arr.length;
		while(heapSize > 0)
		{
			DSQ.swap(arr, 0, --heapSize);
			heapify(arr, 0, heapSize);
		}
	}
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 0, -2, 614, 999, 18};
		int k = 1;
		int[] heap = new int[k]; 
		for(int i = 0; i < k; i++)
		{
			heap[i] = arr[i];
			heapInsert(heap, i);
		}
		for(int i = k; i < arr.length; i++)
		{
			if(arr[i] < heap[0])
			{
				heap[0] = arr[i];
				heapify(heap, 0, k);
			}
		}
		System.out.println(heap[0]);
		//---
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
