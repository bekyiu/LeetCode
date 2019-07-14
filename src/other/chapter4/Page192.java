package other.chapter4;

public class Page192
{
	public static void main(String[] args)
	{
		int z = walk(5, 3, 3, 2);
		System.out.println(z);
	}
	
	public static int walk(int N, int P, int K, int cur)
	{
		if(P == 0)
		{
			return cur == K ? 1 : 0;
		}
		if(cur == 1)
		{
			return walk(N, P - 1, K, cur + 1);
		}
		if(cur == N)
		{
			return walk(N, P - 1, K, cur - 1);
		}
		return walk(N, P - 1, K, cur + 1) + walk(N, P - 1, K, cur - 1);
	}

}
