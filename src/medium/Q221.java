package medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积
 * 单调栈解法 和Page26.java类似
 */
public class Q221
{
	public int maximalSquare(char[][] matrix) 
    {
        
        if (matrix.length < 1) return 0;
        int maxArea = 0;
		int[] height = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
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
				//选小的一个作为边
                int min = (i - k - 1) > height[j] ? height[j] : (i - k - 1);
                maxArea = Math.max(min * min, maxArea);
			}
			stack.push(i);
		}

		while (!stack.isEmpty())
		{
			Integer j = stack.pop();
			Integer k = stack.isEmpty() ? -1 : stack.peek();
            int min = (height.length - k - 1) > height[j] ? height[j] : (height.length - k - 1);
            maxArea = Math.max(min * min, maxArea);
		}
		return maxArea;
	}
}
