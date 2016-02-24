package com.zghw.pattern.strategy;

public class TestDuckBehavior {

	public static void main(String[] args) {
		Duck duck =new DecoyDuck();
		duck.performFly();
		duck.performQuack();
		duck.setQuackBehavior(new Squeak());
		duck.setFlyBehaior(new FlyWithRocket());
		duck.performFly();
		duck.performQuack();
	}

}
