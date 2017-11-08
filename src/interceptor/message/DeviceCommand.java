package interceptor.message;

import homeServer.context.ApplicationContext;
import homeSever.core.MessageHandler;

public class DeviceCommand implements Message {// a fake class for concrete message / request / command..., that going to (send) into home server.
	
	@Override
	public void executeCommand() {
		System.out.print("**Executing Message/Command**: This this a Command Request from Android Mobile.\n\n"); 
	}

	@Override
	public void sendToFramework() {
		ApplicationContext.getMsgManager().msgEnqueue(this);
	} 
} 
