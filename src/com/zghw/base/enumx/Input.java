package com.zghw.base.enumx;

import java.util.Random;

/**
 * 售卖机所有输入
 * 
 * @author zghw
 *
 */
public enum Input {
	NICKE(15),DIME(10),QUARTER(25),DOLLAR(100),
	TOOTHPASTE(200),CHIPS(75),SODA(100),SOAP(50),
	ABORT_TRANSACTION {
		// 重写getValue()方法
		public int getValue() {
			throw new RuntimeException("transaction no value");
		}
	},
	STOP {
		public int getValue() {
			throw new RuntimeException("had stop no value");
		}
	};
	// 输入对应的价格值
	private int value;

	private Input(int value) {
		this.value = value;
	}

	// 枚举对应的多个构造函数
	private Input() {
	}

	// 取得对应的价格
	public int getValue() {
		return value;
	}

	static Random random = new Random(47);

	// 随机选择一个输入,由于STOP不是一个输入，所以随机值减少STOP
	public static Input randomSelect() {
		return values()[random.nextInt(values().length - 1)];
	}
}
