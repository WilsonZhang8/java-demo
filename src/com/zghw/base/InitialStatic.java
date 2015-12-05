package com.zghw.base;

import com.zghw.base.staticx.Cupborad;
import com.zghw.base.staticx.Table;

/**
 * 遇见new、静态变量的设置和取值、静态方法调用时，main 方法 反射，及父类都会触发初始化
 * 
 * @author zghw
 * 首先在调用main方法前，发现当前类InitialStatic未加载，则开始加载
 * 加载完成后，进行初始化首先初始化静态变量和静态块并赋值。
 * 在加载静态变量 Table t 和 Cupborad c 开始类加载 Table Cupborad Bowl类，并进行初始化
 * 先加载类中的静态变量然后在加载实例变量，最后调用构造函数完成初始化。
 * 然后开始main方法调用，连续创建了两个Cupborad实例，但Cupborad中的静态变量仅在第一次初始化了，
 * 因为对象实例中的static变量是使用的同一份值。
 * 每创建一个对象实例都会在堆上分配一份空间，并且实例变量有各自的副本。
 * 静态变量的初始化优先于实例变量的初始化
 *
 */

public class InitialStatic {
	public static void main(String args[]){
		System.out.println(" create cupboard in main");
		new Cupborad();
		System.out.println(" create cupboard in main");
		new Cupborad();
		t.f2(1);
		c.f3(1);
	}
	//遇见new、静态变量的设置和取值、静态方法调用时，都会触发初始化
	static Table t=new Table();
	static Cupborad c =new Cupborad();
}
/**
 * //初始化成员变量顺序
	//先初始化静态成员变量,初始化静态变量是按照代码顺序
	//然后初始化实例变量，初始化实例变量是也是按照代码顺序
	//然后调用构造方法
	//最后调用方法
	
	//静态变量只初始化第一次，以后创建对象就不会初始化静态变量了
	//实例变量每次在创建对象实例时都会重新创建
 */

