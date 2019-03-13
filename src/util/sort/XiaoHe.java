package util.sort;

public class XiaoHe
{
	//n^2
	public static int fun1(int arr[])
	{
		int result = 0;
		for(int i = 0; i < arr.length; i++)
		{
			int sum = 0;
			for(int j = 0; j < i; j++)
			{
				if(arr[j] < arr[i])
				{
					sum += arr[j];
				}
			}
			result += sum;
		}
		return result;
	}
/*	
 * 	求一个数组的小和，可以转化为求每个元素在小和累加过程出现的次数，
 * 	然后将当前元素与出现次数相乘，累加得到小和
	arr:		1 3 4 2 5
		原始求法			转换求法
	1:	0				4 * 1
	3:	1				2 * 3
	4:	1 + 3			1 * 4
	2:	1				2 * 1
	5:	1 + 3 + 4 + 2	0
	假设当前元素为a，a右边比a大的元素个数则为a在小和累加过程出现的次数
*/
	public static int fun2(int arr[])
	{
		return mSort(arr, 0, arr.length - 1);
	}
	
	public static int mSort(int[] arr, int l, int r)
	{
		if(l == r)
		{
			return 0;
		}
		int mid = (l + r) / 2; 
		return mSort(arr, l, mid) + mSort(arr, mid + 1, r) + merge(arr, l, mid, r);
	}
	
	private static int merge(int[] arr, int l, int mid, int r)
	{
		int[] help = new int[r - l + 1];
		int p1 = l;
		int p2 = mid + 1;
		int i = 0;
		//小和
		int result = 0;
		while(p1 <= mid && p2 <= r)
		{
			if(arr[p1] < arr[p2])
			{
				//如果arr[p1]比较小 那么包括arr[p2]以及arr[p2]右边的数都要比arr[p1]大
				//因为左半边和右半边分别都是排好序的
				//r - p2 + 1算的就是从p2开始到最右边一共有多少个数
				result += (r - p2 + 1) * arr[p1];
				help[i] = arr[p1++];
			}
			else
			{
				help[i] = arr[p2++];
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
		int[] arr = {1, 3, 4, 2, 5};
		System.out.println(fun2(arr));
	}
}
