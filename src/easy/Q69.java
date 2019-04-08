package easy;
/*
 * 计算并返回 x 的平方根，其中 x 是非负整数。
      由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
      输入 8 返回2
      思路: 二分
 */
public class Q69
{
	public int mySqrt(int x)
	{
		long low = 1;
		long high = x;
		while (low <= high)
		{
			long mid = (low + high) / 2;
			//平方根是小数的情况, 比如8的平方根是2.8
			if (mid * mid < x && (mid + 1) * (mid + 1) > x)
			{
				return (int) mid;
			}
			if (mid * mid == x)
			{
				return (int) mid;
			}
			//如果能执行下面这个 if, mid + 1的平方是肯定小于x的
			//即答案在mid右边的区域
			if (mid * mid < x)
			{
				low = mid + 1;
				continue;
			}
			high = mid - 1;
		}
		//不可能执行到这里 除非出错
		return 0;
	}
}
