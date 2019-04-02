package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

//最大值减去最小值小于或等于num的子数组的数量
public class Page31
{
	public static void main(String[] args)
	{
		int[] arr =
		{ 6, 1, 4 };
		System.out.println(getNum(arr, 3));
	}

	public static int getNum(int[] arr, int num)
	{
		Deque<Integer> qmax = new ArrayDeque<>();
		Deque<Integer> qmin = new ArrayDeque<>();
		int i = 0; // arr[i..j]
		int j = 0;
		int res = 0;
		while (i < arr.length)
		{
			while (j < arr.length)
			{

				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j])
				{
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j])
				{
					qmax.pollLast();
				}
				qmax.addLast(j);

				if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num)
				{
					break;
				}
				j++;
			}
			res += (j - i);
			// 窗口左边界向右走一个位置
			i++;
			// 处理过期
			if (qmax.peekFirst() == i - 1)
			{
				qmax.pollFirst();
			}
			if (qmin.peekFirst() == i - 1)
			{
				qmin.pollFirst();
			}
		}
		return res;
	}
}
