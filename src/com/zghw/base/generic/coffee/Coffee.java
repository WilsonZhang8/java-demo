package com.zghw.base.generic.coffee;

public class Coffee {
	//static + final 联合使用 全局计数器
	private static int counter=0;
	private final int id=counter++;
	public String toString(){
		return  getClass().getSimpleName()+" 创建实例数量："+id;
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			Coffee c =new Coffee();
			System.out.println(c);
		}
	}

}
