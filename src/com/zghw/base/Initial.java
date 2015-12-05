package com.zghw.base;
//遇见new、静态变量的设置和取值、静态方法调用时，都会触发初始化
public class Initial {

	/**
	 * 1.成员变量在使用前都会先赋上默认初始值 boolean =false short =0 int =0 float =0.0 double
	 * =0.0 long =0 refrence =null char =
	 * 
	 * @param args
	 */
	private boolean t;
	private char c;
	private short s;
	private int i;
	private float f;
	private double d;
	private long l;
	private Initial r;

	/**
	 * 打印没有指定初始化的类变量值
	 */
	void print() {
		System.out.println("boolean =" + t);
		System.out.println("short =" + s);
		System.out.println("int =" + i);
		System.out.println("float =" + f);
		System.out.println("double =" + d);
		System.out.println("long =" + l);
		System.out.println("refrence =" + r);
		System.out.println("char =" + c);
	}

	// ///////////////////////////
	/**
	 * 2.直接在成员变量后边赋值
	 * 
	 * @param args
	 */
	private boolean tt = true;
	private char cc = 'a';
	private short ss = 0xff;
	private int ii = 11;
	private float ff = 1.5f;
	private double dd = 1.36253;
	private long ll = 12356465l;

	void print2() {
		System.out.println("boolean tt=" + tt);
		System.out.println("short ss=" + ss);
		System.out.println("int ii=" + ii);
		System.out.println("float ff=" + ff);
		System.out.println("double dd=" + dd);
		System.out.println("long ll=" + ll);
		System.out.println("refrence rr=" + this);
		System.out.println("char cc=" + cc);
	}

	// //////////////////////////////////////////
	/**
	 * 3.无法阻止默认初始化的进行,以保证你在使用前得到保证。
	 * 
	 * @param args
	 */
	private int a;
	private String b;
	private long lo = 23423l;

	/**
	 * 构造函数在未初始化成员变量前，是jvm自动初始化了成员变量，无法阻止
	 */
	public Initial() {
		System.out.println("before init a=" + a + " , b=" + b + " ,lo=" + lo);
		a = 4;
		b = "ss";
		lo = 5465l;
		System.out.println("after init a=" + a + " , b=" + b + " ,lo=" + lo);
		System.out.println("house");
		w3 = new Window("33");
	}

	// /////////////////////////////////////////////////
	// 4.成员变量在构造函数和方法之前先初始化
	class Window {
		Window(String mark) {
			System.out.println("window " + mark);
		}
	}

	// 在构造函数后的变量
	Window w1 = new Window("1");
	Window w2 = new Window("2");

	void f() {
		System.out.println("f()");
	}

	// 在方法f()后的变量
	Window w3 = new Window("3");

	// Window不管在构造函数前，还是方法后都会先初始化 w1 w2 w3
	// //////////////////////////////////////////////////////////
	public static void main(String args[]) {
		Initial r = new Initial();
		// r.print();
		// r.print2();
		r.f();
	}
}
