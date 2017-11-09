package Visitor;

import DevicesPackage.*;


public interface Visitor {
	public void visit(Light light);
	public void visit(Themometer t);
	public void visit(LightSensor ls);
	public void visit(TemperatureSensor ts);
}
