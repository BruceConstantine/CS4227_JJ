package interceptor.app;
  
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.imageio.spi.RegisterableService;

import com.sun.javafx.event.EventHandlerManager;
import com.sun.jndi.ldap.ManageReferralControl;
import com.sun.xml.internal.ws.api.message.Attachment;

import interceptor.dispatcher.Dispatcher.MyInterceptorStack;
import interceptor.frame.ConcreteFramework;
import interceptor.frame.services.Request;
import interceptor.frame.services.ServiceDefinedInFramework;
 

public class Application {

	public static void main(String[] args) { 
		
//		MyInterceptorConfig interceptorConfig = new MyInterceptorConfig();
//		Dispatcher.MyInterceptorStack interceptorStack = new Dispatcher.MyInterceptorStack ();
//		Dispatcher.DispatcherBuilder builder = new Dispatcher.DispatcherBuilder();
  
		ConcreteFramework framework = new ConcreteFramework();

		framework.startService(); 
		
		ServiceDefinedInFramework request = new Request();
		request.sendToFramework();
		
		try {
			Thread.sleep(1111);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Request().sendToFramework();
	}

}







