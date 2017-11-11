package homeServer.core.dispatcher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

import homeServer.context.ApplicationContext;
import interceptor.config.*;
import interceptor.interceptors.AbsInterceptor;
import interceptor.message.Message;
 

public class Dispatcher{
	  
	private final Map< Class<? extends Message>, InterceptorStack > interceptorsMap = InterceptorConfigXMLParser.getInterceptorMap();
	
	
//	public Dispatcher( DispatcherBuilder dispatcherBuilder ) {
//		
//	}
	
	public Dispatcher() { }
	
	public void callbackInterceptors (Message msg) { 
		InterceptorStack  interceptorStack = interceptorsMap.get(msg.getClass());
		if ( interceptorStack == null || interceptorStack.isEmpty() ) {
			/** TODO: If the Message/event is not be configurated in interceptorConfig.xml file, what gona next?*/
			///Just return is not correct here, it should do something like throws exceptions or ...
			// I am too tired to keep... see you tomorrow...
			return ;
		} else {
			for (AbsInterceptor interceptor : interceptorStack ) {
				interceptor.intercept(msg);
			}
		}
	} 
	/*书上写的是为了自动化注册Interceptor
	 * 在此类的构造方法里实现将拦截器注册的代码
	 * public static class RegisterHelper {
	 * }
	 */ 
	public static class DispatcherBuilder {  
		Map< Message, InterceptorStack > interceptorsMap; 	// define a interceptor stack
		
		public DispatcherBuilder() {			
			interceptorsMap = new HashMap <Message, InterceptorStack> (); 
		} 

		public DispatcherBuilder bind(Message msg, InterceptorStack interceptorStack) { 
			interceptorsMap.put(msg,interceptorStack);
			return this;
		}
		
		public DispatcherBuilder bind(Message msg, Stack<AbsInterceptor> interceptorStack) {  
			interceptorsMap.put(msg, new InterceptorStack(interceptorStack) );
			return this;
		}
		
//		public Dispatcher build(){
//			return new Dispatcher(this);
//		}
	}

	
	
	
}