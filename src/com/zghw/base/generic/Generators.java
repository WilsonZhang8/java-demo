package com.zghw.base.generic;

import java.util.ArrayList;
import java.util.Collection;

import com.zghw.base.Generator;
import com.zghw.base.generic.coffee.Coffee;

/**
 * 利用生成器，填充一个Collection，泛化这种操作很有意义
 * 
 * @author zghw
 *
 */
public class Generators {

	/**
	 * 向容器中填充对象
	 * 
	 * @param coll
	 *            容器
	 * @param gen
	 *            对象生成器
	 * @param size
	 *            数量
	 * @return
	 */
	public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen,
			int size) {
		for (int i = 0; i < size; i++) {
			coll.add(gen.next());
		}
		return coll;
	}

	public static void main(String[] args) {
		Collection<Coffee> cc = fill(new ArrayList<Coffee>(),
				new CoffeeGenerator(), 5);
		for (Coffee c : cc) {
			System.out.println(c);
		}
	}

}
