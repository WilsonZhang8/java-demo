package com.zghw.pattern.proxy;

public class RealSubject implements Subject {

	@Override
	public void rent() {
		System.out.println("rent");
	}

	@Override
	public String hello(String str) {
		System.out.println("hello"+str);
		return str;
	}

}
