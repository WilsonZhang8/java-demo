package com.zghw.pattern.strategy;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}

	@Override
	void display() {
		System.out.println("look like decoy duck!");
	}

}
