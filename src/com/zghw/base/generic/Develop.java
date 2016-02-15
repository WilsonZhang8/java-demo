package com.zghw.base.generic;

/**
 * 泛型的演变
 * 
 * @author zghw
 *
 */
public class Develop {
	class Automobile {
	}

	// Holder1直接指明了持有对象的类型
	class Holder1 {
		private Automobile automobile;

		public Holder1(Automobile automobile) {
			this.automobile = automobile;
		}

		public void set(Automobile automobile) {
			this.automobile = automobile;
		}

		public Automobile get() {
			return automobile;
		}
	}

	// Holder2使用Object作为持有对象的类型更加泛化。
	class Holder2 {
		private Object obj;

		public Holder2(Object obj) {
			this.obj = obj;
		}

		public void set(Object obj) {
			this.obj = obj;
		}

		public Object get() {
			return obj;
		}
	}

	// 暂时不指定类型，稍后在决定具体使用的类型，需要使用类型参数
	class Holder3<T> {
		private T t;

		public Holder3(T t) {
			this.t = t;
		}

		public void set(T t) {
			this.t = t;
		}

		public T get() {
			return t;
		}
	}

	public static void main(String[] args) {
		Develop de = new Develop();
		// 使用Holder2可以设置不同的类型对象，
		// 通常我们使用容器来存储一种类型对象
		Holder2 h2 = de.new Holder2(de.new Automobile());
		h2 = de.new Holder2("1122");
		h2.set(123);
		h2.set(de.new Automobile());
		Automobile a = (Automobile) h2.get();// 明确需要类型转换
		//
		Holder3<Automobile> h3 = de.new Holder3<Automobile>(de.new Automobile());

		Automobile aa = h3.get();// 自动地转换为正确类型
	}

}
