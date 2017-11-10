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
	private DevicesFactory df = new DevicesFactory();
	private List<Devices> devices = new ArrayList<Devices>();
	private Caretaker caretaker = new Caretaker();
	
	/*private List<String> DevicesClass = new ArrayList<String>();
	
	{
		DevicesClass.add("room1");
		DevicesClass.add("room2");
		DevicesClass.add("room3");
	}*/

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
	public void createDevices(String deviceType, String deviceId, String deviceClass){
		Devices d = df.createDevices(deviceType, deviceId, deviceClass);
		devices.add(d);
		
		/*storeStateOfDevice();
		
		System.out.println("(1)device state: "+d.getState());
		d.setState(1);
		System.out.println("(2)device state: "+d.getState());
		undo("ls");
		System.out.println("(3)device state: "+d.getState());
		*/
		
		
	}
	
	
	
	public void undo(String deviceName){
		for(Devices d: devices){
			if(d.getDeviceId().equals(deviceName)){
				d.restoreMemento(caretaker.getMemento());
			}
		}
	}
	
	/*excuteCommand(typenameclasID, ACTION)*/
	/*public void handleProcdureCommand(ProcedureCommand ){
		
		
	}*/
	public void storeStateOfDevice(){
		for(Devices d: devices ){
			caretaker.setmemento(d.createMemento());
		}
		
	}
	
	public void visitDevices(){
		Visitor v = new InfoVisitor();
		
		for(Devices d: devices ){
			d.accept(v);
		}	
	}
	
}
