package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 思路: 不要想具体的每个下标要怎么变换
 * 给定一个左上角的点(a, b) 和 一个右下角的点 (c, d)是可以唯一确定一个矩阵的
 * 并且这个确定的矩阵很好打印, 所以
 * 可以先打印最外层的一圈, 然后打印内层的一圈...
 */
public class Q54
{
//	public void spiralOrder(int[][] matrix)
//	{
//		int a = 0, b = 0;
//		int c = matrix.length - 1, d = matrix[0].length - 1;
//		while (a <= c && b <= d)
//		{
//			printCircle(matrix, a++, b++, c--, d--);
//		}
//	}
//
//	public void printCircle(int[][] matrix, int a, int b, int c, int d)
//	{
//		int horizontalCount = d - b;
//		int verticalCount = c - a;
//		if (a == c && b == d)
//		{
//			System.out.println(matrix[a][b]);
//		} 
//		else if (a == c)
//		{
//			for (int i = 0; i < horizontalCount + 1; i++)
//			{
//				System.out.println(matrix[a][b + i]);
//			}
//		} 
//		else if (b == d)
//		{
//			for (int i = 0; i < verticalCount + 1; i++)
//			{
//				System.out.println(matrix[a + i][d]);
//			}
//		} 
//		else
//		{
//			for (int i = 0; i < horizontalCount; i++)
//			{
//				System.out.println(matrix[a][b + i]);
//			}
//			for (int i = 0; i < verticalCount; i++)
//			{
//				System.out.println(matrix[a + i][d]);
//			}
//			for (int i = 0; i < horizontalCount; i++)
//			{
//				System.out.println(matrix[c][d - i]);
//			}
//			for (int i = 0; i < verticalCount; i++)
//			{
//				System.out.println(matrix[c - i][b]);
//			}
//		}
//
//	}
	public List<Integer> spiralOrder(int[][] matrix) 
    {
        if(matrix == null)
        {
            return null;
        }
        if(matrix.length == 0)
        {
            return new ArrayList<>(0);
        }
        
        int a = 0, b = 0;
		int c = matrix.length - 1, d = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        if(c == 0 && d == 0)
        {
            list.add(matrix[0][0]);
            return list;
        }
        while (a <= c && b <= d)
		{
			printCircle(list, matrix, a++, b++, c--, d--);
		}
        return list;
        
    }
    
    
    
    public void printCircle(List<Integer> list, int[][] matrix, int a, int b, int c, int d)
	{
		int horizontalCount = d - b;
		int verticalCount = c - a;
		if (a == c && b == d)
		{
			list.add(matrix[a][b]);
		} 
		else if (a == c)
		{
			for (int i = 0; i < horizontalCount + 1; i++)
			{
				list.add(matrix[a][b + i]);
			}
		} 
		else if (b == d)
		{
			for (int i = 0; i < verticalCount + 1; i++)
			{
				list.add(matrix[a + i][d]);
			}
		} 
		else
		{
			for (int i = 0; i < horizontalCount; i++)
			{
				list.add(matrix[a][b + i]);
			}
			for (int i = 0; i < verticalCount; i++)
			{
				list.add(matrix[a + i][d]);
			}
			for (int i = 0; i < horizontalCount; i++)
			{
				list.add(matrix[c][d - i]);
			}
			for (int i = 0; i < verticalCount; i++)
			{
				list.add(matrix[c - i][b]);
			}
		}
    }
	public static void main(String[] args)
	{
		Q54 q = new Q54();
		int[][] matrix = {
				{1, 2, 3 , 4},
				{5, 6, 7 , 8},
				{9, 10, 11, 12}
		};
		
		List<Integer> list = q.spiralOrder(matrix);
		System.out.println(list);
	}
}
