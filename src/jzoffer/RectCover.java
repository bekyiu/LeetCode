package jzoffer;

/*
 * 用一个矩形竖着填最左边, 还剩target - 1列要填
 * 用两个矩形横着填最左边, 还剩target - 2列要填
 */
public class RectCover
{
    public int rectCover(int target) 
    {
        if(target <= 2)
        {
            return target;
        }
        return rectCover(target - 1) + rectCover(target - 2);
    }
}
