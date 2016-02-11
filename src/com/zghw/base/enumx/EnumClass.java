package com.zghw.base.enumx;
/**
 * 枚举的基本使用
 * @author zghw
 *
 */
enum Shrubbery {
	GROUND,CRAWLING,HANGING
}
public class EnumClass {

	//创建enum时，编译器会为你生成一个相关的类，这个类继承自java.lang.Enum
	public static void main(String[] args) {
		//调用values()方法，可以遍历enum实例，values方法返回enum实例的数组
		//而且该数组中的元素严格保持其在enum中的声明时的顺序，因此你可以在循环中使用values()返回的数组
		for(Shrubbery s : Shrubbery.values()){
			//ordinal()方法返回enum实例在声明时的次序 从0开始计数
			System.out.println(s + ": ordinal =" + s.ordinal());
			//enum继承自java.lang.Enum,Enum类实现了Comparable接口，可以用于比较enum实例次序大小
			System.out.println(s.compareTo(Shrubbery.CRAWLING));
			//可以使用equals或==来比较enum实例
			System.out.println(s.equals(Shrubbery.CRAWLING));
			System.out.println(s==Shrubbery.CRAWLING);
			//通过enum实例的getDeclaringClass()方法，就能知道所属的enum类
			System.out.println(s+ "declaring ："+s.getDeclaringClass());
			//name()方法返回enum实例声明时的名字，它和toString()方法一样。
			System.out.println(s.name());
			System.out.println("---------------");
		}
		
		for(String s : "HANGING GROUND CRAWLING".split(" ")){
			//valueof()方法是Enum中的静态方法，根据对应的字符名称返回对应的enum实例
			Shrubbery sh=Enum.valueOf(Shrubbery.class, s);
			System.out.println(sh);
		}
	}

}
