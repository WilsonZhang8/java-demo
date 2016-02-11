package com.zghw.base.enumx;

import static com.zghw.base.enumx.Outcome.*;

import java.util.Random;

/**
 * 使用接口和度哟个子类进行多路分发
 * 
 * 石头、剪刀、布 游戏
 * 
 * @author zghw
 *
 */
//Item是这几种类型的接口，将会被用作多路分发
interface Item {
	//调用Item.compete()方法开始两路分发
	Outcome compete(Item item);

	Outcome eval(Rock rock);

	Outcome eval(Scissors scissors);

	Outcome eval(Paper paper);

}

class Rock implements Item {
	//调用Item.compete()方法开始两路分发
	//compete()方法通过调用eval()来为另一个类型实现第二次分发。
	//将自身（this）作为参数调用eval(),能够调用重载过的eval()方法，
	//能够保留第一次分发的类型信息。当第二次分发完成时，你就能够知道两个Item对象的具体类型了。
	@Override
	public Outcome compete(Item item) {
		return item.eval(this);
	}

	@Override
	public Outcome eval(Rock rock) {
		return DRAW;
	}

	@Override
	public Outcome eval(Scissors scissors) {
		return LOSE;
	}

	@Override
	public Outcome eval(Paper paper) {
		return WIN;
	}

	@Override
	public String toString() {
		return "Rock";
	}
}

class Scissors implements Item {
	@Override
	public Outcome compete(Item item) {
		return item.eval(this);
	}

	@Override
	public Outcome eval(Rock rock) {
		return WIN;
	}

	@Override
	public Outcome eval(Scissors scissors) {
		return DRAW;
	}

	@Override
	public Outcome eval(Paper paper) {
		return LOSE;
	}

	@Override
	public String toString() {
		return "Scissors";
	}
}

class Paper implements Item {

	@Override
	public Outcome compete(Item item) {
		return item.eval(this);
	}

	@Override
	public Outcome eval(Rock rock) {
		return LOSE;
	}

	@Override
	public Outcome eval(Scissors scissors) {
		return WIN;
	}

	@Override
	public Outcome eval(Paper paper) {
		return DRAW;
	}

	@Override
	public String toString() {
		return "Paper";
	}
}

public class RoShamBo1 {

	public static void play(Item a, Item b) {
		//调用Item.compete()方法开始两路分发。要判断a的类型，
		//分发机制会在a的时机类型的compete()内部起到分发的作用。
		System.out.println(a + " vs " + b + " == " + a.compete(b));
	}

	static Random random = new Random(47);

	public static Item newItem() {
		switch (random.nextInt(3)) {
		case 0:
			return new Rock();
		case 1:
			return new Scissors();
		case 2:
			return new Paper();
		default:
			return null;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			play(newItem(), newItem());
		}
	}

}
