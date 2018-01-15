package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler{
	
	private Object target=null;
	
	public Object bind(Object obj)
	{
		this.target=obj;
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("进入代理逻辑方法之前");
		 Object object=method.invoke(target, args);
		System.out.println("进入代理逻辑方法之后");
		return object;
	}
	public static void main(String[] args)
	{
		JdkProxy jdk=new JdkProxy();
		HelloWord hello=(HelloWord)jdk.bind(new HelloWordImp());
		hello.sayHello("zjz");
	}
}
