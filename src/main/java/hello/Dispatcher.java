package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import homeServer.core.dispatcher.Dispatcher.DispatcherBuilder;
import interceptor.config.InterceptorConfigXMLParser;
import interceptor.config.InterceptorStack;
import interceptor.interceptors.AbsInterceptor;
import interceptor.message.Message;

public class Dispatcher {
	
	// When : "new Dispatcher();" the concrete intercepter automatically will attach onto this dispatcher
	private final Map< Class<? extends Message>, InterceptorStack > interceptorsMap = InterceptorConfigXMLParser.getInterceptorMap();

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
	}

}
