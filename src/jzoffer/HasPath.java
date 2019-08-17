package jzoffer;

public class HasPath
{
	// 判断有没有来到过这个位置
	private boolean[] v;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        v = new boolean[matrix.length];
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(isOk(matrix, rows, cols, i, j, str, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    // 当前在第i行第j列, 从str的第k个字符开始判断
    public boolean isOk(char[] matrix, int rows, int cols, 
                        int i, int j, char[] str, int k)
    {
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols
          || v[index] || matrix[index] != str[k])
        {
            return false;
        }
        // 标记为来到
        v[index] = true;
        // 说明找到了
        if(k == str.length-1)
        {
           return true; 
        }
        
        if(isOk(matrix, rows, cols, i + 1, j, str, k + 1)
                       || isOk(matrix, rows, cols, i - 1, j, str, k + 1)
                       || isOk(matrix, rows, cols, i, j + 1, str, k + 1)
                       || isOk(matrix, rows, cols, i, j - 1, str, k + 1))
        {
            return true;
        }
        // 说明从i, j这个位置出发找不到
        v[index] = false;
        return false;
    }
}
