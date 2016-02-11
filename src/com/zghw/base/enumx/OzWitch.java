package com.zghw.base.enumx;
/**
 * 枚举中使用构造函数 方法 字段 可以使用main方法
 * 除了枚举实例外，enum和类的结构基本都一样，可以使用enum做很多事情
 * @author zghw
 *
 */
public enum OzWitch {
	EAST("postion east",System.currentTimeMillis()-11,11),//类似使用构造函数进行enum实例化
	WEST("postion west",System.currentTimeMillis()-22,22),//类似使用构造函数进行enum实例化
	SOUTH("postion south",System.currentTimeMillis()-33,33),//类似使用构造函数进行enum实例化
	NORTH("postion north",System.currentTimeMillis()-44,44);
	//如果枚举使用了字段 构造函数 方法等 必须enum实例在前，必须以 ; 结束
	private String description;
	private Long currentTime;
	private int flag;
	//枚举中使用
	
	//因为枚举无法实例化 使用私有的构造方法合理 
	private OzWitch(String description,Long currentTime,int flag){
		this.description = description;
		this.currentTime = currentTime;
		this.flag = flag;
	}
	//普通方法
	public void printInfo(){
		System.out.println(this.description +" -- "+this.currentTime+" -- "+this.flag);
	}
	
	//使用main方法
	public static void main(String args[]){
		for(OzWitch o : OzWitch.values()){
			o.printInfo();
		}
	}
}
