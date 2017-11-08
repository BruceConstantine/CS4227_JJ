package homeSever.core;

import java.util.concurrent.LinkedBlockingQueue;

import interceptor.message.Message;

public class MSGManager{ // this one designed for receive the messages from all devices

	private static final LinkedBlockingQueue <Message> msgQueue = new LinkedBlockingQueue<Message>( 50 /*MaxLengthOfQueue : in case of memory overloading.*/) ;	// thread-safe data structure
	
	public void msgEnqueue(Message msg) {
		try {
			msgQueue.put(msg);	// enqueue
		} catch (InterruptedException e) {
			System.err.println("Concurrent Error! - CAN NOT *PUT* NEW MSG IN MSGManager.");
			e.printStackTrace();
		}
	}
	
	public Message msgDequeue() {
		Message msg = null;
		try {
			msg = msgQueue.take(); // dequeue
		} catch (InterruptedException e) {
			System.err.println("Concurrent Error! - CAN NOT *TAKE* NEW MSG IN MSGManager.");
			e.printStackTrace();
		}
		return msg;
	}
	
	public boolean isQueueEmpty() {
		return msgQueue.isEmpty();
	}
	
}