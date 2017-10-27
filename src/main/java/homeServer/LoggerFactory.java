package homeServer;

public class LoggerFactory {

	public LoggerFactory() {
		
	}
	
	public AbstractLogger initaliseSystemInfoLogger() {
		return new SystemInfo(AbstractLogger.SYSTEM_INFO);
	}
	
	public AbstractLogger initaliseLoggerChain(DatabaseManager databaseManager){
		AbstractLogger systemInfo = new SystemInfo(AbstractLogger.SYSTEM_INFO);
		AbstractLogger systemError = new SystemError(AbstractLogger.SYSTEM_ERROR, databaseManager);
		systemInfo.setNextLogger(systemError);
		return systemInfo;	
	}
}
