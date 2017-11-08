package interceptor.interceptors;

import interceptor.message.Message;

public class AuthenticationInterceptor implements AbsInterceptor {

	@Override
	public void intercept(Message message) {
		 System.out.println("\nconcrete interceptor: "+
					"{ message from: " + message.getClass().getName()+" : "+ message.toString() +
					"  Function for: authentacation of third part invoke.}\n");
 
	}

}
