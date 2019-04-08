package easy;
//爬楼梯
/*
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	解法: 求斐波那契数列
	1 2 3 4 5 6 ... 层数
	1 2 3 5 8 13 ...不同方案的总数
 */
public class Q70
{
	//递归解法
    private int[] cache = new int[100];
    public int climbStairs(int n) 
    {
        if(n == 0 || n == 1)
        {
            return 1;
        }
        if(n == 2)
        {
            return 2;
        }
        if(cache[n - 1] == 0)
        {
            cache[n - 1] = climbStairs(n - 1);
        }
        if(cache[n - 2] == 0)
        {
            cache[n - 2] = climbStairs(n - 2); 
        }
        return cache[n - 1] + cache[n - 2];
    }
    
    //迭代解法
     public int climbStairs2(int n) 
     {
         if(n == 0 || n == 1)
         {
             return 1;
         }
         else if(n == 2)
         {
             return 2;
         }
         else
         {
             int k = 3;
             int num1 = 1;
             int num2 = 2;
             int sum = 0;
             while(k <= n)
             {
                 sum = num1 + num2;
                 int temp = num2;
                 num2 = sum;
                 num1 = temp;
                 k++;
             }
             return sum;
         }
     }
}
