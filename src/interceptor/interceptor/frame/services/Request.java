package interceptor.frame.services;

import interceptor.frame.ConcreteFramework;

public class Request implements ServiceDefinedInFramework {
	
	@Override
	public void executeService() {
		System.out.println("This this a HTTP Request");
	}

	@Override
	public void sendToFramework() {
		ConcreteFramework.getMSGManager().msgEnqueue(this);
	} 
} 
