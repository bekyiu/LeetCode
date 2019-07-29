package other.chapter4;

public class Page218
{
	// 把n个盘子从from借助mid移动到to
	public static void p(int n, String from, String mid, String to)
	{
		if(n == 1)
		{
			System.out.println(from + " -> " + to);
		}
		else
		{
			p(n - 1, from, to, mid);
			p(1, from, mid, to);
			p(n - 1, mid, from, to);
		}
	}
	
	public static void h(int n)
	{
		if(n > 0)
		{
			p(n, "left", "mid", "right");
		}
	}
	
	public static void main(String[] args)
	{
		h(3);
	}
}
