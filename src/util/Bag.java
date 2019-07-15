package util;
//给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi。
//问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
public class Bag
{
	public static int[] w = {0, 2, 3, 4, 9, 5};
	public static int[] v = {0, 3, 4, 5, 10, 8};
//	public static int[] w = {4, 6, 2, 2, 5, 1};
//	public static int[] v = {8, 10, 6, 3, 7, 2};
	public static int n = w.length;
	public static void main(String[] args)
	{
		int c = 20;
//		int c = 12;
		// 在[0, k]的范围内, 求的的最大的背包价值一定是下面两种情况中大的一种
		// 第k个不装, 用更大的背包去装前k-1个
		// 装第k个, 装前k-1个的背包变小, 但是总价值加上vk
		System.out.println(fun(n - 1, c));
	}
	// 在[0, k]范围内, 用restw大小的背包去装商品, 能装的最大价值
	public static int fun(int k, int restw)
	{
		// 想要价值最大, 倒推到第0个商品如果背包还有空间的话, 一定是要装的
		if(k == 0)
		{
			return restw >= w[k] ? v[k] : 0;
		}
		// 想要装第k个, 但是装不下了
		if(w[k] > restw)
		{
			return fun(k - 1, restw);
		}
		// 可以装第k个, 那么分为第k个装还是不装的情况, 取最大值
		return Math.max(fun(k - 1, restw), fun(k - 1, restw - w[k]) + v[k]);
	}
}
