package com.zghw.base.generic;

import java.util.*;

/**
 * 通配符
 * 为什么需要通配符？
 * 泛型没有内建的协变类型
 * 通配符
 * 1.？ extends T 用作方法返回值 意味着 它可以是任何事物包括子类，而编译器无法验证“任何事物”的安全性
 * 2.? super T   用作方法参数 将一个T类型的对象或者从T导出的任何对象作为参数传入使用类型的方法
 * 3.?
 * 因此你可能会根据如何能够向一个泛型类型”写入“（传递给一个方法），
 * 以及如何能够从一个泛型类型中“读取”（从一个方法中返回），来左手思考子类型和超类型边界。
 * @author zghw
 *
 */
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}
public class Covariance{

	public static void main(String[] args) {
		List<Fruit> list1 =new ArrayList<Fruit>();
		List<Apple> list2 =new ArrayList<Apple>();
		//编译不通过 Apple的List在类型上不等价于Fruit的List，即使Apple是Fruit的子类
		//我们在讨论的是容器的类型，而不是容器持有的类型
		//但是，我们想要在两个类型之间建立某种类型的向上转型关系，
		//就需要通配符
		//List<Fruit> list3 =new ArrayList<Apple>();//编译不通过 
		
		//List<? extends Fruit> :你可以读作”具有任何从Fruit继承的类型的列表“
		//但List不会持有任何类型的Fruit. list3引用没有指定具体的类型 
		//只是为了向上转型
		List<? extends Fruit> list3 =new ArrayList<Apple>();
		
		//只接受 add(? extends Fruit e) 不了解到底需要Fruit的那个具有子类型
		//因此它不会接受任何Fruit,甚至只接受null
		//? extends Fruit 意味着 它可以是任何事物，而编译器无法验证“任何事物”的安全性
		//list3.add(new Apple());//编译不通过
		//list3.add(new Fruit());//编译不通过
		//list3.add(new Object());//编译不通过
		list3.add(null);
		
		writeTo(new ArrayList<Fruit>(),new Apple());
		
	}
	/**
	 * ? super T 只作用泛型参数中，List将持有从T导出的某种具体类型，这样就可以安全的将一个T类型的对象
	 *或者从T导出的任何对象作为参数给List方法
	 * @param fruit
	 * @param item
	 */
	static <T> void writeTo(List<? super T> fruit,T item){
		fruit.add(item);
	}
}
