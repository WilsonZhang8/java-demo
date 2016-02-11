package com.zghw.base.enumx;

import java.text.DateFormat;
import java.util.Date;
/**
 * 允许程序员为enum实例编写方法，从而为每个enum实例赋予各自不同的行为。
 * 要实现常量相关的方法，你需要为enum定义一个或多个abstract方法，
 * 然后为每个enum实例实现该抽象方法
 * @author zghw
 *
 */
public enum ConstantSpecificMethod {
  DATE_TIME{
	  String getInfo(){
		  return DateFormat.getInstance().format(new Date());
	  }
  },
  CLASSPATH{
	  String getInfo(){
		  return System.getenv("CLASSPATH");
	  }
  },
  VERSION{
	  //实现抽象接口方法
	  String getInfo(){
		  return System.getProperty("java.version");
	  }
	  //重写方法
	  void print(){
		  System.out.println("重写了"+this);
	  }
  };
  abstract String getInfo();
  void print(){
	  System.out.println(this);
  }
  public static void main(String args[]){
	  for(ConstantSpecificMethod c: ConstantSpecificMethod.values()){
		  c.print();
		  System.out.println(c.getInfo());
	  }
  }
  /**
   * 在面向对象设计中，不同的行为与不同的类关联。而通过常量相关的方法，
   * 每个enum实例可以具备自己独特的行为，说明每个enum实例就像一个独特的类。
   * 在调用getInfo()方法时，体现了多态。
   */
}
