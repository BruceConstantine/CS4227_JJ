package test;
 
import homeSever.core.MessageHandler;
import interceptor.message.DeviceCommand;
import interceptor.message.Message;
import interceptor.message.ThirdPartyRequest;

public class Test {
	
/***
 * THIS CODE CAN NOT WORK BECAUSE THE INTIALIZATION OF CONTEXT OBJECT IS IN INITIALISER CLASS.....
 * */
	public static void test () {
		Message request = new DeviceCommand();
		request.sendToFramework();
		new ThirdPartyRequest().sendToFramework();
	}
/*
	public static void main(String[] args) { 
		
		MessageHandler framework = new MessageHandler(); 
		//Application app = new Application();
		
		
		framework.startService(); 

		Message request = new DeviceCommand();
		request.sendToFramework();
		
		try {
			Thread.sleep(1111);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new ThirdPartyRequest().sendToFramework();
	}
*/
}
