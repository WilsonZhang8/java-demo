package com.zghw.base.enumx;

/**
 * 使用枚举组合提供一份菜单例子
 * 枚举中的枚举例子
 * @author zghw
 *
 */
enum Course{
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	private Food[] foods;
	private Course(Class<? extends Food> food){
		foods=food.getEnumConstants();
	}
	/**
	 * 随机取得一种枚举中的枚举food
	 * @return
	 */
	public Food getFood(){
		return Enums.values(foods);
	}
}
public class Meal1 {
	public static void main(String[] args) {
		for(int i=0 ; i<5; i++){
			//得到一份组合菜单
			for(Course c :Course.values()){
				System.out.println(c.getFood());
			}
			System.out.println("----------");
		}
	}

}
