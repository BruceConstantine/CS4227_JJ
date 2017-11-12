package DevicesPackage;

public interface I_Light extends I_Devices{
	double illumination = 360;
	
	public void setIllumination(double newIll);
	public double getIllumination();
	
	public void turnOn();
	public void turnOff();
	public void turnDown();
	public void turnUp();
}
