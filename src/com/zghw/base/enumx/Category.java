package com.zghw.base.enumx;
import static com.zghw.base.enumx.Input.*;

import java.util.EnumMap;
/**
 * 输入进行分类
 * @author zghw
 *
 */
public enum Category {
	MONEY(NICKE,DIME,QUARTER,DOLLAR),
	ITEM_SELECTION(TOOTHPASTE, CHIPS,SODA,SOAP),
	QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
	private Input[] categories;
	private Category(){}
	private Category(Input... categories){
		this.categories = categories;
	}
	//获取分类对象表
	public static EnumMap<Input,Category> getCategoryMap(){
		EnumMap<Input,Category> categoryMap=new EnumMap<Input,Category>(Input.class);
		for(Category c: Category.values()){
			for(Input i:c.categories){
				categoryMap.put(i, c);
			}
		}
		return categoryMap;
	}
	//根据输入获取分类
	public static Category get(Input input){
		return getCategoryMap().get(input);
	}
}
