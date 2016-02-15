package com.zghw.base;

import com.zghw.base.generic.coffee.Coffee;

/**
 * 为任意类构造一个Generator 满足条件： （1）必须声明为public （2）具备默认的构造函数
 * 
 * @author zghw
 *
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;

	public BasicGenerator(Class<T> type) {
		this.type = type;
	}

	@Override
	public T next() {
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public static <T> BasicGenerator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}

	public static void main(String args[]) {
		Generator<Coffee> gr = BasicGenerator.create(Coffee.class);
		for (int i = 0; i < 5; i++) {
			System.out.println(gr.next());
		}
	}
}
