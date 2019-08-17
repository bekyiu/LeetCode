package jzoffer;

/*
 * 	链接：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba?f=discussion
	来源：牛客网

	(1)array[mid] > array[high]:
	出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
	low = mid + 1
	(2)array[mid] == array[high]:
	出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
	还是右边,这时只好一个一个试 ，
	high = high - 1
	(3)array[mid] < array[high]:
	出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
	边。因为右边必然都是递增的。
	high = mid
 */
public class MinNumberInRotateArray
{
	public int minNumberInRotateArray(int[] array)
	{
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		while (low <= high)
		{
			mid = (low + high) / 2;
			if (array[mid] == array[high])
			{
				high--;
			} else if (array[mid] > array[high])
			{
				low = mid + 1;
			} else
			{
				high = mid;
			}
		}
		return array[low];
	}
}
