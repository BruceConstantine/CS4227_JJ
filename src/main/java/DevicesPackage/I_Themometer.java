package DevicesPackage;

public interface I_Themometer extends I_Devices{
	double temperature=30;
	
	public void setTemperature(double newTem);
	public double getTemperature();
	public void turnOn();
	public void turnOff();
	public void turnDown();
	public void turnUp();
}
