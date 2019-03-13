package medium;


/*
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 * 思路:
 * 先添加最外一圈, 再添加较内一圈...
 */
public class Q59
{
	private int num = 1;
    public int[][] generateMatrix(int n) 
    {
    	if(n <= 0)
    	{
    		return new int[][] {};
    	}
    	int a = 0, b = 0;
    	int c = n - 1, d = n - 1;
        int[][] matrix = new int[n][n];
        while(num <= n * n)
        {
        	addCircle(matrix, a++, b++, c--, d--);
        }
        return matrix;
    }

    public void addCircle(int[][] matrix, int a, int b, int c, int d)
    {
		int horizontalCount = d - b;
		int verticalCount = c - a;
		if (a == c && b == d)
		{
			matrix[a][b] = num++;
		}
		else
		{
			for (int i = 0; i < horizontalCount; i++)
			{
				matrix[a][b + i] = num++;
			}
			for (int i = 0; i < verticalCount; i++)
			{
				matrix[a + i][d] = num++;
			}
			for (int i = 0; i < horizontalCount; i++)
			{
				matrix[c][d - i] = num++;
			}
			for (int i = 0; i < verticalCount; i++)
			{
				matrix[c - i][b] = num++;
			}
		}
    }
    
    public static void main(String[] args)
	{
		Q59 q = new Q59();
		int n = 1;
		int[][] arr = q.generateMatrix(n);
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(arr[i][j] + ",    ");
			}
			System.out.println();
		}
	}
}
