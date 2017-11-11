package interceptor.message;

import homeServer.context.ApplicationContext; 

public class ThirdPartyRequest implements Message { // a fake class for concrete message / request / command..., that going to (send) into home server.
	
	@Override
	public void executeCommand() {
		System.out.print("**Executing Message/ProcedureCommand**: This this a HTTP ProcedureCommand from the third party\n\n"); 
	} 
 
	public void sendToFramework() {
		ApplicationContext.getMsgManager().msgEnqueue(this);
	} 
} 
