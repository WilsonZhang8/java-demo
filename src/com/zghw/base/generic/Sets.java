package com.zghw.base.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * 数学关系式 交集 并集 合集
 * 
 * @author zghw
 *
 */
public class Sets {
	/**
	 * 合集
	 */
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> reslut = new HashSet<T>(a);
		reslut.addAll(b);
		return reslut;
	}

	/**
	 * 交集
	 */
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> reslut = new HashSet<T>(a);
		reslut.retainAll(b);
		return reslut;
	}

	/**
	 * 补集
	 */
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}

	/**
	 * 除了交集
	 */
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> reslut = new HashSet<T>(superset);
		reslut.removeAll(subset);
		return reslut;
	}
}
