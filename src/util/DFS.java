package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//4个数放三个盒子 几种方法
public class DFS
{
	static int[] box = new int[3];
	static int[] v = new int[] {0, 0, 0, 0, 0};
	
	static int ans = 0;
	
	static void dfs(int step)
	{
		if(step == 3)
		{
			ans++;
			return;
		}
		for (int i = 1; i <= 4; i++)
		{
			if (v[i] == 0)
			{
				v[i] = 1;
				box[step] = i;
				dfs(step + 1);
				v[i] = 0;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception
	{
//		dfs(0);
//		System.out.println(ans);
		String s = "2019-1-23";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(s);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		//年
		System.out.println(c.get(Calendar.YEAR));
		//月 从零开始
		System.out.println(c.get(Calendar.MONTH));
		//日
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		//这一年的第几周
		System.out.println(c.get(Calendar.WEEK_OF_YEAR));
		//周几 从零开始
		System.out.println(c.get(Calendar.DAY_OF_WEEK));
		System.out.println(c.get(Calendar.YEAR));
	}
}
