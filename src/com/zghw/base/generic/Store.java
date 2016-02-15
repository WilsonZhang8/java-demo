package com.zghw.base.generic;

import java.util.ArrayList;
import java.util.Random;

import com.zghw.base.Generator;

/**
 * 使用泛型构建商店模型
 * 
 * @author zghw
 *
 */
// 商品
class Product {
	private int id;
	private String desc;
	private double price;

	public Product(int id, String desc, double price) {
		this.id = id;
		this.desc = desc;
		this.price = price;
		System.out.println(this);
	}

	public String toString() {
		return id + " : " + desc + " " + price;
	}

	public static Generator<Product> gen = new Generator<Product>() {
		Random random = new Random(47);

		@Override
		public Product next() {
			return new Product(random.nextInt(1000), "test", Math.round(random
					.nextDouble() * 1000.0) + 0.99);
		}
	};
}

// 货架
class Self extends ArrayList<Product> {
	public Self(int nproduct) {
		Generators.fill(this, Product.gen, nproduct);
	}
}

// 走廊
class Ailse extends ArrayList<Self> {
	public Ailse(int nself, int nproduct) {
		for (int i = 0; i < nself; i++) {
			add(new Self(nproduct));
		}
	}
}

public class Store extends ArrayList<Ailse> {
	public Store(int nailse, int nself, int nproduct) {
		for (int i = 0; i < nailse; i++) {
			add(new Ailse(nself, nproduct));
		}
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Ailse a : this) {
			for (Self s : a) {
				for (Product p : s) {
					result.append(p);
					result.append("\n");
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Store store = new Store(1, 2, 2);
		System.out.println(store);
	}

}
