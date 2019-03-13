package medium;

/*
 * 对角线遍历/ 之字打印
 * 准备两对指针a, b, 一开始都指向左上角
 * a的运动逻辑是:
 * 		每次向右移动, 如果达到边界, 就向下移动
 * b的运动逻辑是:
 * 		每次向下移动, 如果达到边界, 就向右移动
 * a, b的连线构成了一个对角线, 打印这个对角线即可
 */
public class Q498
{
	private static int index = 0;
	public static int[] findDiagonalOrder(int[][] matrix)
	{
		if(matrix == null || matrix.length == 0)
		{
			return new int[]{};
		}
		int len = matrix.length * matrix[0].length;
		int[] arr = new int[len];
		int a = 0, b = 0, c = 0, d = 0;
		boolean f = true;
		while (b < matrix[0].length && a < matrix.length)
		{
			addDiagonal(matrix, arr, a, b, c, d, f);
			
			a = b == matrix[0].length - 1 ? a + 1 : a;
			b = b == matrix[0].length - 1 ? b : b + 1;
			//注意先后顺序, 绝不能错, 因为用于判断的数值在赋值中会反生改变
			d = c == matrix.length - 1 ? d + 1 : d;
			c = c == matrix.length - 1 ? c : c + 1;
			f = !f;
		}
		return arr;
	}

	public static void addDiagonal(int[][] matrix, int[] arr, int a, int b, int c, int d, boolean f)
	{
		// 从下往上
		if (f)
		{
			while (c >= a)
			{
				arr[index++] = matrix[c--][d++];
			}
		} else // 从上往下
		{
			while (a <= c)
			{
				arr[index++] = matrix[a++][b--];
			}
		}
	}
	public static void main(String[] args)
	{
		int[][] arr =
		{
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 } };
		Q498.findDiagonalOrder(arr);
	}
}
