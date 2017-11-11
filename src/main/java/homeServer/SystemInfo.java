package homeServer;

public class SystemInfo extends AbstractLogger {

	public SystemInfo(int level){
		this.level = level;
	}
	
	@Override
	protected void write(String message) {		
		System.out.println("[Notice] " + message);
	}
}