package com.zghw.base;

/**
 * final 关键字作用在方法和类上
 * 
 * @author zghw
 *
 */
public class FinalXMethodClass {

	// 当final修饰参数时（内部类中经常用到）
	// 1.当final修饰基本类型参数时，参数在方法中只能读取不能修改
	public int f(final int i) {
		// i++;编译出错
		// i=i+1;编译出错
		int j = i + 1;// 可以读取参数
		return j;
	}

	// 2.当final修饰引用类型参数时，不能在方法中修改参数引用所指向的引用
	public void with(final Value val) {
		System.out.println("before change val.v=" + val.v);
		// val=new Value(20);编译出错,不能修改参数引用所指向的引用
		// 但是可以修改对象中值
		val.v = 200;
		System.out.println("after change val.v=" + val.v);
	}

	// 2.2当final 作用于方法的局部变量时
	public void with() {
		final int a = 0;
		// a=1; 基本变量一旦赋值不能改变
		final Value v;// final空白,在需要的时候才赋值
		v = new Value(2);
		// v=new Value(3);编译出错 不能改变对象引用为其赋值
		v.v = 4;// 可以改变对象中的值
	}

	// 3.final 作用于方法主要用于设计方面的考虑，防止重写覆盖方法。（不常用）
	// 其实private修饰的方法就是隐含的final 方法

	public final void finalMethod() {
	}

	class Sub extends FinalXMethodClass {
		// public void finalMethod(){}编译器出错 不能覆盖父类final修饰过的方法
	}

	// 4.final 作用与类上，当将某个类定义为final时，就表明你不打算继承该类，而且也不允许别人这么做。
	// 对类的设计不做任何变动，出于安全考虑，你不希望它有子类。

	final class finalClass {
		private int i = 0;
	}

	// class subClass extends finalClass{} 编译器出错，不允许继承final定义的类
	public static void main(String args[]) {
		FinalXMethodClass f = new FinalXMethodClass();
		f.with(new Value(1));
	}

}
