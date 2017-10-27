package homeServer;

import DevicesPackage.Devices;
import Factory.DevicesFactory;
import Memento.caretaker;


public class DeviceManager {
	
	private DatabaseManager databaseManager;
	

	/*DevicesFactory df = new DevicesFactory();
	Devices d;
	*/


	public DeviceManager() {
		this.databaseManager = databaseManager;

	}
	
	public void initalise() {
		loadDeviceCongigFromDB();
	}	
	
	public void loadDeviceCongigFromDB() {
		// loads the configuration information for the device manager from the data base
		
	}
	
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	
	//create devices--meiyu
	public void createDevices(String type, String name){
		d = df.createDevices(type, name);
		
		System.out.println("(1)device: "+d.getName()+" state: "+d.getState());
		
		caretaker c = new caretaker();
		c.setmemento(d.createMemento());
		d.setState(1);
		System.out.println("(2)device: "+d.getName()+" state: "+d.getState());
		
		d.restoreMemento(c.getMemento());
		System.out.println("(3)device: "+d.getName()+" state: "+d.getState());
		
		
		databaseManager.registerDevices(d);
	}

}
