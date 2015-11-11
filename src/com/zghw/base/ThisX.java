package com.zghw.base;

/**
 * this关键字的用法
 * 
 * @author zghw
 *
 */
public class ThisX {
	private String name;

	// 1.this 在方法的内部使用this
	// 表示对“调用方法的那个对象”的引用
	public ThisX(String name) {
		// 如果使用的ThisX a = new ThisX("111");
		// 那么this 就相当于a引用
		// 以下代码等同于
		// a.name="111";
		this.name = name;
	}

	public void testThis() {
		// 每个非静态方法内部都能获取对当前对象的引用。这个引用是编译器偷偷的"传入"的。
		// 并且方法的第一个参数就是this
		// this调用成员变量
		System.out.println(this.name);
		// this 在不必要时可以省略
		System.out.println(name);
		// 调用该对象的方法时无须使用this,直接调用
		f();
	}

	// 2. this的主要用途 当需要返回对当前对象的引用时就常常在return语句中这样写：
	// 在调用该方法时就可以多次调用该方法
	// b.getThisX().getThisX().getThisX()
	public ThisX getThisX() {
		this.name = this.name + "_";
		return this;
	}

	public void f() {
	}

	// 3.this作为参数传入外部方法调用时，
	public void eat(Apple apple) {
		apple.get();
	}

	static class Peeler {
		static Apple peel(Apple apple) {
			// do something
			return apple;
		}
	}

	class Apple {
		Apple get() {
			// this作为参数传入外部方法调用时
			return Peeler.peel(this);
		}
	}

	public static void main(String args[]) {
		ThisX a = new ThisX("111");
		ThisX b = new ThisX("222");
		a.testThis();
		b.testThis();
		//
		ThisX c = b.getThisX().getThisX().getThisX();
		c.testThis();
		b.testThis();
		c.eat(a.new Apple());

	}
}
/**
 * 其实this主要要三种用法：

１、表示对当前对象的引用！

２、表示用类的成员变量，而非函数参数，注意在函数参数和成员变量同名是进行区分！其实这是第一种用法的特例，比较常用，所以那出来强调一下。

３、用于在构造方法中引用满足指定参数类型的构造器（其实也就是构造方法）。但是这里必须非常注意：只能引用一个构造方法且必须位于开始！

还有就是注意：this不能用在static方法中！所以甚至有人给static方法的定义就是：没有this的方法！虽然夸张，但是却充分说明this不能在static方法中使用！
 */
