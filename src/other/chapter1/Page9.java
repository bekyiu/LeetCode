package other.chapter1;

import java.util.ArrayDeque;
import java.util.Deque;

import lombok.Getter;
import lombok.ToString;

//猫狗队列
class Pet
{
	@Getter
	private String type;
	public Pet(String type)
	{
		this.type = type;
	}
}

class Dog extends Pet
{
	public Dog()
	{
		super("dog");
	}
}
class Cat extends Pet
{
	public Cat()
	{
		super("cat");
	}
}

public class Page9
{
	public static void main(String[] args)
	{
		
	}
}

//要为每个宠物打上一个时间戳, 但是又不能改变原有结构, 所以再包装一层
@ToString
class Entity
{
	@Getter
	private Pet pet;
	@Getter
	private long count;
	
	public Entity(Pet pet, long count)
	{
		this.pet = pet;
		this.count = count;
	}
}

//构造猫狗队列
class CatDogQueue
{
	private Deque<Entity> cats = new ArrayDeque<>();
	private Deque<Entity> dogs = new ArrayDeque<>();
	private long count = 0;
	
	public void add(Pet pet)
	{
		if(pet.getType().equals("dog"))
		{
			dogs.add(new Entity(pet, ++count));
		}
		else if(pet.getType().equals("cat"))
		{
			cats.add(new Entity(pet, ++count));
		}
		else
		{
			throw new RuntimeException("add err");
		}
	}
	
	public Pet pollAll()
	{
		if(cats.isEmpty() && dogs.isEmpty())
		{
			throw new RuntimeException("pollAll err");
		}
		if(cats.isEmpty())
		{
			return dogs.poll().getPet();
		}
		if(dogs.isEmpty())
		{
			return cats.poll().getPet();
		}
		Entity dog = dogs.peek();
		Entity cat = cats.peek();
		return dog.getCount() < cat.getCount() ? dog.getPet() : cat.getPet();
	}
}

















