package cn.edu.xit.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class LogException implements ThrowsAdvice {
	//异常通知的具体方法
	public void afterThrowing(Method method,Object[] args,Object target, Throwable ex){
		System.out.println("异常通知：目标对象："+target+",方法名："+method.getName()+",参数个数："+args.length+"异常类型："+ex.getMessage());
	}
}
