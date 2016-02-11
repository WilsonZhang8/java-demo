package com.zghw.base.enumx;

import java.util.EnumSet;

/**
 * 洗车服务菜单实例
 * 
 * @author zghw
 *
 */
public class CarWash {
	public enum Cycle {
		UNDERBODY {
			void action() {
				System.out.println(this);
			}
		},
		WHEELWASH {
			void action() {
				System.out.println(this);
			}
		},
		PERWASH {
			void action() {
				System.out.println(this);
			}
		},
		BASIC {
			void action() {
				System.out.println(this);
			}
		},
		HOTWAX {
			void action() {
				System.out.println(this);
			}
		},
		RINSE {
			void action() {
				System.out.println(this);
			}
		},
		BLOWDRY {
			void action() {
				System.out.println(this);
			}
		};
		abstract void action();
	}
	EnumSet<Cycle> cs = EnumSet.of(Cycle.BASIC, Cycle.RINSE);
	public void add(Cycle cw) {
		cs.add(cw);
	}

	public void washCar() {
		for (Cycle c : cs) {
			c.action();
		}
	}

	public String toString() {
		return cs.toString();
	}

	public static void main(String[] args) {
		CarWash cc = new CarWash();
		System.out.println(cc);
		cc.add(Cycle.BLOWDRY);
		System.out.println(cc);
		cc.add(Cycle.PERWASH);
		cc.add(Cycle.WHEELWASH);
		cc.add(Cycle.BASIC);
		cc.add(Cycle.BLOWDRY);
		System.out.println(cc);
		// 向EnumSet中添加的顺序并不重要，因为输出的次序决定于enum实例定义时的次序
		cc.washCar();

	}

}
