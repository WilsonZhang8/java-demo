package com.zghw.pattern.strategy;

public class FlyWithRocket implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("我有火箭加速");
	}

}
