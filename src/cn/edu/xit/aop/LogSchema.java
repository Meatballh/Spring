package cn.edu.xit.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;



public class LogSchema {//Joinpoint  使用以注解和schema 
	public void afterReturning(JoinPoint jp,Object returnValue) throws Throwable {
		System.out.println("!!!!!后置通知：目标对象："+jp.getTarget()+",调用的方法名："+jp.getSignature().getName()+",方法的参数个数："+jp.getArgs().length+",方法的返回值"+returnValue);
		
	}
	public void before(){
		System.out.println("!!!!!前置通知、、、、、");
	}
	public void whenException(JoinPoint jp,NullPointerException e){
		System.out.println("!!!异常:"+e.getMessage());
	}
	//环绕通知会返回目标方法的返回值，因此返回值为Object
	public Object around(ProceedingJoinPoint jp){
		Object result = null;
		System.out.println("*******环绕通知：前置通知");
		try {
			result = jp.proceed();//执行方法
			System.out.println("*******"+jp.getSignature().getName());
			System.out.println("*******环绕通知：后置通知");
		} catch (Throwable e) {
			System.out.println("*******环绕通知：异常通知");
		}
		return result;	
	}
}
