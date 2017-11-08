package interceptor.interceptors;

import homeServer.context.ApplicationContext;
import interceptor.message.Message;

public class AlterDatabaseInterceptor implements AbsInterceptor {
	 
	@Override
	public void intercept(Message message) {
		String datbaseIP = "192.142.1.1";
		 System.out.println("\nconcrete interceptor: "+
					"{ message from: " + message.getClass().getName()    +" : "+ message.toString() +
					"  For altering database s}\n"+
					"  new address: "+ datbaseIP +"\n"
				 );
		ApplicationContext.getDatabaseManager().setDatabaseIP(datbaseIP);
	}
}