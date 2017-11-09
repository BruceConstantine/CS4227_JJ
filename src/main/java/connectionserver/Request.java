package connectionserver;

public class Request {
	private String homeServerID;
	private String homeServerPassword;
	private String userName;
	private String userPassword;
	private String device;
	private String action;
	private String value;
	
	public String getHomeServerID() {
		return homeServerID;
	}
	public void setHomeServerID(String homeServerID) {
		this.homeServerID = homeServerID;
	}
	public String getHomeServerPassword() {
		return homeServerPassword;
	}
	public void setHomeServerPassword(String homeServerPassword) {
		this.homeServerPassword = homeServerPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
