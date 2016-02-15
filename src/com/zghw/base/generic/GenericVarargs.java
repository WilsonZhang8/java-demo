package com.zghw.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法与可变参数使用
 * @author zghw
 *
 */
public class GenericVarargs {
	public static <T> List<T> makeList(T... args ){
		List<T> ls = new ArrayList<T>();
		for(T t: args){
			ls.add(t);
		}
		return ls;
	}
	public static void main(String[] args) {
		List<String> ls = GenericVarargs.makeList("11","22","33");
		System.out.println(ls);
		ls=GenericVarargs.makeList("A B C D E F G H I J K L M N O P Q".split(" "));
		System.out.println(ls);
	}

}
