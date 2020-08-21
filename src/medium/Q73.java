package medium;

public class Q73
{
	// 待优化
    public void setZeroes(int[][] matrix)
    {
        if(matrix == null)
        {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                temp[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (matrix[i][j] == 0)
                {
                    setZero(temp, i, j);
                }
                else
                {
                    if(temp[i][j] == -1)
                    {
                        temp[i][j] = matrix[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    public void setZero(int[][] matrix, int m, int n)
    {
        // 行置0
        for (int j = 0; j < matrix[0].length; j++)
        {
            matrix[m][j] = 0;
        }

        // 列置0
        for (int i = 0; i < matrix.length; i++)
        {
            matrix[i][n] = 0;
        }
    }
}
