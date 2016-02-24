package com.zghw.pattern.strategy;

public class MallarDuck extends Duck {
	public MallarDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Squeak();
	}
	@Override
	void display() {
		System.out.println("look like mallar duck");

	}

}
