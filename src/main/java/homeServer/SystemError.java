package homeServer;

public class SystemError extends AbstractLogger {
	

	public SystemError(int level, DatabaseManager databaseManager){
		this.level = level;
		setDatabseManager(databaseManager);
	}

	@Override
	protected void write(String message) {		
		databaseManager.writeSystemError(message);
		
	}
}