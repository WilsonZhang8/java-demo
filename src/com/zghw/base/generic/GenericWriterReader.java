package com.zghw.base.generic;

import java.util.*;

/**
 * 通配符 ？ extends T ? super T 的应用
 * 
 * @author zghw
 *
 */
public class GenericWriterReader {
	static <T> void writeExact(List<T> list, T item) {
		list.add(item);
	}

	static <T> void writeWild(List<? super T> list, T item) {
		list.add(item);
	}

	static <T> T readExact(List<T> list) {
		return list.get(0);
	}

	static class Reader<T> {
		static <T> T readExact(List<T> list) {
			return list.get(0);
		}
	}

	static class ReadWild<T> {
		static <T> T readExact(List<? extends T> list) {
			return list.get(0);
		}
	}

	static List<Fruit> fruitsw = new ArrayList<Fruit>();
	static List<Apple> applesw = new ArrayList<Apple>();
	static List<Fruit> fruits = Arrays.asList(new Fruit());
	static List<Apple> apples = Arrays.asList(new Apple());

	static void w1() {
		writeExact(applesw, new Apple());
		writeExact(fruitsw, new Apple());
	}

	static void w2() {
		writeWild(applesw, new Apple());
		writeWild(fruitsw, new Apple());
	}

	static void r1() {
		Apple a = readExact(apples);
		Fruit f = readExact(fruits);
		f = readExact(apples);
	}

	static void r2() {
		Reader<Fruit> r = new Reader<Fruit>();
		Apple a = r.readExact(apples);
		Fruit f = r.readExact(fruits);
		f = r.readExact(apples);
	}

	static void r3() {
		ReadWild<Fruit> r = new ReadWild<Fruit>();
		Apple a = r.readExact(apples);
		Fruit f = r.readExact(fruits);
		f = r.readExact(apples);
	}

	public static void main(String[] args) {
		w1();
		w2();
		r1();
		r2();
		r3();
	}

}
