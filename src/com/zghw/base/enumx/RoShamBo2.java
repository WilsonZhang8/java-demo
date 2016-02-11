package com.zghw.base.enumx;
import static com.zghw.base.enumx.Outcome.*;
/**
 * 使用enum分发
 * 石头、剪刀、布游戏使用enum实现
 * 使用构造器来初始化每个enum实例，并以“一组”结果作为参数。
 * 这二者放在一起，形成了类似查询表的结构。
 * @author zghw
 *
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
	ROCK(DRAW,WIN,LOSE),
	SCISSORS(LOSE,DRAW,WIN),
	PAPER(WIN,LOSE,DRAW);
	private Outcome vrock;
	private Outcome vscissors;
	private Outcome vpaper;

	private RoShamBo2(Outcome rock,Outcome scissors,Outcome paper){
		this.vrock= rock;
		this.vscissors = scissors;
		this.vpaper = paper;
	}
	@Override
	public Outcome competitor(RoShamBo2 t) {
		switch(t){
		default:
		case ROCK:
			return vrock;
		case SCISSORS:
			return vscissors;
		case PAPER:
			return vpaper;
		}
	}
	public static void main(String args[]){
		RoShamBo.play(RoShamBo2.class, 10);
	}
}
