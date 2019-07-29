package other.chapter4;

import java.util.Arrays;

import lombok.ToString;

public class Page215
{
	@ToString
	class Envelope implements Comparable<Envelope>
	{
		public int len;
		public int wid;
		public Envelope(int len, int wid)
		{
			this.len = len;
			this.wid = wid;
		}
		@Override
		public int compareTo(Envelope o)
		{
			return this.len != o.len ? this.len - o.len : o.wid - this.wid;
		}
	}
	
	public Envelope[] getSorted(int[][] arr)
	{
		Envelope[] res = new Envelope[arr.length];
		for(int i = 0; i < arr.length; i++)
		{
			res[i] = new Envelope(arr[i][0], arr[i][1]);
		}
		Arrays.sort(res);
		return res;
	}
	
    public int maxEnvelopes(int[][] envelopes) 
    {
    	Envelope[] es = getSorted(envelopes);
    	int[] ends = new int[envelopes.length];
    	ends[0] = es[0].wid;
    	
    	int right = 0;
    	int l = 0;
    	int m = 0;
    	int r = 0;
    	for(int i = 1; i < es.length; i++)
    	{
    		l = 0;
    		r = right;
        	while(l <= r)
        	{
        		m = (l + r) / 2;
        		if(es[i].wid > ends[m])
        		{
        			l = m + 1;
        		}
        		else
        		{
        			r = m - 1;
        		}
        	}
        	right = Math.max(right, l);
        	ends[l] = es[i].wid;
    	}
    	return right + 1;

    }
    
	public static void main(String[] args)
	{
		int[][] arr = new int[][] {{3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}};
		Page215 obj = new Page215();
		System.out.println(obj.maxEnvelopes(arr));
	}
}
