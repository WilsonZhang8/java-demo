package com.zghw.base.enumx;

import static com.zghw.base.enumx.VendingMachine.StateDuration.TRANSIENT;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 自动售货机 责任链和状态模式
 * 
 * @author zghw
 *
 */
public class VendingMachine {

	// 当前自动售货机处理的状态
	private static State state = State.RESTRING;
	// 当前输入
	private static Input selection = null;
	// 花费钱统计
	private static int amount = 0;

	enum StateDuration {
		// 持续状态 1.瞬时
		TRANSIENT
	};

	enum State {
		// 五种状态 1.重置2.付款3.系统配置4.取消5.终端
		RESTRING {
			public void next(Input input) {
				switch (Category.get(input)) {
				case MONEY:
					amount += input.getValue();
					state = ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
					break;
				default:
					break;

				}
			}
		},
		ADDING_MONEY {
			public void next(Input input) {
				switch (Category.get(input)) {
				case MONEY:
					amount += input.getValue();
					break;
				case ITEM_SELECTION:
					selection = input;
					if (amount < selection.getValue()) {
						System.out.println("不够支付" + selection);
					} else {
						state = DISPENSING;
					}
					break;
				case QUIT_TRANSACTION:
					state = GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
					break;
				default:
					break;
				}
			}
		},
		DISPENSING(TRANSIENT) {
			public void next() {
				System.out.println("你选择的是：" + selection);
				amount -= selection.getValue();
				state = GIVING_CHANGE;
			}
		},
		GIVING_CHANGE(TRANSIENT) {
			public void next() {
				if (amount > 0) {
					System.out.println("变成" + amount);
					amount = 0;
				}
				state = RESTRING;
			}
		},
		TERMINAL {
			void output() {
				System.out.println("终止");
			}
		};
		// 售货机在处理中
		private boolean isTransient = false;

		// 使用构造函数巧妙的设置了状态是瞬时的还是持续的
		private State() {
		}

		private State(StateDuration sd) {
			isTransient = true;
		}

		// 进入下一个状态
		public void next() {
			throw new RuntimeException("不用实现");
		}

		// 进入输入对应的下一个状态
		public void next(Input input) {
			throw new RuntimeException("不用实现");
		}

		void output() {
			System.out.println(amount);
		}
	}

	// 运行
	public static void run(Generator<Input> gi) {
		// 没有显示终端则继续运行
		while (state != State.TERMINAL) {
			state.next(gi.next());
			// 瞬时状态继续运行
			while (state.isTransient) {
				// 进入下一个状态
				state.next();
			}
			state.output();
		}
	}

	public static void main(String args[]) {
		Generator<Input> gi = new RandomInputGenerator();
		String fileName = "QUARTER;QUARTER;QUARTER;CHIPS;DOLLAR;DOLLAR;TOOTHPASTE;QUARTER;DIME;ABORT_TRANSACTION;QUARTER;DIME;SODA;QUARTER;DIME;NICKE;SODA;ABORT_TRANSACTION;STOP";
		gi = new FileInputGenerator(fileName);
		run(gi);
	}

}

class RandomInputGenerator implements Generator<Input> {
	@Override
	public Input next() {
		return Input.randomSelect();
	}

}
class FileInputGenerator implements Generator<Input> {
	//迭代器适合下一个
	private Iterator<String> input;

	public FileInputGenerator(String fileName) {
		//数组转换为集合 集合转换为迭代器
		input = Arrays.asList(fileName.split(";")).iterator();
	}

	@Override
	public Input next() {
		if (input.hasNext()) {
			return Enum.valueOf(Input.class, input.next());
		}
		return null;
	}

}
