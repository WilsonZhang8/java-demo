package com.zghw.base.enumx;
/**
 * 比赛接口
 * @author zghw
 *
 * @param <T>
 */
public interface Competitor<T> {
	Outcome competitor(T t);
}
