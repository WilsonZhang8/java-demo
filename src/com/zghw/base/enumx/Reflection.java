package com.zghw.base.enumx;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.TreeSet;

import com.zghw.base.OSExecute;

/**
 * 使用反射机制分析enum和java.lang.Enum类的关系
 * 方法values()的由来
 * @author zghw
 *
 */
enum Explore {
	HERE,THERE
}
public class Reflection {

	public static Set<String> analyze(Class<?> enumClass){
		System.out.println("Analyze enum class " +enumClass);
		//枚举对应的基类
		System.out.println(" base class "+enumClass.getSuperclass());
		System.out.println(" constain method:"); 
		Set<String> methods = new TreeSet<String>();
		for(Method m : enumClass.getMethods()){
			methods.add(m.getName());
		}
		System.out.println(methods);
		return methods;
	}
	public static void main(String[] args) {
		Set<String> exploreMethods=Reflection.analyze(Explore.class);
		Set<String> enumMethods = Reflection.analyze(Enum.class);
		boolean hasContains=exploreMethods.containsAll(enumMethods);
		System.out.println("Explore methods contains Enum methods "+hasContains);
		exploreMethods.removeAll(enumMethods);
		System.out.println("remainder  methods:"+exploreMethods);

		//由于values方法是由编译器插入到enum定义中的static方法，所以，如果你将enum实例向上转型为Enum，那么
		//values()方法就不可访问了。不过，在Class中有一个getEnumConstants()方法，所以即便Enum接口中
		//Enum接口中没有values()方法,可以通过Class对象取得所有的enum实例。
		// 转型
		Explore[] exs = Explore.values();
		Enum enu= Explore.HERE;
		//enu.values(); 没有这个方法
		for(Enum e:enu.getClass().getEnumConstants()){
			System.out.println(e);
		}
		OSExecute.command("javap /home/zghw/github/java-demo/bin/com/zghw/base/enumx/Explore.class");
		/**
		 * 下面是枚举在编译后生成的类结构
		 * 枚举生成的类是final 无法继承 所以枚举无法继承
		 * 枚举的父类是java.lang.Enum 可以使用Enum已有的方法
		 * 查看java.lang.Enum中并没有values方法说明编译其为每个enum生成了values()方法
		 * valueOf()方法重载了父类的方法
		 * 枚举实例 是static final的说明 是一个常量 
		 * 
		 * Compiled from "Reflection.java"
final class com.zghw.base.enumx.Explore extends java.lang.Enum<com.zghw.base.enumx.Explore> {
  public static final com.zghw.base.enumx.Explore HERE;
  public static final com.zghw.base.enumx.Explore THERE;
  static {};
  public static com.zghw.base.enumx.Explore[] values();
  public static com.zghw.base.enumx.Explore valueOf(java.lang.String);
}
		 */
	}

}
