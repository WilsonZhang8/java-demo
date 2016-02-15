package com.zghw.base.generic;

/**
 * 如果使用多元组就使用继承来实现
 * 
 * @author zghw
 *
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

	public final C three;

	public ThreeTuple(A first, B second, C three) {
		super(first, second);
		this.three = three;
	}

	public String toString() {
		return super.toString() + " three ";
	}
}
