package medium;

import java.util.HashMap;
import java.util.Map;

/*
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
	insert(val)：当元素 val 不存在时，向集合中插入该项。
	remove(val)：元素 val 存在时，从集合中移除该项。
	getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
	思路: 使用两个map和一个size, size相当于是下标
	map1存放 val, size, map2存放 size, val
	添加操作:
		两个map各自put就行了 最后size++
	getRandom
		由于存在size, 所以可以由(int) (Math.random() * size) 得到[0, size - 1]的值
		再用这个随机值去map2中取对应val返回即可
	删除:
		如果直接删除两个map中的对应键值对, 那么就会在[0, size - 1]的范围上形成洞
		下一次调用getRandom方法时, 算出的随机值可能恰好就是这个洞, 而这里是没有值的, 需要重算
		正确的做法是找到要被删除的键值对, 然后用最后一个键值对覆盖他们, 然后删除最后的键值对
 */
public class Q380
{
	//key:val
	private Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
	//key:size
	private Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
	private Integer size = 0;
	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val)
	{
		if(map1.containsKey(val))
		{
			return false;
		}
		map1.put(val, size);
		map2.put(size, val);
		size++;
		return true;
	}
	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val)
	{
		if(!map1.containsKey(val))
		{
			return false;
		}
		int deleteIndex = map1.get(val);
		int lastIndex = --size;
		int lastKey = map2.get(lastIndex);
		map1.put(lastKey, deleteIndex);
		map2.put(deleteIndex, lastKey);
		map1.remove(val);
		map2.remove(lastIndex);
		return true;
	}
	/** Get a random element from the set. */
	public int getRandom()
	{
		int index = (int) (Math.random() * size);
		return map2.get(index);
	}
}
