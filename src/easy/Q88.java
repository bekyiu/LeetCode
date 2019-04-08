package easy;
//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
//考试是可以先直接合并到一个数组, 然后再排序
public class Q88
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int[] temp = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while(index1 < m && index2 < n)
        {
            if(nums1[index1] <= nums2[index2])
            {
                temp[index3++] = nums1[index1++];
            }
            else
            {
                temp[index3++] = nums2[index2++];
            }
        }
        while(index1 < m)
        {
            temp[index3++] = nums1[index1++];
        }
        while(index2 < n)
        {
            temp[index3++] = nums2[index2++];
        }
        
        for(int i = 0;i < nums1.length; i++)
        {
            nums1[i] = temp[i];
        }
    }
}
