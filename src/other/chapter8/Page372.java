package other.chapter8;

public class Page372
{
	public void printHalfMajor(int[] arr)
	{
		int cand = 0;
		int times = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(times == 0)
			{
				cand = arr[i];
				times = 1;
			}
			else
			{
				if(cand == arr[i])
				{
					times++;
				}
				else
				{
					times--;
				}
			}
		}
		times = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(cand == arr[i])
			{
				times++;
			}
		}
		if(times > arr.length / 2)
		{
			System.out.println(cand);
		}
		else
		{
			System.out.println("no such number");
		}
	}
}
