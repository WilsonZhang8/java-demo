package com.zghw.base.enumx;

import com.zghw.base.enumx.Food.Appetizer;
import com.zghw.base.enumx.Food.Coffee;
import com.zghw.base.enumx.Food.Dessert;
import com.zghw.base.enumx.Food.MainCourse;

public class TypeOfFood {
	public static void main(String args[]){
		//如果enum类型实现了Food接口，可以将实例向上转型为Food
		Food food = Appetizer.SALAD;
		food = MainCourse.BURRITO;
		food = Dessert.CREME_CARAMEL;
		food = Coffee.ESPRESSO;
	}
}
