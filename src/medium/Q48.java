package medium;
/*
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 思路: (a,b), (c,d)唯一确定一个矩阵
 * 先旋转外层, 再旋转内层
 * 旋转方式:
 * 		譬如每一行有四个数
 * 		那么从第一个数开始找到在这一圈中需要相互交换的四个数进行交换
 * 		来到第二个数, 找到一圈中要交换的四个数进行交换
 * 		来到第三个数, 换
 * 		此时 一圈换完
 */
public class Q48
{
    public static void rotate(int[][] matrix) 
    {
    	if(matrix == null || matrix.length == 0 || (matrix.length == 1 && matrix[0].length == 1))
    	{
    		return;
    	}
        int a = 0, b = 0;
        int c = matrix.length - 1;
        int d = c;
        while(a <= c)
        {
        	rotateCircle(matrix, a++, b++, c--, d--);
        }
    }
    
    public static void rotateCircle(int[][] matrix, int a, int b, int c, int d)
    {
    	int count = d - b;
    	int i = 0;
    	while(i < count)
    	{
    		int temp = matrix[a][b + i];
    		matrix[a][b + i] = matrix[c - i][b];
    		matrix[c - i][b] = matrix[c][d - i];
    		matrix[c][d - i] = matrix[a + i][d];
    		matrix[a + i][d] = temp;
    		i++;
    	}
    }
	
	public static void main(String[] args)
	{
		
	}
}
