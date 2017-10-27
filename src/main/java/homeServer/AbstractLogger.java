package homeServer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLogger {
	//protected Map<String, Integer> system = new HashMap<String, Integer>();
	public static int SYSTEM_INFO = 1;
	public static int SYSTEM_ERROR = 2;
	protected int level;
	protected DatabaseManager databaseManager;

	
	//next element in chain or responsibility
	protected AbstractLogger nextLogger;
	
	public void setNextLogger(AbstractLogger nextLogger){
		this.nextLogger = nextLogger;
	}
	
	public void logMessage(int level, String message){	
		if(this.level <= level){
			write(message);
		}
		
		if(nextLogger !=null){
			nextLogger.logMessage(level, message);
		}
	}
	protected void setDatabseManager(DatabaseManager databaseManager){
		this.databaseManager = databaseManager;
	}
	abstract protected void write(String message);
}