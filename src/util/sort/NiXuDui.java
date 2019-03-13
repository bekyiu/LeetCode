package util.sort;
//一个数列，如果左边的数大，右边的数小，则称这两个数位一个逆序对。 
//求出一个数列中有多少个逆序对。
//实际上就是求每个数右边有多少个数比他小
/*
 * 		4 3 2 1
 * 	在3的右边有两个数比三小, 那么这一轮就会出现两个逆序数
 * 
 * 	3 4		1 2
 * 	p1		p2
 * arr[p1] > arr[p2]  那么[p1, mid]的数一定都是大于arr[p2]的
 */
public class NiXuDui
{
	public static int fun1(int[] arr)
	{
		int result = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if(arr[j] > arr[i])
				{
					result++;
					System.out.println(arr[j] + ", " + arr[i]);
				}
			}
		}
		return result;
	}
	
	public static int fun2(int[] arr)
	{
		return mergeSort(arr, 0, arr.length - 1);
	}
	
	private static int mergeSort(int[] arr, int l, int r)
	{
		if(l == r)
		{
			return 0;
		}
		int mid = (l + r) / 2;
		return mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
	}
	
	private static int merge(int[] arr, int l, int mid, int r)
	{
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		int result = 0;
		while(p1 <= mid && p2 <= r)
		{
			if(arr[p1] > arr[p2])
			{
				result += (mid - p1 + 1);
				help[i] = arr[p2];
				p2++;
			}
			else
			{
				help[i] = arr[p1++];
			}
			i++;
		}
		while(p1 <= mid)
		{
			help[i++] = arr[p1++];
		}
		while(p2 <= r)
		{
			help[i++] = arr[p2++];
		}
		for(i = 0; i < help.length; i++)
		{
			arr[l + i] = help[i];
		}
		return result;
	}
	public static void main(String[] args)
	{
		int[] arr = {-1, 3, 3, 5, 5, 41, 5435, -11, 3423, 4432, -4421, 34432};
		int z = NiXuDui.fun2(arr);
		System.out.println(z);
	}
}
