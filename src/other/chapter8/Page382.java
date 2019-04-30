package other.chapter8;

public class Page382
{
	private int len = 0;

	// O n^3
	public int getMaxLength(int[] arr, int k)
	{
		if (arr == null || arr.length == 0 || k <= 0)
		{
			return 0;
		}
		for (int left = 0; left < arr.length; left++)
		{
			for (int right = left; right < arr.length; right++)
			{
				// 遍历所有子数组
				allSubArr(arr, left, right, k);
			}
		}
		return len;
	}

	private void allSubArr(int[] arr, int left, int right, int k)
	{
		int sum = 0;
		for (int i = left; i <= right; i++)
		{
			sum += arr[i];
		}
		if (sum == k)
		{
			len = Math.max(right - left + 1, len);
		}
	}

	// O n
	public int getMaxLength2(int[] arr, int k)
	{
		if (arr == null || arr.length == 0 || k <= 0)
		{
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[0];
		while(right < arr.length)
		{
			if(sum == k)
			{
				len = Math.max(right - left + 1, len);
				sum -= arr[left++];
			}
			else if(sum < k)
			{
				right++;
				if(right == arr.length)
				{
					break;
				}
				sum += arr[right];
			}
			else
			{
				sum -= arr[left++];
			}
		}
		return len;
	}

	public static void main(String[] args)
	{
		int len = new Page382().getMaxLength2(new int[]
		{ 1, 2, 1, 1, 1, 1, 2 }, 4);
		System.out.println(len);
	}
}
