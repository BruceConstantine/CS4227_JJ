package Visitor;

import homeServer.deviceManager.devicesPackage.*;

public interface Visitor {
	public void visit(Light light);
	public void visit(Themometer t);
}
