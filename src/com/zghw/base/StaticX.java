package com.zghw.base;
/**
 * static功能：
 * <br>
 * 1.成员变量：只想为某个特定域分配单一存储空间，而不去考虑究竟要创建多少对象，甚至根本就不创建任何对象
 * 2.方法：希望某个方法不与包含它的类的任何对象关联在一起 
 * @author zghw
 * 
 *
 */
public class StaticX {
	int x=11;
	static int a=11;
	
	Value vx=new Value(22);
	static Value vs=new Value(22);
	
	static void s(){}
	void g(){}
	//静态方法
	static void f(){
		//静态方法中不能使用this super
		//this.a=0;编译出错
		//super.toString();编译出错
		
		//static方法内可以调用该类静态变量a 不能调用该类中实例变量x
		a++;
		//x++;编译出错
		
		Value val=new Value(10);
		val.p=20;//其他类的实例变量
		Value.pubs=55;//其他类的静态变量
		
		//static方法内可以调用static方法 不能调用该类中方法
		s();
		//g();编译出错
		
		val.noStaticMethod();//其他类的非静态方法
		Value.staticMethod();//其他类的静态方法
		
	}
	//实例方法
	void z(){
		this.a=0;
		super.toString();
		a++;
		x++;
		
		Value val=new Value(10);
		val.p=20; 
		Value.pubs=55; 
		
		s();
		g();
		
		val.noStaticMethod();//其他类的非静态方法
		Value.staticMethod();//其他类的静态方法
	}
	public static void main(String args[]){
		
		//==========================
		/**
		 * 验证当声明一个对象时，并不产生static变量的拷贝，
		 * 而是该类所有的实例共用同一个static变量。
		 */
		StaticX s1=new StaticX();
		StaticX s2=new StaticX();
		//两个对象实例变量x中的值时一样的 值为：11
		System.out.println("s1.x="+s1.x);
		System.out.println("s2.x="+s2.x);
		//两个对象静态变量a中的值时一样的 值为：11（不建议使用对象引用使用静态变量 以下为了测试）
		System.out.println("s1.a="+s1.a);
		System.out.println("s2.a="+s2.a);
		
		s1.x=55;//修改对象s1中实例变量x 值为55
		s1.a=55;//修改对象s1中实例变量a 值为55
		
		System.out.println("====after====");
		//对象s1中的实例变量x变为55
		System.out.println("s1.x="+s1.x);
		//对象s2中的实例变量x未变还是未11
		System.out.println("s2.x="+s2.x);
		//对象s1中的静态变量a值为55
		System.out.println("s1.a="+s1.a);
		//对象s2中的静态变量a值也为55
		System.out.println("s2.a="+s2.a);

		System.out.println("s1.vx.v="+s1.vx.v);
		System.out.println("s2.vx.v="+s2.vx.v);
		System.out.println("s1.vs.v="+s1.vs.v);
		System.out.println("s2.vs.v="+s2.vs.v);
		//实例内存地址是不一致的
		System.out.println("s1.vx 实例 内存地址="+s1.vx);
		System.out.println("s2.vx 实例 内存地址="+s2.vx);
		//以下三个静态内存地址 保持一致 
		System.out.println("s1.vs 静态 内存地址="+s1.vs);
		System.out.println("s2.vs 静态 内存地址="+s2.vs);
		System.out.println("StaticX.vs 静态 内存地址="+StaticX.vs);
		s1.vx = new Value(99);
		s2.vx = new Value(88);
		s2.vs = new Value(88);
		System.out.println("====after====");
		System.out.println("s1.vx.v="+s1.vx.v);
		System.out.println("s2.vx.v="+s2.vx.v);
		System.out.println("s1.vs.v="+s1.vs.v);
		System.out.println("s2.vs.v="+s2.vs.v);
		//实例内存地址是不一致的
		System.out.println("s1.vx 实例 内存地址="+s1.vx);
		System.out.println("s2.vx实例 内存地址="+s2.vx);
		//以下三个静态内存地址 保持一致 
		System.out.println("s1.vs静态 内存地址="+s1.vs);
		System.out.println("s2.vs静态 内存地址="+s2.vs);
		System.out.println("StaticX.vs静态 内存地址="+StaticX.vs);
		/**
		 * 以上说明了当声明一个对象时，并不产生static变量的拷贝，
		 * 而是该类所有的实例共用同一个static变量。
		 */
		//===================================
		//StaticX.x=11;非静态变量不能直接被使用
		StaticX.a=66;//建议使用此方式来使用静态变量 不建议使用对象引用使用静态变量
		System.out.println("s1.a="+StaticX.a);
		System.out.println("s2.a="+s2.a);//不建议使用对象引用使用静态变量
		/**
		 * 以上说明被static修饰的成员变量独立于该类的任何对象。
		 * 也就是说，它不依赖类特定的实例，被类的所有实例共享。
		 * 只要这个类被加载，Java虚拟机就能根据类名在运行时数据区的方法区内定找到他们。
		 * 因此，static对象可以在它的任何对象创建之前访问，无需引用任何对象。
		 * 对于静态变量在内存中只有一个拷贝（节省内存），JVM只为静态分配一次内存，
		 * 在加载类的过程中完成静态变量的内存分配，
		 * 可用类名直接访问（方便），当然也可以通过对象来访问（但是这是不推荐的）。
		 * 对于实例变量，每创建一个实例，就会为实例变量分配一次内存，
		 * 实例变量可以在内存中有多个拷贝，互不影响（灵活）。
		 */
		//===================================
		StaticX.f();
		s1.z();
		
		
		
		//参考类Value
		//System.out.println(Value.pris);编译出错 静态变量也是有访问权限控制的，并不代表static变量修饰后就是全局变量
		System.out.println(Value.pubs);//只有定义了public，static全局才有效
		
	}
}
/**
 * 
    通常，在一个类中定义一个方法为static，那就是说，无需本类的对象即可调用此方法

    声明为static的方法有以下几条限制:
      * 它们仅能调用其他的static方法。
      * 它们只能访问static数据。
      * 它们不能以任何方式引用this或super

    声明为static的变量实质上就是全局变量。当声明一个对象时，并不产生static变量的拷贝，而是该类所有的实例变量共用同一个static变量。静态变量与静态方法类似。所有此类实例共享此静态变量，也就是说在类装载时，只分配一块存储空间，所有此类的对象都可以操控此块存储空间，当然对于final则另当别论了,它们共享一块存储区.
    static表示“全局”或者“静态”的意思，用来修饰成员变量和成员方法，也可以形成静态static代码块，但是Java语言中没有全局变量的概念。 

    被static修饰的成员变量和成员方法独立于该类的任何对象。也就是说，它不依赖类特定的实例，被类的所有实例共享。只要这个类被加载，Java虚拟机就能根据类名在运行时数据区的方法区内定找到他们。因此，static对象可以在它的任何对象创建之前访问，无需引用任何对象。

    用public修饰的static成员变量和成员方法本质是全局变量和全局方法，当声明它类的对象时，不生成static变量的副本，而是类的所有实例共享同一个static变量。

    static变量前可以有private修饰，表示这个变量可以在类的静态代码块中，或者类的其他静态成员方法中使用（当然也可以在非静态成员方法中使用--废话），但是不能在其他类中通过类名来直接引用，这一点很重要。实际上你需要搞明白，private是访问权限限定，static表示不要实例化就可以使用，这样就容易理解多了。static前面加上其它访问权限关键字的效果也以此类推。
    
    static修饰的成员变量和成员方法习惯上称为静态变量和静态方法，可以直接通过类名来访问，访问语法为：

       类名.静态方法名(参数列表...) 
       类名.静态变量名

    用static修饰的代码块表示静态代码块，当Java虚拟机（JVM）加载类时，就会执行该代码块（用处非常大，呵呵）。

 static变量

    按照是否静态的对类成员变量进行分类可分两种：一种是被static修饰的变量，叫静态变量或类变量；另一种是没有被static修饰的变量，叫实例变量。两者的区别是：

    对于静态变量在内存中只有一个拷贝（节省内存），JVM只为静态分配一次内存，在加载类的过程中完成静态变量的内存分配，可用类名直接访问（方便），当然也可以通过对象来访问（但是这是不推荐的）。

    对于实例变量，没创建一个实例，就会为实例变量分配一次内存，实例变量可以在内存中有多个拷贝，互不影响（灵活）。

static方法

    静态方法可以直接通过类名调用，任何的实例也都可以调用，因此静态方法中不能用this和super关键字，不能直接访问所属类的实例变量和实例方法(
就是不带static的成员变量和成员成员方法)，只能访问所属类的静态成员变量和成员方法。因为实例成员与特定的对象关联！这个需要去理解，想明白其中的道理，不是记忆！！！

    因为static方法独立于任何实例，因此static方法必须被实现，而不能是抽象的abstract。

  
 * 
 */
