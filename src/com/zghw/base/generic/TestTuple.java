package com.zghw.base.generic;

import java.util.Date;

/**
 * 仅一次方法调用就能返回多个对象，在开发中经常碰到。 可是return语句只允许返回单个对象，因此，解决办法就是创建一个对象，用它来持有想要返回的多个
 * 对象。可以在每次需要的时候，专门创建一个类来完成这样的工作。
 * 使用元组，只需要定一个长度时适合的元组，将其作为方法的返回值，然后在return语句中创建该元组， 并返回即可。
 * 
 * @author zghw
 *
 */
public class TestTuple {
	static TwoTuple<Integer,String> returnTwoParam(){
		return new TwoTuple<Integer,String>(22,"ss");
	}
	static ThreeTuple<Integer,Develop,Date> returnThreeParam(){
		return new ThreeTuple<Integer,Develop,Date>(22,new Develop(),new Date());
	}
	public static void main(String[] args) {
		System.out.println(returnTwoParam());
		System.out.println(returnThreeParam());
	}

}
