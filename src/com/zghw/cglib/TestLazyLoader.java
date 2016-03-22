package com.zghw.cglib;

public class TestLazyLoader {

	public static void main(String[] args) {
		//LazyLoader 只在属性对象访问它对应的get方法时才加载，实现懒加载
		//加载完一次，以后就不加载了。
		LazyBean lazyBean = new LazyBean("zhangsan",25);
		lazyBean.getAge();
		lazyBean.getName();
		PropertyBean pb1=lazyBean.getPropertyBean();
		System.out.println("得到PropertyBean");
		pb1.getKey();
		System.out.println("使用PropertyBean的get属性值，才加载该对象，真正实现懒加载");
		pb1.getValue();
		System.out.println("加载完一次，第二次就不加载了");
		//Dispatcher 每次都懒加载
		PropertyBean pbd1=lazyBean.getPropertyBeanDispatcher();
		System.out.println("得到PropertyBean");
		pbd1.getKey();
		System.out.println("使用PropertyBean的get属性值，才加载该对象，真正实现懒加载");
		pbd1.getValue();
		System.out.println("Dispatcher每次都是懒加载");
	}

}
