package util.sort;

import java.util.Arrays;

import util.DSQ;

public class HeapSort
{
	public static void heapSort(int[] arr)
	{
		if(arr == null || arr.length < 2)
		{
			return;
		}
		//每次往堆中加入一个数, 完成上浮操作, 构造大根堆
		for(int i = 0; i < arr.length; i++)
		{
			heapInsert(arr, i);
		}
		int heapSize = arr.length;
		DSQ.swap(arr, 0, --heapSize);
		while(heapSize > 0)
		{
			heapify(arr, 0, heapSize);
			DSQ.swap(arr, 0, --heapSize);
		}
	}
	
	public static void heapInsert(int[] arr, int index)
	{
		int fatherIndex = (index - 1) / 2;
		while(arr[index] > arr[fatherIndex])
		{
			DSQ.swap(arr, index, fatherIndex);
			index = fatherIndex;
			fatherIndex = (index - 1) / 2;
		}
	}
	
	/*
	在[0, heapSize-1]上形成了大根堆, index位置的数发生了变化
	进行heapify操作, 使[0, heapSize-1]位置上仍是大根堆
	*/
	public static void heapify(int[] arr, int index, int heapSize)
	{
		int leftIndex = 2 * index + 1;
		while(leftIndex < heapSize)
		{
			int rightIndex = leftIndex + 1;
			int maxIndex;
			//如果当前index有右儿子, 并且右儿子还比左儿子大
			if(rightIndex < heapSize && arr[rightIndex] > arr[leftIndex])
			{
				maxIndex = rightIndex;
			}
			else//当前index没有右儿子, 或者又有儿子但右儿子小于左儿子
			{
				maxIndex = leftIndex;
			}
			maxIndex = arr[maxIndex] > arr[index] ? maxIndex : index;
			//index是三者中的最大值, 那么就不用换了
			if(maxIndex == index)
			{
				break;
			}
			DSQ.swap(arr, index, maxIndex);
			index = maxIndex;
			leftIndex = 2 * index + 1;
		}
	}
	
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 1000000; i++)
		{
			int[] arr = DSQ.generateRandomArray(100, 50);
			int[] arr1 = DSQ.copyArray(arr);
			int[] arr2 = DSQ.copyArray(arr);
			HeapSort.heapSort(arr1);
			DSQ.okMethod(arr2);
			if(!DSQ.isEqual(arr1, arr2))
			{
				System.out.println("sb");
				System.out.println("yuan: " + Arrays.toString(arr));
				System.out.println("error: " + Arrays.toString(arr1));
				break;
			}
//			System.out.println(Arrays.toString(arr1));
		}
		System.out.println("finish...");

	}
}
