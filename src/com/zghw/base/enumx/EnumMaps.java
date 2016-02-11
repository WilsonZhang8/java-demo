package com.zghw.base.enumx;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap和枚举的使用
 * EnumMap是一种特殊的Map，它要求其中的键(key)必须来值一个enum
 * 我们只能使用enum的实例作为键来调用put()方法，其他操作与使用一般的Map差不多
 * 下面演示了命令设计模式的用法。
 * 一般来说，命令模式首先需要一个只有但以方法的接口，然后从该接口实现具有各自不同的行为的多个子类。
 * 接下来，程序员就可以构造命令对象，并在需要的时候使用它们。
 * @author zghw
 *
 */
interface Command{
	void action();
}
public class EnumMaps {
	public static void main(String[] args) {
		//创建
		EnumMap<AlarmPoints,Command> apMap = new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
		//厨房放入一个报警器  添加
		apMap.put(AlarmPoints.KITCHEN, new Command(){
			@Override
			public void action() {
				System.out.println("Kitchen fire");
			}
		});
		//卫生间放入一个报警器  添加
		apMap.put(AlarmPoints.BATHROOM, new Command(){
			@Override
			public void action() {
				System.out.println("bathroom alert");
			}
		});
		for(Map.Entry<AlarmPoints, Command> e:apMap.entrySet()){
			//取得key
			System.out.println(e.getKey());
			//取得value
			e.getValue().action();
		}
		
		apMap.get(AlarmPoints.OFFICE1).action();;//如果没有存入到map中，取得的实例为null。
		//优点：EnumMap允许程序员改变值对象，而常量相关的方法在编译器就被固定了。
	}

}
