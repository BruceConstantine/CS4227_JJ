package hello;

public class HomeServerResponse {

	private String homeServerID;
	private String homeServerKey;
	private String homeServerMessage = "";
	
	public HomeServerResponse(Exception e) {
		homeServerMessage = e.toString();
	}

	public HomeServerResponse() {
	}

	public HomeServerResponse(String homeServerMessage) {
		setHomeServerMessage(homeServerMessage);
	}

	public String getHomeServerID() {
		return homeServerID;
	}

	public void setHomeServerID(String homeServerID) {
		this.homeServerID = homeServerID;
	}

	public String getHomeServerKey() {
		return homeServerKey;
	}

	public void setHomeServerKey(String homeServerKey) {
		this.homeServerKey = homeServerKey;
	}

	public String getHomeServerMessage() {
		return homeServerMessage;
	}

	public void setHomeServerMessage(String homeServerMessage) {
		this.homeServerMessage = homeServerMessage;
	}

}
