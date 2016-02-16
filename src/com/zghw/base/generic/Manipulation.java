package com.zghw.base.generic;

/**
 * 只有当你希望使用的类型参数比某个具体类型（以及它的所有子类型）更加“泛化”时--也就是说，当你希望
 * 代码能够跨多个类工作时，时用泛型才有所帮助，通常比简单的类替换要更复杂
 * 必须查看所有的代码，并确定它是否“足够复杂”到必须时用泛型的程度
 * @author zghw
 *
 */
class HasF{
	void f(){
		System.out.println();
	}
}
class Manipulator<T>{
	private T obj;
	public Manipulator(T obj){
		this.obj =obj;
	}
	public void set(T obj){
		this.obj = obj;
	}
	public T get(){
		return obj;
	}
}
//没有泛型的类 比较上面的泛型类 可以发现泛型并没有任何好处
//T擦除了HasF,就好像在类的声明中用HasF一样
class Manipulator1{
	private HasF obj;
	public Manipulator1(HasF obj){
		this.obj =obj;
	}
	public void set(HasF obj){
		this.obj = obj;
	}
	public HasF get(){
		return obj;
	}
}
public class Manipulation {

	public static void main(String[] args) {
		Manipulator<HasF> m = new Manipulator<HasF>(new HasF());
		Manipulator1 m1 = new Manipulator1(new HasF());
		//T擦除了HasF,就好像在类的声明中用HasF一样
	}

}
