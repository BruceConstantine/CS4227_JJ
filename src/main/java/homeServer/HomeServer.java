package homeServer;

import Visitor.Visitor;
import Visitor.infoVisitor;
import java.util.*;
import DevicesPackage.*;

public class HomeServer {
	private Initaliser initaliser;
	private DatabaseManager databaseManager = new DatabaseManager();
	private ConfigManager configManager = new ConfigManager();
	private DeviceManager deviceManager = new DeviceManager();
	private ConnectionManager connectionManager = new ConnectionManager();
	
	public HomeServer(String configFileName){
		initalise(configFileName);
	}
	
	private void initalise(String configFileName) {
		this.initaliser = new Initaliser(configFileName, databaseManager, configManager, deviceManager, connectionManager);
		deviceManager.createDevices("LIGHT", "light");
		Visitor v = new infoVisitor();
		List<Devices> devices = databaseManager.getDevices();
		for(Devices d:devices){
			d.accept(v);
		}
		for(Devices d:devices){
			switch(d.getType()){
			case "LIGHT": v.visit((Light)d);
			case "THEMOMETER": v.visit((Themometer)d);
			}
		}
	}
	
	public static void main(String[] args) {
		HomeServer homeServer =  new HomeServer(args[0]);
		
		
	}
}
  