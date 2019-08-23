package jzoffer;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrix
{
	public static void main(String[] args)
	{
		PrintMatrix p = new PrintMatrix();
		int[][] matrix = new int[][] {{1}, {2}, {3}, {4}, {5}};
		List<Integer> list = p.printMatrix(matrix);
		System.out.println(list);
	}
	public ArrayList<Integer> printMatrix(int[][] matrix)
	{
		if (matrix == null || matrix.length == 0)
		{
			return null;
		}
		int lefti = 0, leftj = 0;
		int rightj = matrix[0].length - 1, righti = matrix.length - 1;
		ArrayList<Integer> list = new ArrayList<>();
		// 这个判断条件一定要写全
		while (lefti <= righti && leftj <= rightj)
		{
//			System.out.println("lefti: " + lefti);
//			System.out.println("leftj: " + leftj);
//			System.out.println("righti: " + righti);
//			System.out.println("rightj: " + rightj);
//			System.out.println();
			printCircle(list, lefti++, leftj++, righti--, rightj--, matrix);
		}
		return list;
	}

	public void printCircle(ArrayList<Integer> list, int lefti, int leftj, int righti, int rightj, int[][] matrix)
    {   
        int i = lefti;
        int j = leftj;
        int m = righti;
        int n = rightj;
        // 只有一行
        if(lefti == righti)
        {
            while(j <= rightj)
            {
                list.add(matrix[lefti][j++]);
            }
        }
        else if(leftj == rightj) // 只有一列
        {
            while(i <= righti)
            {
                list.add(matrix[i++][leftj]);
            }
        }
        else
        {
            while(j < rightj)
            {
                list.add(matrix[lefti][j++]);
            }
            while(i < righti)
            {
                list.add(matrix[i++][rightj]);
            }
            while(n > leftj)
            {
                list.add(matrix[righti][n--]);
            }
            while(m > lefti)
            {
                list.add(matrix[m--][leftj]);
            }
        }
    }
}
