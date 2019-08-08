package util;

public class MyHashMap<K, V>
{
	static class Node<K, V>
	{
		int hash;
		K key;
		V value;
		Node<K, V> next;

		Node(int hash, K key, V value, Node<K, V> next)
		{
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node<K, V>[] table;
	private int size;
	private static final double RESIZE_FACTOR = 0.75;

	@SuppressWarnings("unchecked")
	public MyHashMap()
	{
		table = (Node<K, V>[]) new Node[16];
		size = 0;
	}

	public int hash(K key, int length)
	{
		return key.hashCode() & (length - 1);
	}
	// 扩容, 取出旧得, put到新的table里
	public void resize()
	{
		if(table.length * RESIZE_FACTOR <= size)
		{
			@SuppressWarnings("unchecked")
			Node<K, V>[] newTable = (Node<K, V>[]) new Node[table.length * 2];
			this.size = 0;
			for (Node<K, V> node : table)
			{
				while(node != null)
				{
					putVal(node.key, node.value, newTable);
					node = node.next;
				}
			}
			this.table = newTable;
		}
	}
	
	public void put(K key, V value)
	{
		resize();
		putVal(key, value, null);
	}
	
	// 单纯的put值, 不考虑扩容
	public void putVal(K key, V value, Node<K, V>[] newTable)
	{
		Node<K, V>[] bucket = newTable == null ? this.table : newTable;
		int hash = hash(key, bucket.length);
		Node<K, V> temp = bucket[hash];
		// 无hash冲突
		if (temp == null)
		{
			bucket[hash] = new Node<>(hash, key, value, null);
			size++;
			return;
		}
		// 产生冲突
		// 记录遍历过程中最后一个node
		Node<K, V> last = null;
		while (temp != null)
		{
			// 替换value
			if (temp.key.equals(key))
			{
				temp.value = value;
				return;
			}
			last = temp;
			temp = temp.next;
		}
		// 执行到这里last一定不会为null
		last.next = new Node<>(hash, key, value, null);
		size++;
	}
	
	public V get(K key)
	{
		int hash = hash(key, table.length);
		Node<K, V> temp = table[hash];
		while(temp != null)
		{
			if(temp.key.equals(key))
			{
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("{");
		for (Node<K, V> node : table)
		{
			while(node != null)
			{
				sb.append(node.key + " : " + node.value + ", ");
				node = node.next;
			}
		}
		sb.setCharAt(sb.length() - 2, '}');
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
//		MyHashMap<Integer, String> map = new MyHashMap<>();
//		for(int i = 0; i < 20; i++)
//		{
//			map.put(i, String.valueOf('a' + "_" + i));
//		}
//		System.out.println(map);
//		System.out.println(map.get(15));
//		System.out.println(map.get(1));
//		for(int i = 5; i < 50; i++)
//		{
//			System.out.println(i + ", " + (new Integer(i).hashCode() & 15));
//		}
		
		System.out.println(new Object().hashCode());
		System.out.println(new Object().hashCode());
	}
}
