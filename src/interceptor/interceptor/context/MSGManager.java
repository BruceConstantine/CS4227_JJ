package interceptor.context;

import java.util.concurrent.LinkedBlockingQueue;

import interceptor.frame.services.ServiceDefinedInFramework;

public class MSGManager{ // this one designed for receive the messages from all devices

	private static final LinkedBlockingQueue <ServiceDefinedInFramework> msgQueue = new LinkedBlockingQueue<ServiceDefinedInFramework>() ;	// thread-safe data structure
	
	public void msgEnqueue(ServiceDefinedInFramework msg) {
		try {
			msgQueue.put(msg);	// enqueue
		} catch (InterruptedException e) {
			System.err.println("Concurrent Error!");
			e.printStackTrace();
		}
	}
	
	public ServiceDefinedInFramework msgDequeue() {
		ServiceDefinedInFramework msg = null;
		try {
			msg = msgQueue.take(); // dequeue
		} catch (InterruptedException e) {
			System.err.println("Concurrent Error!");
			e.printStackTrace();
		}
		return msg;
	}
	
	public boolean isQueueEmpty() {
		return msgQueue.isEmpty();
	}
	
}