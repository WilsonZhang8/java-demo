package com.zghw.base.enumx;

import static com.zghw.base.enumx.Outcome.*;
import java.util.EnumMap;

/**
 * 使用EnumMap实现真正的两路分发
 * 石头 、剪刀、布游戏
 * @author zghw
 *
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
	ROCK, SCISSORS, PAPER;
	static EnumMap<RoShamBo3, EnumMap<RoShamBo3, Outcome>> table = new EnumMap<RoShamBo3, EnumMap<RoShamBo3, Outcome>>(
			RoShamBo3.class);

	static {
		//初始化表结构 就像一个表格
		for (RoShamBo3 rs : RoShamBo3.values()) {
			table.put(rs, new EnumMap<RoShamBo3, Outcome>(RoShamBo3.class));
		}
		initRow(ROCK, DRAW, WIN, LOSE);
		initRow(SCISSORS, LOSE, DRAW, WIN);
		initRow(PAPER, WIN, LOSE, DRAW);
	}

	private static void initRow(RoShamBo3 rs, Outcome vrock, Outcome vscissors,
			Outcome vpaper) {
		EnumMap<RoShamBo3, Outcome> rso = table.get(rs);
		rso.put(ROCK, vrock);
		rso.put(SCISSORS, vscissors);
		rso.put(PAPER, vpaper);
		table.put(rs, rso);
	}

	@Override
	public Outcome competitor(RoShamBo3 t) {
		return table.get(this).get(t);
	}

	public static void main(String args[]) {
		RoShamBo.play(RoShamBo3.class, 10);
	}
}
