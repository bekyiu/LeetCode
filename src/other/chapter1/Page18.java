package other.chapter1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//生成窗口最大值数组
public class Page18
{
	public static void main(String[] args)
	{
		int[] arr = getMaxWindow(new int[]
		{ 4, 3, 5, 4, 3, 3, 6, 7 }, 3);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] getMaxWindow(int[] arr, int w)
	{
		Deque<Integer> qmax = new LinkedList<>();
		int[] result = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++)
		{
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i])
			{
				qmax.pollLast();
			}
			if (qmax.isEmpty() || arr[qmax.peekLast()] > arr[i])
			{
				qmax.addLast(i);
				// con
			}
			if (qmax.peekFirst() == i - w)
			{
				qmax.pollFirst();
			}
			if (i >= w - 1)
			{
				result[index++] = arr[qmax.peekFirst()];
			}

		}
		return result;
	}
}
