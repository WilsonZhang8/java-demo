package com.zghw.base.enumx;

import java.util.Random;

import com.zghw.base.Generator;

/**
 * enum无法继承 但可以实现一个或多个接口
 * 枚举和接口的使用
 * @author zghw
 *
 */
enum CartoonCharacter implements Generator<CartoonCharacter>{
	SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;

	Random random = new Random(47);
	@Override
	public CartoonCharacter next() {
		return values()[random.nextInt(values().length)];
	}
}
public class EnumImplementaion {
	public static <T> void printNext(Generator<T> rg){
		System.out.print(rg.next()+" . ");
	}
	public static void main(String args[]){
		for(CartoonCharacter c : CartoonCharacter.values()){
			//EnumImplementaion.printNext(c);
			printNext(c);
		}
		System.out.println();
		
		CartoonCharacter cc= CartoonCharacter.BOUNCY;
		for(int i=0;i<10;i++){
			printNext(cc);
		}
		//这个结果有点奇怪，必须要有一个enum实例才能调用其上的方法
		//BOB . BOB . BOB . BOB . BOB . BOB . BOB . 
		//PUNCHY . BOB . SPANKY . NUTTY . PUNCHY . SLAPPY . NUTTY . NUTTY . SLAPPY . PUNCHY .
	}
}
