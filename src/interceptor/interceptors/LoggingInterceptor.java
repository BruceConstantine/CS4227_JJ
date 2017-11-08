package interceptor.interceptors;
 

import homeServer.context.ApplicationContext;
import interceptor.message.Message;

public class LoggingInterceptor implements AbsInterceptor { 

	@Override
	public void intercept(Message message) {
		System.out.println("\nconcrete interceptor: "+
				"{ message from: " + message.getClass().getName()+" : "+ message.toString() +
				" The out-of-band service: logging is outputing... }"); 
		ApplicationContext.getLogger().logMessage(1, "concrete interceptor is intercepting..."); // get context object. 
	}
}