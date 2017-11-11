package builder;

import java.util.Map;

import homeServer.ConfigManager;

public class ConfigManagerBuilder implements AbsBuilder {

	private ConfigManager cgManager;
	  
	public ConfigManagerBuilder setConfigFileName( String configFileName){
		cgManager.setConfigFileName(configFileName);
		return this;
	} 
	
	@Override
	public ConfigManagerBuilder createInstance() {
		cgManager = new ConfigManager();
		return null;
	}

	@Override
	public SystemComponent build() {
		// TODO Auto-generated method stub
		return null;
	}

}
