package com.zghw.base.enumx;

import java.util.Random;

/**
 * 随机取得enum中的一个enum实例工具类
 * 枚举和泛型的使用
 * @author zghw
 *
 */
public class Enums {
	private static  Random random = new Random(47);
	/**
	 * 随机取得enum中的一个enum实例
	 * @param ec
	 * @return
	 */
	public static  <T extends Enum<T>> T next(Class<T> ec){
		//1.得到枚举列表
		T[] enums= ec.getEnumConstants();
		//2.根据枚举长度计算取得一个随机数
		int ran = random.nextInt(enums.length);
		//3.使用随机数作为枚举列表坐标取得一个随机枚举实例
		return enums[ran];
	}
	/**
	 * 随机取得enum中的一个enum实例
	 * @param ec
	 * @return
	 */
	public static  <T> T values(T[] ec){
		return ec[random.nextInt(ec.length)];   
	}
}
