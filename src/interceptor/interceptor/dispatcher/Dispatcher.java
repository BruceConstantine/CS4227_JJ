package interceptor.dispatcher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import config.*;
import interceptor.dispatcher.Dispatcher.MyInterceptorStack;
import interceptor.frame.services.ServiceDefinedInFramework;
import interceptor.interceptors.MyInterceptor;
 

public class Dispatcher{
	 
	Map< Class<? extends ServiceDefinedInFramework>, MyInterceptorStack > interceptorsMap;
	
//	public Dispatcher( DispatcherBuilder dispatcherBuilder ) {
//		
//	}
	
	public Dispatcher( Config config ) {
		interceptorsMap = config.getInterceptorConfig_Map();
	}
	
	public void callbackInterceptors (ServiceDefinedInFramework msg) { 
		MyInterceptorStack  interceptorStack = interceptorsMap.get(msg.getClass());
		if (!interceptorStack.isEmpty()) {
			for (MyInterceptor interceptor : interceptorStack ) {
				interceptor.executeOutofBandService(); 
			}
		}
	}
	
	/*����д����Ϊ���Զ���ע��Interceptor
	 * �ڴ���Ĺ��췽����ʵ�ֽ�������ע��Ĵ���
	 * public static class RegisterHelper {
	 * }
	 */ 
	public static class DispatcherBuilder {  
		Map< ServiceDefinedInFramework, MyInterceptorStack > interceptorsMap; 	//����һ��������ջ
		
		public DispatcherBuilder() {			
			interceptorsMap = new HashMap <ServiceDefinedInFramework, MyInterceptorStack> (); 
		} 

		public DispatcherBuilder bind(ServiceDefinedInFramework serviceDefinedInFramework, MyInterceptorStack interceptorStack) { 
			interceptorsMap.put(serviceDefinedInFramework,interceptorStack);
			return this;
		}
		
		public DispatcherBuilder bind(ServiceDefinedInFramework serviceDefinedInFramework, Stack<MyInterceptor> interceptorStack) {  
			interceptorsMap.put(serviceDefinedInFramework, new MyInterceptorStack(interceptorStack) );
			return this;
		}
		
//		public Dispatcher build(){
//			return new Dispatcher(this);
//		}
	}

	public static class MyInterceptorStack implements Iterable<MyInterceptor> {  
		private Stack<MyInterceptor> interceptorStack; 	//����һ��������ջ
		
		public MyInterceptorStack() {			
			interceptorStack = new Stack<MyInterceptor>(); 
		}
		
		public MyInterceptorStack( Stack<MyInterceptor> interceptorStack) {			
			this.interceptorStack = interceptorStack; 
		}
		
		public void push( MyInterceptor interceptor ){
			interceptorStack.push( interceptor );
		}  

		public Stack<MyInterceptor> getInterceptorStack(){
			return interceptorStack;
		}
		
		public boolean isEmpty(){
			return interceptorStack.isEmpty();
		}

		@Override
		public Iterator<MyInterceptor> iterator() { 
			return new InterceptorIterator() ;
		}
		
		private class InterceptorIterator implements Iterator<MyInterceptor> {

			private Stack<MyInterceptor> interceptorStack_ite;
			
			public InterceptorIterator() {
				interceptorStack_ite = new Stack();
				interceptorStack_ite.addAll(interceptorStack);
			}
			
			@Override
			public boolean hasNext() {
				return !interceptorStack_ite.isEmpty();
			}

			@Override
			public MyInterceptor next() {
				// TODO Auto-generated method stub
				if(hasNext())
					return interceptorStack_ite.pop();
				else
					return null; 
			}
			
		}
		
	}
	
	
}