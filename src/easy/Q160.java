package easy;

import java.util.HashMap;
import java.util.Map;

/*
 * 编写一个程序，找到两个单链表相交的起始节点
 * 思路1: 使用hashmap遍历其中一条链表 都存入map
 * 遍历第二条链表时, 在map中查询, 返回第一个存在的节点
 * 思路2:
 * 遍历链表A 记录下A的长度, 记录最后一个节点
 * 遍历链表B 记录下B的长度, 记录最后一个节点
 * 先比较两者的最后一个节点, 如果不相同 则肯定不想交
 * 如果相同:
 * 		找到长的那个链表, 比如 A 长100, B 长80
 * 		先在A中先走20步, 之后A B同时遍历, 返回第一个相同的节点
 */

public class Q160
{
	//map
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) 
    {
    	if(headA == null || headB == null)
    	{
    		return null;
    	}
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != null)
        {
        	map.put(pa, pa);
        	pa = pa.next;
        }
        while(pb != null)
        {
        	ListNode rest = map.get(pb);
        	if(rest != null)
        	{
        		return rest;
        	}
        	pb = pb.next;
        }
        return null;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        if(headA == null || headB == null)
    	{
    		return null;
    	}
        ListNode pa = headA;
        int aLen = 1;
        ListNode pb = headB;
        int bLen = 1;
        while(pa.next != null)
        {
        	aLen++;
        	pa = pa.next;
        }
        while(pb.next != null)
        {
        	bLen++;
        	pb = pb.next;
        }
        if(pa != pb)
        {
        	return null;
        }
        pa = headA;
        pb = headB;
        if(aLen > bLen)
        {
        	for (int i = 0; i < aLen - bLen; i++)
			{
				pa = pa.next;
			}
        }
        else
        {
        	for (int i = 0; i < bLen - aLen; i++)
			{
				pb = pb.next;
			}
        }
        while(pb != null)
        {
        	if(pb == pa)
        	{
        		return pa;
        	}
        	pa = pa.next;
        	pb = pb.next;
        }
        return null;
    }
	public static void main(String[] args)
	{
		
	}
	
	class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x)
		{
			val = x;
			next = null;
		}
	}
}
