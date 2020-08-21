package medium;

public class Q55
{
    // [2,3,1,1,4] true
    public boolean canJump(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        return dpMethod(nums);
//        return jump(nums, 0);
    }

    public boolean dpMethod(int[] nums)
    {
        // i位置能否跳到nums的末尾, dp[i]
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        int falseNum = 0;
        for (int i = nums.length - 2; i >= 0; i--)
        {
            if(dp[i + 1])
            {
                falseNum = 0;
                if(nums[i] <= 0)
                {
                    falseNum++;
                }
                dp[i] = nums[i] > 0;
            }
            else
            {
                if(nums[i] <= falseNum)
                {
                    falseNum++;
                }
                dp[i] = nums[i] > falseNum;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    
    // 当前在index位置 是否能跳到尾部
    public boolean jump(int[] nums, int index)
    {
        if (index == nums.length - 1)
        {
            return true;
        }
        //
        for (int i = 1; i <= nums[index]; i++)
        {
            if (jump(nums, index + i))
            {
                return true;
            }
        }
        return false;
    }
}
