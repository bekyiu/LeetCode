package medium;
/*
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 * 思路:
 * 		遍历二维数组, 当当前值为1的时候, 调用一个感染函数, 把这个1以及他周围的1全部改成2
 * 		然后岛屿数量加一
 */
public class Q200
{
	//注意是char数组 不是int
    public int numIslands(char[][] grid) 
    {
    	if(grid.length == 0)
    	{
    		return 0;
    	}
    	int count = 0;
    	int row = grid.length;
    	int col = grid[0].length;
    	for(int i = 0; i < row; i++)
    	{
    		for(int j = 0; j < col; j++)
    		{
    			if(grid[i][j] == '1')
    			{
    				infect(i, j , grid, row, col);
    				count++;
    			}
    		}
    	}
    	return count;
    }
    
    public void infect(int i, int j, char[][] grid, int row, int col)
    {
    	if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1')
    	{
    		return;
    	}
    	grid[i][j] = '2';
    	infect(i + 1, j, grid, row, col);
    	infect(i - 1, j, grid, row, col);
    	infect(i, j + 1, grid, row, col);
    	infect(i, j - 1, grid, row, col);
    }
    public static void main(String[] args)
	{
		
	}
}
