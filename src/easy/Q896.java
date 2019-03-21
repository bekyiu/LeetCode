package easy;
/*
 *  如果数组是单调递增或单调递减的，那么它是单调的。
	如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
	当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */
public class Q896
{
    public boolean isMonotonic(int[] A) 
    {
        if (A.length < 2)
        {
            return true;
        }

        if (A[0] < A[A.length - 1])
        {
            for (int i = 1; i < A.length; i++)
            {
                if (A[i - 1] > A[i])
                {
                    return false;
                }
            }
        } else
        {
            for (int i = 1; i < A.length; i++)
            {
                if (A[i - 1] < A[i])
                {
                    return false;
                }
            }
        }

        return true;

    }
}
