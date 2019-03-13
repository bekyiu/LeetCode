package easy;
/*
 * 给定一个矩阵 A， 返回 A 的转置矩阵
 */
public class Q867
{
    public static int[][] transpose(int[][] A) 
    {
    	if(A == null)
    	{
    		return null;
    	}
    	if(A.length == 0)
    	{
    		return new int[][] {};
    	}
        int newRow = A[0].length;
        int newColum = A.length;
        int[][] AT = new int[newRow][newColum];
        for (int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A[0].length; j++)
			{
				AT[j][i] = A[i][j];
			}
		}
        return AT;
    }
    public static void main(String[] args)
	{
    	int[][] A = {{1,2,3,4}, {5,6,7,8}};
    	A = Q867.transpose(A);
        for (int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A[0].length; j++)
			{
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
	}
}
