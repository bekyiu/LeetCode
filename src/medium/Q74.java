package medium;

/*
 *  编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
	每行中的整数从左到右按升序排列。
	每行的第一个整数大于前一行的最后一个整数。
	思路: 利用有序特性 从右上角开始搜索 复杂度m + n
 */
public class Q74
{
	public static boolean searchMatrix(int[][] matrix, int target)
	{
		if (matrix == null || matrix.length == 0)
		{
			return false;
		}
		if (matrix.length == 1 && matrix[0].length == 1)
		{
			return target == matrix[0][0];
		}

		int x = 0;
		int y = matrix[0].length - 1;
		while (x < matrix.length && y >= 0)
		{
			System.out.format("x: %d, y:%d, matrix[][] = %d\n", x, y, matrix[x][y]);
			if (matrix[x][y] < target)
			{
				x++;
			} else if (matrix[x][y] > target)
			{
				y--;
			} else
			{
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		int[][] matrix =
		{
				{ 1, 3, 5, 7 },
				{ 10, 11, 16, 20 },
				{ 23, 30, 34, 50 } };
		System.out.println(Q74.searchMatrix(matrix, 13));
	}
}
