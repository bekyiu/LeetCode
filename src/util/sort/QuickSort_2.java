package util.sort;

import java.util.Arrays;

import util.DSQ;

//经典快排 第二种解法
public class QuickSort_2
{

	public static void quickSort(int[] arr, int L, int R)
	{
		if(L >= R || arr.length <= 1)
		{
			return;
		}
		int shreshold = arr[(L + R) / 2];
		int i = L;
		int j = R;
		while(i <= j)
		{
			while(arr[i] < shreshold)
			{
				i++;
			}
			while(arr[j] > shreshold)
			{
				j--;
			}
			if(i < j)
			{
				DSQ.swap(arr, i++, j--);
			}
			else if(i == j)
			{
				i++;
			}
		}
		quickSort(arr, L, j);
		quickSort(arr, i, R);
		
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i < 10000; i++)
		{
			int[] arr = DSQ.generateRandomArray(50, 100);
			int[] arr1 = DSQ.copyArray(arr);
			int[] arr2 = DSQ.copyArray(arr);
			QuickSort_2.quickSort(arr1, 0, arr1.length - 1);
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
