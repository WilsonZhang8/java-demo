package com.zghw.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	private Subject subject;
	public DynamicProxy(Subject subject){
		this.subject = subject;
	}

	//Object proxy 是生成的class对应的代理类，从生成的代理类中传过来的方法及参数
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//每个方法前都使用
		System.out.println("调用前"+method);
		//判断调用那个方法
		if(method.getName().equals("hello")){
			//要调用实际的方法需要这样，必须传入真实对象，带入代理参数
			return method.invoke(subject, args);
		}else{
			method.invoke(subject, args);
		}
		
		System.out.println("调用后"+method);
		
		return null;
	}

}
