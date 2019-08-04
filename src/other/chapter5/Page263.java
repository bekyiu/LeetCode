package other.chapter5;

public class Page263
{
	public static void main(String[] args)
	{
		
	}
	
	public int getIndex(String[] strs, String str)
	{
		int res = -1;
		int left = 0;
		int right = strs.length - 1;
		int mid = 0;
		int i = 0;
		while(left <= right)
		{
			mid = (left + right) / 2;
			if(strs[mid] != null && strs[mid].equals(str))
			{
				res = mid;
				// 要看更左边还有没有
				right = mid - 1;
			}
			else if(strs[mid] != null)
			{
				if(strs[mid].compareTo(str) < 0)
				{
					left = mid + 1;
				}
				else
				{
					right = mid - 1;
				}
			}
			else // strs[mid] == null
			{
				i = mid;
				// 从mid开始往左找, 找到第一个不为空的位置
				while(strs[i] == null && --i >= left);
				// i < left 说明上面没找到, 从mid开始往左全是null
				if(i < left || strs[i].compareTo(str) < 0)
				{
					left = mid + 1;
				}
				else
				{
					res = strs[i].equals(str) ? i : res;
					right = i - 1;
				}
			}
		}
		return res;
	}
}
