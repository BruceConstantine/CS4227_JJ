package interceptor.message;

import homeServer.context.ApplicationContext; 

public class ThirdPartyRequest implements Message { // a fake class for concrete message / request / command..., that going to (send) into home server.
	
	@Override
	public void executeCommand() {
		System.out.print("**Executing Message/Command**: This this a HTTP Request from the third party\n\n"); 
	} 

	@Override
	public void sendToFramework() {
		ApplicationContext.getMsgManager().msgEnqueue(this);
	} 
} 
