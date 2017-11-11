package interceptor.message;

import homeServer.context.ApplicationContext;
import homeSever.core.MessageHandler;

public class DeviceCommand implements Message {// a fake class for concrete message / request / command..., that going to (send) into home server.
	
	@Override
	public void executeCommand() {
		System.out.print("**Executing Message/ProcedureCommand**: This this a ProcedureCommand ProcedureCommand from Android Mobile.\n\n"); 
	}
 
	public void sendToFramework() {
		ApplicationContext.getMsgManager().msgEnqueue(this);
	} 
} 
