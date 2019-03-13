package util.sort;

import java.util.PriorityQueue;

public class PrioorityQueueDemo
{
	public static void main(String[] args)
	{
		//默认实现是小根堆
		PriorityQueue<Student> heap = new PriorityQueue<>();
		heap.add(new Student(1, 10));
		heap.add(new Student(2, 10));
		heap.add(new Student(3, 10));
		heap.add(new Student(4, 10));
		while(!heap.isEmpty())
		{
			System.out.println(heap.poll());
		}
	}
}
class Student implements Comparable<Student>
{
	int id;
	int age;
	@Override
	public int compareTo(Student o)
	{
		//return 负数代表当前对象的值小
		//return o.id - this.id;
		return this.id - o.id;
	}
	public Student(int id, int age)
	{
		this.id = id;
		this.age = age;
	}
	@Override
	public String toString()
	{
		return "Student [id=" + id + ", age=" + age + "]";
	}
	
}
