package other.chapter5;

public class Page258
{
	public static void main(String[] args)
	{
		System.out.println(Page258.getCountString("aaabbfssa"));
	}
	public static String getCountString(String str)
	{
		char[] chs = str.toCharArray();
		String res = chs[0] + "";
		int num = 1;
		for(int i = 1; i < chs.length; i++)
		{
			if(chs[i] == chs[i - 1])
			{
				num++;
			}
			else
			{
				res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
				num = 1;
			}
		}
		return concat(res, String.valueOf(num), "");
	}
	
	public static String concat(String s1, String num, String s3)
	{
		return s1 + "_" + num + (s3.equals("") ? "" : "_") + s3;
	}
}
