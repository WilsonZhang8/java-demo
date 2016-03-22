package com.zghw.base;

import java.util.ArrayList;
import java.util.List;

public class Value {
	private List<Object> list=new ArrayList<Object>();
	private static int pris =11;//private 静态变量 局部
	public int p=2;
	public static int pubs=22;//public 静态变量 全局变量
	int v ;
	public Value(int v){
		this.v=v;
	}
	
	
	public void noStaticMethod(){
		System.out.println("noStaticMethod pris="+pris+" p="+p);
	}
	public static void staticMethod(){
		System.out.println("staticMethod"+"  pubs="+pubs);
	}


	public List<Object> getList() {
		return list;
	}


	public void setList(List<Object> list) {
		this.list = list;
	}
	
}
