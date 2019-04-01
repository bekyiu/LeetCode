package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

//求最大子矩阵的大小
public class Page26
{
	public static void main(String[] args)
	{
		int[][] map =
		{
				{ 1, 0, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 0 } };
		System.out.println(new Page26().maxRecSize(map));
	}

	public int maxRecSize(int[][] map)
	{
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++)
		{
			for (int j = 0; j < map[0].length; j++)
			{
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	public int maxRecFromBottom(int[] height)
	{
		int maxArea = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < height.length; i++)
		{
			while (!stack.isEmpty() && height[stack.peek()] >= height[i])
			{
				Integer j = stack.pop();
				Integer k = stack.isEmpty() ? -1 : stack.peek();
				maxArea = Math.max((i - k - 1) * height[j], maxArea);
			}
			stack.push(i);
		}

		while (!stack.isEmpty())
		{
			Integer j = stack.pop();
			Integer k = stack.isEmpty() ? -1 : stack.peek();
			maxArea = Math.max((height.length - k - 1) * height[j], maxArea);
		}
		return maxArea;
	}

}
