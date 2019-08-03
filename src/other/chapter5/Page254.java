package other.chapter5;

// Q769
public class Page254
{
	public boolean rotateString(String a, String b)
	{
		if (a.length() != b.length())
		{
			return false;
		}
		String c = b + b;
		return c.indexOf(a) != -1 ? true : false;
	}
}
