package com.zghw.base;

import java.util.ArrayList;
import java.util.List;

/**
 * final 作用在字段上
 * 
 * @author zghw
 *
 */
public class FinalXFiled {
	// 1. final 作用与基本类型时
	private int i;
	// private final int b;//编译不通过 final 定义的变量必须赋值 或在使用前必须进行初始化

	// 对于基本类型 final修饰后就恒定不变
	private final int b = 1;
	private final String s = "s";

	public void test() {
		System.out.println("before: i=" + i);
		i = 2;
		System.out.println("after: i=" + i);
		// 定义了final的变量不允许赋值
		// b=2;编译不通过
		// s="ss";编译不通过
	}

	// 2.final 作用与引用类型时
	private Value val;
	// private final Value val;编译不通过 final 定义的变量必须赋值 或 在使用前必须进行初始化

	// 对于引用类型 fianl修饰后对象的引用恒定不变，一旦引用被初始化指向一个对象就无法在把它指向另一个对象。
	private final Value fval = new Value(10);
	// 数组也是引用类型
	private final int[] arr = new int[] { 1, 2, 3, 4, 5 };

	public void testV() {
		val = new Value(20);
		// 定义了final的引用变量不允许改变对象的引用
		// fval=new Value(20);编译不通过
		// 但对象自身是可以修改的
		System.out.println("before set fval.v=" + fval.v);
		fval.v = 111;
		System.out.println("after set fval.v=" + fval.v);

		// 数组的引用无法改变
		// arr=new int[5];编译不通过
		// 数组的单元值改变了
		System.out.println("before set arr=" + arr);
		for (int i = 0; i < 5; i++) {
			System.out.println("before " + i + "=" + arr[i]);
			arr[i] = i + 5;
			System.out.println("after " + i + "=" + arr[i]);
			System.out.println();
		}
		System.out.println("after set arr=" + arr);
	}

	// 3.final设定的值不一定在编译期间就给定，也可以在初始化期间给定。
	private final int fri = (int) (Math.random() * 1000);// 每次创建一个对象，对应的值就不一样,每个对象有一份
	private static final int frsi = (int) (Math.random() * 1000);// //使用static
																	// final
																	// 内存中只有一份内存存储

	public void testFri() {
		// 每次编译完成后值是不确定的，只有在初始化时,值才确定
		// 每次创建一个对象，对应的值就不一样,每个对象有一份
		System.out.println("final fri=" + this.fri);
		// 使用static final 内存中只有一份内存存储
		System.out.println("final frsi=" + frsi);
	}

	// 4.在被指明为final但又未给定初值的域，在使用前必须初始化
	// 好处：一个类中的final域就可以做到根据对象而有所不同，却又保持了恒定不变的特性
	private final String ss;
	private final Value valb;

	// 使用前初始化在构造函数中如下：
	public FinalXFiled() {
		ss = "s";
		valb = new Value(1);
	}

	// 好处：一个类中的final域就可以做到根据对象而有所不同，却又保持了恒定不变的特性
	public FinalXFiled(String ss) {
		this.ss = ss;
		this.valb = new Value(10);
	}

	// 好处：一个类中的final域就可以做到根据对象而有所不同，却又保持了恒定不变的特性
	public FinalXFiled(String ss, Value valb) {
		this.ss = ss;
		this.valb = valb;
	}

	public void printFinalX() {
		System.out.println("ss=" + this.ss + " Value.v=" + this.valb.v);
	}

	//当一个final 定义在引用类型上 把这个值赋给 另外一个对象,
	//它们使用的是同一分
	public void printFinalSet(){
		Value fvalUse =this.fval;
		List<Object> list =new ArrayList<Object>();
		list.add("sdfsdf");
		list.add("werwerwe");
		fvalUse.setList(list);
		System.out.println(""+this.fval.getList().size());
		System.out.println(""+fvalUse.getList().get(0));
	}
	public static void main(String[] args) {
		FinalXFiled f = new FinalXFiled();
		f.test();
		// f.testV();
		f.testV();

		FinalXFiled f1 = new FinalXFiled();
		f.testFri();
		f1.testFri();
		String ss2 = "ss";
		String ss3 = "sss";
		Value v = new Value(20);
		FinalXFiled f2 = new FinalXFiled(ss2);
		FinalXFiled f3 = new FinalXFiled(ss3, v);
		f1.printFinalX();
		f2.printFinalX();
		f3.printFinalX();
		f3.printFinalSet();
	}

}
