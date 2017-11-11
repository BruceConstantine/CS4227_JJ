package connectionserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MessageRelay implements RequestHandler<Map<String, Object>, Map<String, Object>> {

	DatabaseManager dbManager =  new DatabaseManager();
	@Override
	public Map<String, Object> handleRequest(Map<String, Object> input, 
			Context context){
		this.verifyInputKeys(input);
		this.validateCredentials(input);
		Map<String, Object> output = new HashMap<String, Object>();
		output.put("DELIVERY_STATUS",relayMessage(input, this.retrieveUserIP(input)));
		return output;
	}

	private String relayMessage(Map<String, Object> input, String userIP) {
		return sendPost(input, userIP, "/device");
	}
	
	private String sendPost(Map<String, Object> input, String ipaddress, String urlParts)  {
		StringBuffer response;
		try {
		URL obj = new URL(ipaddress + urlParts);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");		

		
		
		String message = "{this,}";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(message);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + ipaddress + urlParts);
		//System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		 response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print result

		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
		return response.toString();
	}

	private void verifyInputKeys(Map<String, Object> input) throws RuntimeException {
		// Check for all keys
		if ( !input.containsKey("homeServerID"))
			throw new RuntimeException("[BadRequest] Required Key Error: Missing homeServerID.");
		if ( !input.containsKey("homeServerPassword"))
			throw new RuntimeException("[BadRequest] Required Key Error: Missing homeServerPassword.");
		if ( !input.containsKey("userID"))
			throw new RuntimeException("[BadRequest] Required Key Error: Missing userID.");
		if ( !input.containsKey("userPassword"))
			throw new RuntimeException("[BadRequest] Required Key Error: Missing userPassword.");
		if ( !input.containsKey("value"))
			throw new RuntimeException("[BadRequest] Required Key Error: Missing value.");
		if ( !input.containsKey("action"))
			throw new RuntimeException("[BadRequest] Required Key Error: Missing action.");
	}

	private void validateCredentials(Map<String, Object> input) throws RuntimeException {
		if(!dbManager.validateHomeServerCredentials((String)(input.get("homeServerID")),
				(String) (input.get("homeServerPassword"))))
			throw new RuntimeException("Invalid homeserver credintials");
		if(!dbManager.validateUserCredentials((String)(input.get("userID")),
				(String) (input.get("userPassword"))))
			throw new RuntimeException("Invalid user credintials");
	}

	private String retrieveUserIP(Map<String, Object> input) {
		return dbManager.retriveIP((String) input.get("userID"));
	}
	
	private Map<String, Object> generateResponse(Map<String, Object> input) {
		Map<String, Object> output = new HashMap<String, Object>();
		output.put("homeServerID", input.get("homeServerID"));
		output.put("homeServerPassword", input.get("homeServerPassword"));
		output.put("userID", input.get("userID"));
		output.put("userPassword", input.get("userPassword"));
		output.put("device", "HOMESERVER");
		output.put("action", "UPDATE_IP_STATUS");
		output.put("value", "IP_STORED_ONLINE");
		return output;
	}
}
