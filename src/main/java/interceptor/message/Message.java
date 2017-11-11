package interceptor.message;
 
public interface Message { // Event

	/** 
	 * This write the concrete procedure of mobile executing steps flow.
	 ****/
	void executeCommand();  //invoker
	
	/** 
	 * For any message incoming to home server should invoke this line for sending emulations.
	 *	ApplicationContext.getMsgManager().msgEnqueue(this);
	 ****/
	//void sendToFramework();
	
}