package jzoffer;

public class VerifySquenceOfBST
{
	public static void main(String[] args)
	{
		VerifySquenceOfBST obj = new VerifySquenceOfBST();
		obj.verifySquenceOfBST(new int[] {1, 3, 2, 4, 5, 6});
	}
    public boolean verifySquenceOfBST(int[] sequence) 
    {
        if(sequence == null || sequence.length == 0)
        {
            return false;
        }
        if(sequence.length == 1)
        {
        	return true;
        }
        return p(sequence, 0, sequence.length - 1);
    }
    
    public boolean p(int[] seq, int start, int end)
    {
    	// 说明子树为空
        if(start >= end)
        {
            return true;
        }
        int head = seq[end];
        // 找到左右子树的分界点
        // 右子树的第一个值
        int right;
        for(right = start; right < end; right++)
        {
            if(seq[right] > head)
            {
                break;
            }
        }
        // 遍历右子树, 如果有一个数比head小, 就返回false
        for(int i = right; i < end; i++)
        {
            if(seq[i] < head)
            {
                return false;
            }
        }
        // 判断左右子树是不是bst
        return p(seq, start, right - 1) && p(seq, right, end - 1);

    }
}
