package homeServer;

import java.util.ArrayList;
import java.util.List;

import DevicesPackage.I_Devices;
import Factory.AbstractFactory;
import Factory.Version1DevicesFactory;
import Factory.Version2DevicesFactory;
import Memento.Caretaker;
import Visitor.InfoVisitor;
import Visitor.Visitor;


public class DeviceManager {
	
	private DatabaseManager databaseManager;
	private AbstractFactory af ;
	private List<I_Devices> devices = new ArrayList<I_Devices>();
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
		
		
	}	
	
	public void loadDeviceCongigFromDB() {
		// loads the configuration information for the device manager from the data base
		String dInfo = databaseManager.getDevicesInfoFromDB();
		String info[] = dInfo.split(",");
		
		for(int i=0; i<info.length; i+=4){
				createDevices(info[i], info[i+1], info[i+2], info[i+3]);
		}
		
		/*storeStateOfDevice();
		
		System.out.println("(1)device state: "+devices.get(0).getState());
		devices.get(0).setState(1);
		System.out.println("(2)device state: "+devices.get(0).getState());
		undo("ls1");
		System.out.println("(3)device state: "+devices.get(0).getState());
		*/
		//visitDevices();
		
	}
	
	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	
	//create devices--meiyu
	public void createDevices(String devicesVersion, String deviceType, String deviceId, String deviceClass){
		//use abstract factory to create different factory
		if(devicesVersion.equals("version1"))
			af = new Version1DevicesFactory();
		else
			af = new Version2DevicesFactory();
		
		I_Devices d = af.createDevices(deviceType, deviceId, deviceClass);
		//add device to the list
		addDevices(d);
		
	}
	
	public void addDevices(I_Devices d){
		devices.add(d);
	}
	//register devices to sensors but have not finished
	public void registerLightToLightSensor(){
		for(I_Devices d: devices){
			if(d.getDeviceType().equals("LIGHTSENSOR")&&d.getClass().equals("room1")){
				
			}

		}
	}

	/*excuteCommand(typenameclasID, ACTION)*/
	/*public void handleProcdureCommand(ProcedureCommand ){
		
		
	}*/
	
	//use memento to store state of devices
	public void storeStateOfDevice(){
		for(I_Devices d: devices ){
			caretaker.setmemento(d.createMemento());
		}
		
	}
	
	//undo: restore the state from memento
	public void undo(String deviceName){
		for(I_Devices d: devices){
			if(d.getDeviceId().equals(deviceName)){
				d.restoreMemento(caretaker.getMemento());
			}
		}
	}
	
	//use visitor to visit devices
	public void visitDevices(){
		Visitor v = new InfoVisitor();
		
		for(I_Devices d: devices ){
			d.accept(v);
		}	
	}
	
}
