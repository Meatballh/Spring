package cn.edu.xit.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


/*一个普通的类   ->     有特定功能的类
 *  a.继承类    b.实现接口    c.注解   d.配置
*/



//前置通知
//普通类——>前置通知
public class LogBefore implements MethodBeforeAdvice{
	public void before(){
		
	}
	
	//前置通知的具体方法
	@Override
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("前置通知.....");
		
	}
}
