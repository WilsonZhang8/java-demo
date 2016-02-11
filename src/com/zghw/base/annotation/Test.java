package com.zghw.base.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import com.zghw.base.annotation.Color.Val;

/**
 * 定义注解：
 * 
 * 
 * 四种元注解： 
 * 
 * 1： @Target用来定义你的注解及将应用于什么地方
 * 下面是取值可多选：
 * ElementType.PACKAGE 包 
 * ElementType.TYPE 类 接口 包含注解，枚举
 * ElementType.FIELD 域
 * ElementType.CONSTRUCTOR 构造方法
 * ElementType.METHOD 方法
 * ElementType.PARAMETER 方法中的参数
 * ElementType.LOCAL_VARIABLE 方法中的局部变量
 * 
 *2： @Retention 用来定义注解在哪一个级别可用
 * 下面时取值只能取一个值:
 * RetentionPolicy.SOURCE,源代码中，注解将被编译器丢掉
 * RetentionPolicy.CLASS,类文件中，默认。经会被VM丢掉
 * RetentionPolicy.RUNTIME，运行时。VM在运行期间也保存注解，可以使用反射及值读取注解的信息。
 * 
 * 3: @Documented 将此注解包含在Javadoc中
 * 4： @Inherited  允许子类继承父类中的注解 
 * @author zghw
 *
 */
@Target({ElementType.PACKAGE,ElementType.TYPE,ElementType.FIELD,ElementType.CONSTRUCTOR,
	ElementType.METHOD,ElementType.PARAMETER,ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Test {//使用 @interface 定义注解 就像定义接口
	//没有元素定义则为标记注解
	public int id();//注解中包含的元素定义
	public String description() default "aaaa";//注解中包含的元素定义 并初始化值
}
class UseCase{
	@Color(Val.red)
	private String color;
	@Color(Val.green)
	public String cc;
	@Color
	String ccc;
	//注解元素使用时，作为名值对的形式存在括号内
	@Test(id=1,description="bbb")
	public boolean test1(){
		int a=2;
		int b=3;
		return a>b;
	}
	//注解的使用 使用默认的description
	@Test(id=2)
	public void test2(){
		int a=2;
		int b=3;
	}
	@Test(id=3,description="ccc")
	public boolean test3(){
		int a=2;
		int b=3;
		return a<b;
	}
}

class UseCaseTracker{
	public static void resloveAnnotation(Class annotationClass){
		for(Method m : annotationClass.getDeclaredMethods()){
			Test t = m.getAnnotation(Test.class);
			System.out.println(" Test annotation case : id="+t.id()+" ,description = "+ t.description());
		}
	}
	public static void main(String args[]){
		resloveAnnotation(UseCase.class);
		
	}
}



