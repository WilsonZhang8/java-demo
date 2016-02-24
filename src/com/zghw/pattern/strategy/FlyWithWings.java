package com.zghw.pattern.strategy;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("我有翅膀我会飞");

	}

}
