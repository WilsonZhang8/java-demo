package com.zghw.base.enumx;
//通过使用import static能够将enum实例的标识符带入当前的命名空间
import static com.zghw.base.enumx.Spiciness.*;
/**
 * 枚举的简单使用
 * @author zghw
 *
 */
public class SimpleEnumUse {
	private Spiciness degree;
	
	public SimpleEnumUse(Spiciness degree){
		this.degree = degree;
	}
	/**
	 * 由于switch取值有限，和enum一起使用是绝配
	 */
	public void choise(){
		System.out.println("choise use");
		switch(degree){
			case NOT:System.out.println("not ");break;
			case HOT:System.out.println("hot");break;
			case MILD:
			case MEDIUM:
			default:System.out.println("defalut");
		}
	}
	
	
	public static void main(String args[]){
		//使用枚举
		Spiciness hot = Spiciness.HOT;
		//编译器自动把toString方法输出enum实例名称
		System.out.println(hot);
		//方法values()产生由这些常量构成的数组
		for(Spiciness sp:Spiciness.values()){
			//ordinal方法某个特定enum常量的声明排序
			System.out.println( sp +" ordinal ="+sp.ordinal());
		}
		SimpleEnumUse h=new SimpleEnumUse(Spiciness.HOT);
		//通过使用import static能够将enum实例的标识符带入当前的命名空间，所以无需像上面
		//用enum类型来修饰enum实例
		SimpleEnumUse f=new SimpleEnumUse(FLAMING);
		SimpleEnumUse m=new SimpleEnumUse(MEDIUM);
		h.choise();
		f.choise();
		m.choise();
	}
}
