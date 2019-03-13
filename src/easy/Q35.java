package easy;

public class Q35
{
    public static int searchInsert(int[] nums, int target) 
    {
    	int low = 0;
    	int high = nums.length - 1;
    	while(low <= high)
    	{
    		int mid = (low + high) / 2;
    		if(target < nums[mid])
    		{
    			high = mid - 1;
    		}
    		else if(target > nums[mid])
    		{
    			low = mid + 1;
    		}
    		else
    		{
    			return mid;
    		}
    	}
    	return low;
    }
    public static int binarySearch(int[] nums, int target)
    {
    	int low = 0;
    	int high = nums.length - 1;
    	while(low <= high)
    	{
    		int mid = (low + high) / 2;
    		if(target < nums[mid])
    		{
    			high = mid - 1;
    		}
    		else if(target > nums[mid])
    		{
    			low = mid + 1;
    		}
    		else
    		{
    			return mid;
    		}
    	}
    	return -1;
    }
	public static void main(String[] args)
	{
		System.out.println(Q35.searchInsert(new int[] {1, 3, 7, 10, 15, 21},  11));
	}
}
