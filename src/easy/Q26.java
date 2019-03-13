package easy;

public class Q26
{
    public int removeDuplicates(int[] nums) 
    {
    	int result = 0;
    	for(int i = 1; i < nums.length; i++)
    	{
    		if(nums[result] == nums[i])
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
		int[] arr = {1, 3, 4, 5, 0};
		int len = new Q26().removeDuplicates(arr);
		for(int i = 0; i < len; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}
}
