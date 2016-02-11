package com.zghw.base.enumx;
/**
 * 使用枚举组合提供一份菜单例子
 * 枚举中的枚举例子
 * @author zghw
 *
 */
public enum Meal {
	APPETIZER(Food.Appetizer.class),
	MAINCOURSE(Food.MainCourse.class),
	DESSERT(Food.Dessert.class),
	COFFEE(Food.Coffee.class);
	private Food[] foods;
	private Meal(Class<? extends Food> food){
		foods=food.getEnumConstants();
	}
	public Food getFood(){
		return Enums.values(foods);
	}
	/**
	 * 使用接口组织枚举
	 * 在一个接口的内部，创建该接口的枚举，以此将元素进行分组，可以达到将枚举元素
	 * 分类组织的目的
	 * @author zghw
	 */
	public interface Food {
		enum Appetizer implements Food{
			SALAD,SOUP,SPRING_ROLLS;
		}
		enum MainCourse implements Food{
			LASAGNE,BURRITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
		}
		enum Dessert implements Food{
			TIRAMISU,GELATO,BLACK_FOREST_CAKE,FRUIT,CREME_CARAMEL;
		}
		enum Coffee implements Food{
			BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,LATTE,CAPPUCCINO,TEA,HERB_TEA;
		}
	}
	public static void main(String[] args) {
		for(int i=0 ; i<5; i++){
			for(Meal c :Meal.values()){
				System.out.println(c.getFood());
			}
			System.out.println("----------");
		}
	}
}
