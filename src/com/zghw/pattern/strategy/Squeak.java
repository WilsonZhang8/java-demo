package com.zghw.pattern.strategy;

public class Squeak implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("只只只");
	}

}
