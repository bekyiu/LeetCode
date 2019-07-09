package other.chapter3;

import java.util.List;

public class Page169
{
	class Employee
	{
		public int happy;
		List<Employee> subordinates;
		public Employee(int happy, List<Employee> subordinates)
		{
			this.happy = happy;
			this.subordinates = subordinates;
		}
	}
	
	class ReturnType
	{
		//当前节点来, 以当前节点为根的子树的最大活跃度
		public int yes;
		//当前节点不来, 最小
		public int no;
		public ReturnType(int yes, int no)
		{
			this.yes = yes;
			this.no = no;
		}
		
	}
	
	public ReturnType p(Employee head)
	{
		// 根来还是不来 整棵树的活跃度
		int yes = head.happy;
		int no = 0;
		
		for (Employee e : head.subordinates)
		{
			// e 来和不来, 以e为根的树的最大收益
			ReturnType r = p(e);
			// 根来了他的直接下级就不能来, 所以加上下级不能来的活跃度
			yes += r.no;
			// 根如果不来, 下级可以来可以不来, 选最大的
			no += Math.max(r.no, r.yes);
		}
		// 上述for可以不执行, 说明是叶子节点 直接返回即可
		return new ReturnType(yes, no);
	}
	
	public int fun(Employee head)
	{
		ReturnType r = p(head);
		return Math.max(r.yes, r.no);
	}
	public static void main(String[] args)
	{
	}
}
