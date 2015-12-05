package com.zghw.base.staticx;

public class Table {
	private static Bowl bowl1=new Bowl(1);
	
	public Table(){
		System.out.println("Table");
		bowl2.f1(1);
	}
	
	public void f2(int marker) {
		System.out.println("f2 " + marker);
	}
	private static Bowl bowl2=new Bowl(2);
}
