package builder;

import homeServer.ConnectionManager;

public class ConnectionManagerBuilder implements AbsBuilder {

	private ConnectionManager connectionManager;
	
	@Override
	public ConnectionManagerBuilder createInstance() {
		connectionManager = new ConnectionManager();
		return this;
	}

	@Override
	public SystemComponent build() {
		// TODO Auto-generated method stub
		return null;
	}

}
