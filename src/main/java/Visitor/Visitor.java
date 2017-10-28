package Visitor;

import DevicesPackage.Light;
import DevicesPackage.Themometer;

public interface Visitor {
	public void visit(Light light);
	public void visit(Themometer t);
}
