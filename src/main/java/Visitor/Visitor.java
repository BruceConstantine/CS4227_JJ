package Visitor;

import DevicesPackage.*;


public interface Visitor {
	public void visit(Version1_Light light);
	public void visit(Version1_Themometer t);
	public void visit(Version1_LightSensor ls);
	public void visit(Version1_TemperatureSensor ts);
	
	public void visit(Version2_Light light);
	public void visit(Version2_Themometer t);
	public void visit(Version2_LightSensor ls);
	public void visit(Version2_TemperatureSensor ts);
	
}
