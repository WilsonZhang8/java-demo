package com.zghw.base.enumx;

public class RoShamBo {

	/**
	 * 玩游戏
	 * @param ec
	 * @param size
	 */
	public static <T extends Enum<T> & Competitor<T>> void play(Class<T> ec,int size){
		for(int i=0;i<size;i++){
			match(Enums.next(ec),Enums.next(ec));
		}
	}
	/**
	 * 比赛
	 * @param a
	 * @param b
	 */
	public static <T extends Enum<T> & Competitor<T>> void match(T a ,T b){
		System.out.println(a + " vs " + b + " == " + a.competitor(b));
	}
}
