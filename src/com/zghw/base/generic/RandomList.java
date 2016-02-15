package com.zghw.base.generic;

import java.util.ArrayList;
import java.util.Random;

/**
 * 随机选取一个元素
 * 
 * @author zghw
 *
 * @param <T>
 */
public class RandomList<T> {
	private ArrayList<T> stroage = new ArrayList<T>();
	private Random random = new Random(47);

	/**
	 * 随机选取一个类型实例
	 */
	public T select() {
		return stroage.get(random.nextInt(stroage.size()));
	}

	public void add(T item) {
		stroage.add(item);
	}

	public static void main(String[] args) {
		RandomList<String> rl = new RandomList<String>();
		for (String s : "// TODO Auto-generated method stub".split(" ")) {
			rl.add(s);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(rl.select());
		}
	}

}
