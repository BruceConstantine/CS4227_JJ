package builder;

import homeServer.DatabaseManager;

public class DatabaseManagerBuilder implements AbsBuilder {
	
	private DatabaseManager dbManager;
	
	@Override
	public SystemComponent build() { 
		return dbManager;
	}
	@Override
	public DatabaseManagerBuilder createInstance() { 
		dbManager = new DatabaseManager();
		return this;
	}
	public DatabaseManagerBuilder setDBUserName(String databaseUserName ) { 
		dbManager.setDatabaseUserName(databaseUserName); 
		return this; 
	}
	public DatabaseManagerBuilder setDBPassword(String databasePassword ) { 
		dbManager.setDatabaseUserName( databasePassword );
		return this; 
	}
	public DatabaseManagerBuilder setDBIP(String databaseIP ) { 
		dbManager.setDatabaseUserName(databaseIP);
		return this; 
	} 

}
