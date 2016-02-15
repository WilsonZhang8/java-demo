package com.zghw.base.generic;

import java.util.Iterator;
import java.util.Random;

import com.zghw.base.Generator;
import com.zghw.base.generic.coffee.Americano;
import com.zghw.base.generic.coffee.Breve;
import com.zghw.base.generic.coffee.Cappuccino;
import com.zghw.base.generic.coffee.Coffee;
import com.zghw.base.generic.coffee.Latte;
import com.zghw.base.generic.coffee.Mocha;

/**
 * 泛型接口的使用 随机生成不同的子类对象 Iterable迭代器使用
 * 
 * @author zghw
 *
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	// 使用类型信息数组存储类信息
	private Class<?>[] types = new Class<?>[] { Breve.class, Americano.class,
			Latte.class, Mocha.class, Cappuccino.class };
	private Random random = new Random(47);
	private int size = 0;

	public CoffeeGenerator() {
	}

	public CoffeeGenerator(int size) {
		this.size = size;
	}

	@Override
	public Coffee next() {
		try {// 随机取得Coffee实现类实例对象
			return (Coffee) types[random.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator();
	}

	class CoffeeIterator implements Iterator<Coffee> {
		int count = size;

		@Override
		public boolean hasNext() {
			return count > 0;
		}

		@Override
		public Coffee next() {
			count--;// 内部类调用外部类方法
			return CoffeeGenerator.this.next();
		}

		@Override
		public void remove() {
		}
	}

	public static void main(String[] args) {
		CoffeeGenerator cg = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(cg.next());
		}
		for (Coffee c : new CoffeeGenerator(3)) {
			System.out.println(c);
		}
	}

}
