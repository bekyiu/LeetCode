package other.chapter3;

import java.util.Arrays;
/*
 *  与书上解法不同
 *  思路:
	pre[根, 左, 右]
	in[左, 根, 右]
	pos[左, 右, 根]
	限定一个子树的范围之后, 譬如现在的[0, len - 1]
	那么pre一定是当前这个子树的根, 然后把这个值填在pos的最后一个位置
	再根据根pre的根从in中找出左子树和右子树的范围, 再在pre中找出左子树和右子树的范围
	再让pos的index指向下一个范围中根的位置, 递归
 */
public class Page172
{
//	public int[] pre = {1, 2, 4, 5, 3, 6, 7};
//	public int[] in = {4, 2, 5, 1, 6, 3, 7};
//	public int[] pos = new int[pre.length];
	public int[] pre = {1, 2, 4, 5, 3, 6, 7};
	public int[] in = {4, 5, 2, 1, 7, 6, 3};
	public int[] pos = new int[pre.length];
	
	public void getPosArray()
	{
		// 将pre in分组, pos永远只填根位置, 所以index位置是在当前的startx和endx范围中的根
		p(0, pre.length - 1, 0, in.length - 1, pos.length - 1);
		System.out.println(Arrays.toString(pos));
	}
	public static void main(String[] args)
	{
		new Page172().getPosArray();
	}
	public void p(int startp, int endp, int starti, int endi, int index)
	{
//		if(startp < 0 || endp > pre.length - 1 || starti < 0 || endi > in.length - 1)
//		{
//			return;
//		}
		if(startp > endp || starti > endi || index < 0)
		{
			return;
		}
		// 先序数组的第一个值一定是根
		pos[index] = pre[startp];
		// 分 in数组, in的左半边是左子树, 右半边是右子树, 中间是根, 找出根的索引
		int inflag = starti;
		for(; inflag <= endi; inflag++)
		{
			if(in[inflag] == pre[startp])
				break;
		}
		// in 左子树的数量
		int inLeftNum = inflag - starti;
		// in 右子树的数量
		int inRightNum = endi - inflag;
		// 根据in左右子树的数量 推出, pre数组左子树和右子树的范围
		// 这一句是先填右子树部分, 所以index - 1就指向了右子树范围的根 
		p(endp - inRightNum + 1, endp, inflag + 1, endi, index - 1);
		// 这一句是填左子树部分, 所以index 必须减去右子树部分, 指向左子树部分的根
		p(startp + 1, startp + inLeftNum, starti, inflag - 1, index - inRightNum - 1);
	}
}
