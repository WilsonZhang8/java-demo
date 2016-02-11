package com.zghw.base.enumx;

import java.util.EnumSet;

/**
 * EnumSet集合管理枚举实例的使用例子
 * @author zghw
 *
 */
enum AlarmPoints{
	//传感器安放位置
	STAIR1,STAIR2,LOBBY,OFFICE1,OFFICE2,OFFICE3,OFFICE4,BATHROOM,UTILITY,KITCHEN;
}
/**
 * 跟踪报警器的位置
 * @author zghw
 *
 */
public class EnumSets {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> apSet=EnumSet.noneOf(AlarmPoints.class);//创建一个空的枚举集合
		apSet.add(AlarmPoints.BATHROOM);//向集合中添加一个enum实例
		System.out.println(apSet);
		//向集合中一次添加多个enum实例
		apSet.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println(apSet);
		//一次添加所有的enum实例到集合中
		apSet=EnumSet.allOf(AlarmPoints.class);
		System.out.println(apSet);
		//向集合中一次删除多个enum实例
		apSet.removeAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2,AlarmPoints.KITCHEN));
		System.out.println(apSet);
		//删除集合中 从OFFICE1到OFFICE4的实例
		apSet.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println(apSet);
		//在enum全部实例中，不存在apSet集合中的其他实例作为一个集合
		apSet = EnumSet.complementOf(apSet);
		System.out.println(apSet);
	}

}
