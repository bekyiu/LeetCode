package other.chapter1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * 单调栈题目
 * 求出一个数组中当前位置左边那个离他最近且比他小的那个数的位置 和
 * 右边那个离他最近且比他小的那个数的位置
 * O(N)
 */
public class Page21
{
	public static void main(String[] args)
	{
		int[] arr = { 3, 1, 3, 4, 3, 5, 3, 2, 2};
		int[][] res = getNearLess(arr);
//		int[] arr = { 3, 4, 1, 5, 6, 2, 7 };
//		int[][] res = getNearLessNoRepeat(arr);
		for (int i = 0; i < res.length; i++)
		{
			System.out.println("{" + res[i][0] + ", " + res[i][1] + "}");

		}
	}

	// 这里给的arr是没有重复元素的
	public static int[][] getNearLessNoRepeat(int[] arr)
	{
		Deque<Integer> stack = new ArrayDeque<>();
		int[][] ans = new int[arr.length][2];
		for (int i = 0; i < arr.length; i++)
		{
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
			{
				Integer num = stack.pop();
				ans[num][0] = stack.peek() == null ? -1 : stack.peek();
				ans[num][1] = i;
			}
			if (stack.isEmpty() || arr[stack.peek()] < arr[i])
			{
				stack.push(i);
			}
		}
		while (!stack.isEmpty())
		{
			Integer num = stack.pop();
			ans[num][0] = stack.peek() == null ? -1 : stack.peek();
			ans[num][1] = -1;
		}
		return ans;
	}
	
	//进阶, 这里的arr中可以有重复元素
	public static int[][] getNearLess(int[] arr)
	{
		Deque<List<Integer>> stack = new ArrayDeque<>();
		int[][] ans = new int[arr.length][2];
		for(int i = 0; i < arr.length; i++)
		{
			while(!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i])
			{
				List<Integer> popIndexs = stack.pop();
				//选最新的那一个
				Integer leftIndex = stack.isEmpty() ? - 1 : stack.peek().get(stack.peek().size() - 1);
				for (Integer index : popIndexs)
				{
					ans[index][0] = leftIndex;
					ans[index][1] = i;
				}
			}
			if(!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i])
			{
				stack.peek().add(i);
			}
			else
			{
				List<Integer> indexs = new ArrayList<>();
				indexs.add(i);
				stack.push(indexs);
			}
		}
		while(!stack.isEmpty())
		{
			List<Integer> popIndexs = stack.pop();
			Integer leftIndex = stack.isEmpty() ? - 1 : stack.peek().get(stack.peek().size() - 1);
			for (Integer index : popIndexs)
			{
				ans[index][0] = leftIndex;
				ans[index][1] = -1;
			}
		}
		return ans;
	}
}
