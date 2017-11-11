package homeServer.deviceManager;

import java.util.ArrayList;
import java.util.List;

import builder.SystemComponent;
import homeServer.DatabaseManager;
import homeServer.deviceManager.devicesPackage.Devices;
import homeServer.deviceManager.factory.DevicesFactory;
import homeServer.schedular.ProcedureCommand;

public class DeviceManager implements SystemComponent{

	private DatabaseManager databaseManager;

	DevicesFactory df = new DevicesFactory();
	public List<Devices> devices = new ArrayList<Devices>();
	
	public void initalise() {
		loadDeviceCongigFromDB();
	}	 

/***
 * 
////添加Getter和setter
 * 
 * */
	
//
//	public void executeRequestOnDeviceID(ProcedureCommand procedureCommand){
//		
//	}
//	
//	public void executeRequestOnDeviceClassID(ProcedureCommand procedureCommand){
//		
//	}
//	
//	public void executeRequestOnType(ProcedureCommand procedureCommand){
//		
//	}
//	
	public List<Devices> getDevices() {
		return devices;
	}

	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}
	
	public void handleProcedureCommand( ProcedureCommand command) {
		// Command c = new ConcreteCommand( command ); //Using abstract class for implementing command , not interface.
	}
	
	
///ENDOF//添加Getter和setter 
	
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
		
		Caretaker c = new Caretaker();
		c.setmemento(d.createMemento());
		d.setState(1);
		System.out.println("(2)device: "+d.getName()+" state: "+d.getState());
		
		d.restoreMemento(c.getMemento());
		System.out.println("(3)device: "+d.getName()+" state: "+d.getState());
		*/
		
		//databaseManager.registerDevices(d);
	}

}
