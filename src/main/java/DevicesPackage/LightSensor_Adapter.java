package DevicesPackage;

import Memento.I_Memento;
import Visitor.Visitor;

public class LightSensor_Adapter extends Version2_LightSensor implements I_Version1_LightSensor{

	public LightSensor_Adapter(String deviceType, String deviceId, String deviceClass) {
		super(deviceType, deviceId, deviceClass);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setState(int state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDeviceId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeviceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public I_Memento createMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void restoreMemento(I_Memento m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
