package easy;

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
