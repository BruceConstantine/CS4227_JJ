package config;

import java.util.Stack;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.HashMap;
import java.util.Map;  
import interceptor.*;
import interceptor.dispatcher.Dispatcher.MyInterceptorStack;
import interceptor.frame.services.Request;
import interceptor.frame.services.ServiceDefinedInFramework;
import interceptor.interceptors.ConcreteInterceptor_A;
import interceptor.interceptors.ConcreteInterceptor_B;
import interceptor.interceptors.MyInterceptor;
import interceptor.*;


public class Config {

	private Map<Class<? extends ServiceDefinedInFramework>, MyInterceptorStack> interceptorConfig_Map ; 

	public Config(){
		interceptorConfig_Map = new HashMap<Class<? extends ServiceDefinedInFramework>, MyInterceptorStack>();
		_init_();
	}
	
	private void _init_(){
		
		parseXmlInterceptorConfig();
		// parseXmlDatabaseConfig();
		// ... ...
	}
	
	public void parseXmlInterceptorConfig() {
		// Scan Interceptor
		MyInterceptor interceptor_A = new ConcreteInterceptor_A();
		MyInterceptor interceptor_B = new ConcreteInterceptor_B();

		// Scan Action
		ServiceDefinedInFramework request = new Request();

		// Scan Binding
		MyInterceptorStack interceptorStack = new MyInterceptorStack();
		interceptorStack.push(interceptor_A);
		interceptorStack.push(interceptor_B); 
		
		//bind action with interceptor
		interceptorConfig_Map.put(request.getClass(), interceptorStack);
	}
	
	public Map<Class<? extends ServiceDefinedInFramework>, MyInterceptorStack> getInterceptorConfig_Map(){
		return interceptorConfig_Map;
	}

}
