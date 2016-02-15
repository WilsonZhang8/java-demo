package com.zghw.base.generic;

import java.lang.reflect.Method;
import java.util.*;

/**
 * java.util包中各种Collection类与Map类之间的方法差异
 * 
 * @author zghw
 *
 */
public class ContainerMethodDifferences {
	private static Set<String> objSet = methods(Object.class);// Object对象的方法集合

	/**
	 * 取得类对应的方法集合
	 * 
	 * @return
	 */
	public static Set<String> methods(Class<?> type) {
		Set<String> set = new HashSet<String>();
		for (Method m : type.getMethods()) {
			set.add(m.getName());
		}
		return set;
	}

	public static void interfaces(Class<?> type) {
		System.out.println("Interfaces in " + type.getSimpleName());
		List<String> list = new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			list.add(c.getSimpleName());
		}
		System.out.println(list);
	}

	public static void different(Class<?> subClass, Class<?> superClass) {
		System.out.println(subClass.getSimpleName() + " extends "
				+ superClass.getSimpleName() + " adds:");
		Set<String> diff = Sets.difference(methods(superClass),
				methods(subClass));
		diff.removeAll(objSet);// 去掉Object的方法
		System.out.println("= " + diff + "=");
		interfaces(superClass);
	}

	public static void main(String args[]) {
		System.out.println("Collection: " + methods(Collection.class));
		interfaces(Collection.class);
		different(Set.class, Collection.class);
		different(HashSet.class, Set.class);
		different(LinkedHashSet.class, HashSet.class);
		different(TreeSet.class, Set.class);
		different(List.class, Collection.class);
		different(ArrayList.class, List.class);
		different(LinkedList.class, List.class);
		different(Queue.class, Collection.class);
		different(PriorityQueue.class, Queue.class);
		System.out.println("Map: " + methods(Map.class));
		different(HashMap.class, Map.class);
		different(LinkedHashMap.class, HashMap.class);
		different(SortedMap.class, Map.class);
		different(TreeMap.class, Map.class);
	}
}
