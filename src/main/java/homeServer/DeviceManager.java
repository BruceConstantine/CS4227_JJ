package homeServer;

import java.util.ArrayList;
import java.util.List;

import DevicesPackage.Devices;
import Factory.DevicesFactory;


public class DeviceManager {
	
	private DatabaseManager databaseManager;
	

	DevicesFactory df = new DevicesFactory();
	public List<Devices> devices = new ArrayList<Devices>();
	


	public DeviceManager() {
		this.databaseManager = databaseManager;
		

	}
	
	public void initalise(DatabaseManager databaseManager) {
		//load devices information from DB, type, name, classId
		loadDeviceCongigFromDB();
		
	}	
	
	public void loadDeviceCongigFromDB() {
		// loads the configuration information for the device manager from the data base
		String dInfo = databaseManager.getDevicesInfoFromDB();
		String info[] = dInfo.split(",");
		
		for(int i=0; i<info.length; i+=3){
				createDevices(info[i], info[i+1], info[i+2]);
		}
	}
	
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	
	//create devices--meiyu
	public void createDevices(String type, String name, String classId){
		Devices d = df.createDevices(type, name, classId);
		
		devices.add(d);
		/*System.out.println("(1)device: "+d.getName()+" state: "+d.getState());
		
		caretaker c = new caretaker();
		c.setmemento(d.createMemento());
		d.setState(1);
		System.out.println("(2)device: "+d.getName()+" state: "+d.getState());
		
		d.restoreMemento(c.getMemento());
		System.out.println("(3)device: "+d.getName()+" state: "+d.getState());
		*/
		
		//databaseManager.registerDevices(d);
	}

}
