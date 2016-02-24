package com.zghw.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 注解也称为元数据 为我们在代码中添加信息提供了一种形式化的方法，
 * 使我们可以在稍后某个时刻非常方便地使用这些数据。
 * 注解在一定程度上是把元数据与源代码文件结合在一起，而不是保存在外部文件中这一大的趋势之下所催生的。
 * 它可以提供用来完整地描述程序所需的信息，而这些信息是无法用Java来表达的。
 * 作用
 * 1：由编译器测试和验证的格式，存储有关程序的额外信息。
 * 2：用来生成描述符文件或新的类定义，有助于减轻编写样板代码的负担。
 * 3：可以将这些注解(元数据)保存在Java源代码中，并利用Annotaion API为自己的注解构建处理工具。
 * 4：更加干净易读的代码以及编译期类型检查等。
 * java定义了一些注解，但一般来说还是需要程序员自己添加新的注解，并且按自己的方式使用它们
 * 例如使用场景：每当你创建描述符性质的类或接口时，一旦其中包含了重复新的工作，
 * 那么就可以考虑使用注解来简化与自动化该过程。
 * 注解是真正的语言级的概念，一旦构造出来，就享有编译期的类型检查保护。
 * 注解是在实际的源代码级别保存所有的信息，而不是某种注释性的文字，这使得代码更整洁，且便于维护。
 * 通过使用扩展的annotation API,或外部的字节码工具类型，程序员拥有对源代码以及字节码强大的检查与操作能力。
 * 个人感悟：
 * 定义注解就好比定义了接口 使用注解就好比实现了接口
 * 定义注解，使用注解，及实现注解处理器 核心三部分
 * @author zghw
 *
 */
public class BaseAnnotation {
	/**
	 * 解析annotation方法
	 * @param annotationClass
	 */
	public static void resloveAnnotation(Class annotationClass){
		for(Method m : annotationClass.getDeclaredMethods()){
			Test t = m.getAnnotation(Test.class);
			System.out.println(" Test annotation case : id="+t.id()+" ,description = "+ t.description());
		}
		for(Field f : annotationClass.getDeclaredFields()){
			Color t = f.getAnnotation(Color.class);
			System.out.println(" color ="+t.value());
		}
	}
	public static void main(String args[]){
		resloveAnnotation(UseCase.class);
		System.out.println(new BaseAnnotation().hashCode());
	}
}

