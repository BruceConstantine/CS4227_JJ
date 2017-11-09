package homeServer;

import java.util.ArrayList;
import java.util.List;

import DevicesPackage.Devices;
import Factory.DevicesFactory;
import Memento.Caretaker;
import Visitor.InfoVisitor;
import Visitor.Visitor;


public class DeviceManager {
	
	private DatabaseManager databaseManager;
	

	DevicesFactory df = new DevicesFactory();
	public List<Devices> devices = new ArrayList<Devices>();
	


	public DeviceManager() {
		this.databaseManager = databaseManager;
		

	}
	
	public void initalise(DatabaseManager databaseManager) {
		//load devices information from DB, type, name, classId
		this.databaseManager = databaseManager;
		loadDeviceCongigFromDB();
		//visitDevices();
		
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
	}
	
	public void storeStateOfDevice(){
		Caretaker c = new Caretaker();
		
		for(Devices d: devices){
			c.setmemento(d.createMemento());
		}
		
	}
	public void visitDevices(){
		Visitor v = new InfoVisitor();
		
		for(Devices d: devices ){
			d.accept(v);
		}	
	}
}
