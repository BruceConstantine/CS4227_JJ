package DevicesPackage;

import Memento.memento;

public interface Devices {
	int state = -1;
	String name = "";
	public int getState();
	public void setState(int state);
	public String getName();
	
	public memento createMemento();
	public void restoreMemento(memento m);
}
