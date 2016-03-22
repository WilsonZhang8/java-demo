package com.zghw.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class TargetEnhancer {
	private Class<?> superclass;
	private Callback callback;
	public TargetEnhancer(Class<?> superclass,Callback callback){
		this.superclass = superclass;
		this.callback = callback;
	}
	public Enhancer createEnhancer(){
		Enhancer enhancer =new Enhancer();
		enhancer.setSuperclass(this.superclass);
		enhancer.setCallback(this.callback);
		return enhancer;
	}
	
}
