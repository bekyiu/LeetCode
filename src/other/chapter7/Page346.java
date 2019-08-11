package other.chapter7;

public class Page346
{
	public static void main(String[] args)
	{
		int a = 614, b = 0;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a);
		System.out.println(b);
	}
}
