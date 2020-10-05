package cn.edu.xit.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/*环绕通知：在目标方法的前后、异常发生时、最终等各个地方都可以  进行的通知，最强大的一个通知；
 * 可以获取目标方法的  全部控制权（目标方法是否执行、执行之前、执行之后、参数、返回值等）
 * 在使用环绕通知时，目标方法的	一切信息 都可以通过invocation参数取到
 * 环绕通知底层是通过拦截器实现的
*/
public class LogAround implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//方法体1 ...
		Object result=null;
		try{
			//方法体2...
			System.out.println("用环绕通知实现的[前置通知]..");
			
			
			
			//invocation.proceed() 之前的代码：前置通知
			result = invocation.proceed();//控制着目标方法的执行
			//result 就是目标方法addStudent()方法的返回值
			//invocation.proceed() 之前的代码：后置通知
			System.out.println("用环绕通知实现的[后置通知]..");
			System.out.println("--------环绕通知实现的目标对象target："+invocation.getThis()+",调用的方法名："+invocation.getMethod().getName()+",方法的参数个数："+invocation.getArguments().length+",方法的返回值"+result);
			
		}catch(Exception e){
			//方法体3...
			//异常通知
			System.out.println("用环绕通知实现的[异常通知]..");
		}
		return result;//目标方法的返回值
	}

}
