package DevicesPackage;

import Memento.memento;
import Visitor.Visitor;

public interface Devices {
	int state = -1;
	String name = "";
	String type = "";
	public int getState();
	public void setState(int state);
	public String getName();
	public String getType();
	
	public memento createMemento();
	public void restoreMemento(memento m);
	
	public void accept(Visitor v);
}
