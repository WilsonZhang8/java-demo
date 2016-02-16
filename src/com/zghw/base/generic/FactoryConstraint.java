package com.zghw.base.generic;

/**
 * 使用简单工厂来创建泛型T 建议创建泛型对象使用此方法
 * 
 * @author zghw
 *
 */
interface Factory<T> {
	T creat();
}

class IntegerGen implements Factory<Integer> {

	@Override
	public Integer creat() {
		return new Integer(0);// 由于Integer没有默认构造方法，无法使用Class创建泛型实例
	}

}

class Widget {
	public static class FactoryInner implements Factory<Widget> {

		@Override
		public Widget creat() {
			return new Widget();
		}

	}
}

class Foo<T> {
	private T x;

	public <F extends Factory<T>> Foo(F factory) {
		x = factory.creat();
	}

	public T get() {
		return x;
	}
}

public class FactoryConstraint {
	public static void main(String[] args) {
		Integer i = new Foo<Integer>(new IntegerGen()).get();
		Widget w = new Foo<Widget>(new Widget.FactoryInner()).get();

	}

}
