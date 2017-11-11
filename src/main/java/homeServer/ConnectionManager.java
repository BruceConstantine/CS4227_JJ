package homeServer;

import builder.SystemComponent;

public class ConnectionManager implements SystemComponent {

	private DatabaseManager databaseManager;

	public ConnectionManager(DatabaseManager databaseManager) {
		setDatabaseManager(databaseManager);
	}

	public ConnectionManager() {
		// TODO Auto-generated constructor stub
	}

	public void initalise() {
		// TODO Auto-generated method stub	
	}

	public void setDatabaseManager(DatabaseManager databaseManager2) {
		// TODO Auto-generated method stub
		
	}

}
