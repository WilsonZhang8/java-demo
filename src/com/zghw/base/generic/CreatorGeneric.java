package com.zghw.base.generic;

/**
 * 使用模板方法创建泛型实例
 * 
 * @author zghw
 *
 */
abstract class GenericWithCreator<T> {
	final T element;

	public GenericWithCreator() {
		element = creat();
	}

	abstract T creat();
}

class Obj {
}

class Creator extends GenericWithCreator<Obj> {
	@Override
	Obj creat() {
		return new Obj();
	}

	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}

public class CreatorGeneric {
	public static void main(String[] args) {
		new Creator().f();
	}

}
