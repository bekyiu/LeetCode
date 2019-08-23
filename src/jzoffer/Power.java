package jzoffer;

public class Power
{
	// 注意处理特殊情况即可
	public double power(double base, int exponent)
	{
		if (exponent == 0.0)
		{
			return 1.0;
		}
		if (base == 0.0)
		{
			return 0.0;
		}
		if (exponent > 0)
		{
			return zheng(base, exponent);
		} else
		{
			return 1 / zheng(base, -exponent);
		}
	}

	// 只考虑指数是正数的情况
	public double zheng(double base, int exponent)
	{
		double res = 1;
		while (exponent-- > 0)
		{
			res *= base;
		}
		return res;
	}
}
