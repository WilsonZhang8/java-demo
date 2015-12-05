package com.zghw.base.staticx;

public class Cupborad {
	//初始化成员变量顺序
	//先初始化静态成员变量,初始化静态变量是按照代码顺序
	//然后初始化实例变量，初始化实例变量是也是按照代码顺序
	//然后调用构造方法
	//最后调用方法
	
	//静态变量只初始化第一次，以后创建对象就不会初始化静态变量了
	//实例变量每次在创建对象实例时都会重新创建
	private Bowl bowl3 = new Bowl(3);
	private static Bowl bowl4 = new Bowl(4);

	public Cupborad() {
		System.out.println("Cupborad");
		bowl4.f1(2);
	}

	public void f3(int marker) {
		System.out.println("f3 " + marker);
	}

	private static Bowl bowl5 = new Bowl(5);
}
