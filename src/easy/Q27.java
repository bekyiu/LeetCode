package easy;

public class Q27
{
    public int removeElement(int[] nums, int val) 
    {
    	int result = -1;
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(nums[i] == val)
    		{
    			continue;
    		}
    		else
    		{
    			result++;
    			nums[result] = nums[i];
    		}
    	}
    	return result + 1;
    }

    
    public static void main(String[] args)
	{
    	int[] nums = {0,1,2,2,3,0,4,2};
    	System.out.println("------");
		int len = new Q27().removeElement(nums, 2);
		for(int i = 0; i < len; i++)
		{
			System.out.print(nums[i]);
		}
	}
}
