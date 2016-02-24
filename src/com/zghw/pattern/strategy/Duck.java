package com.zghw.pattern.strategy;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("游泳");
	}

	abstract void display();

	public void setFlyBehaior(FlyBehavior flyBehaior) {
		this.flyBehavior = flyBehaior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

}
