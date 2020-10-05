package cn.edu.xit.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//注解===>   实现一个普通的类---->有特定功能的类



//<bean id="logAspectAnnotaion" class="cn.edu.xit.aop.LogAspectAnnotaion"></bean>    ===(等价于)   cn.edu.xit.aop.LogAspectAnnotaion      
@Component("logAspectAnnotaion")//将logAspectAnnotaion纳入springIOC容器内)
@Aspect//次类是一个通知
public class LogAspectAnnotaion {
	//前置通知
	@Before("execution(public * addStudent(cn.edu.xit.entity.Student))")//属性：定义切入点
	public void myBefore(JoinPoint jp){
		System.out.println("<注解形式-前置通知>:目标:"+jp.getTarget()+",方法名:"+jp.getSignature()+",参数列表："+ Arrays.toString(jp.getArgs()));	
	}
	
	//后置通知
	@AfterReturning(pointcut = "execution(public * addStudent(cn.edu.xit.entity.Student))" ,returning="returningValue")
	public void myAfter(JoinPoint jp,Object returningValue){//returningValue是返回值，但需要告诉spring
		System.out.println("<注解形式-后置通知>目标:"+jp.getTarget()+",方法名:"+jp.getSignature()+",参数列表："+ Arrays.toString(jp.getArgs())+"返回值："+returningValue);
	}
	
//	//环绕通知,参数ProceedingJoinPoint
//	@Around("execution(public * addStudent(cn.edu.xit.entity.Student))")
//	public void myAround(ProceedingJoinPoint jp){
//		try {
//			//方法执行时
//			jp.proceed();
//			//方法之前之后：后置通知
//			System.out.println("[环绕通知]方法之前：前置通知");
//		} catch (Throwable e) {
//			// 方法异常时：异常通知
//			System.out.println("[环绕通知]方法异常时：异常通知");
//		}finally{
//			//最终通知
//			System.out.println("[环绕通知]最终通知");
//		}
//	}
	
	//异常通知:如果只捕获特定类型的异常，则可以通过第二个参数实现：e
	@AfterThrowing(pointcut = "execution(public * addStudent(cn.edu.xit.entity.Student))",throwing ="e")
	public void myException(JoinPoint jp,NullPointerException e){
		System.out.println("^^^^<注解形式-异常通知>----e:"+e.getMessage());
	}
	
	//最终通知
	@After("execution(public * addStudent(cn.edu.xit.entity.Student))")
	public void myAfter(){
		System.out.println("<【myAfter】注解形式-最终通知>");
	}
}
