package other.chapter3;

// 此题先序列化, 再kmp
public class Page144
{
	class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x)
		{
			val = x;
		}
	}
	
	public boolean isSubtree(TreeNode t1, TreeNode t2)
	{
		String s1 = serialByPre(t1);
		String s2 = serialByPre(t2);
		return kmp(s1, s2) == -1 ? false : true;
	}
	public String serialByPre(TreeNode head)
	{
		String str = "";
		if(head == null)
		{
			return "#!";
		}
		str += head.val + "!";
		str += serialByPre(head.left);
		str += serialByPre(head.right);
		return str;
	}

	public static int kmp(String a, String b)
	{
		if(a.length() < b.length())
		{
			return -1;
		}
		char[] s = a.toCharArray();
		char[] m = b.toCharArray();
		int[] next = getNext(b);
		int i = 0, j = 0;
		while(i < s.length && j < m.length)
		{
			if(j == -1 || s[i] == m[j])
			{
				i++;
				j++;
			}
			else
			{
				j = next[j];
			}
		}
		return j == m.length ? i - j : -1;
	}
	
	public static int[] getNext(String b)
	{
		if(b.length() == 1)
		{
			return new int[] {-1};
		}
		char[] m = b.toCharArray();
		int[] next = new int[m.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		// next[1], 第一次就能跳到0位置
		int cn = 0;
		while(pos < next.length)
		{
			if(m[cn] == m[pos - 1])
			{
				next[pos] = ++cn;
				pos++;
			}
			else
			{
				if(cn > 0)
				{
					cn = next[cn];
				}
				else
				{
					// cn跳到0了 还厚pos-1配不上
					next[pos++] = 0;
				}
			}
		}
		return next;
	}
}
