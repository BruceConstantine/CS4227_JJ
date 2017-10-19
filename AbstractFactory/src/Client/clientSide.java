package Client;
import Factory.*;
import Devices.*;
import Sensors.*;

public class clientSide {
	public static void main(String []agrs){
		AbstractFactory af = new PhilipsFactory();
		I_Light light = af.createLight("light1");
		light.show();
	}
}
