package connectionserver;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class RegisterHomeServerIP implements RequestHandler<Map<String, Object>, Map<String, Object>> {

	DatabaseManager dbManager =  new DatabaseManager();
	@Override
	public Map<String, Object> handleRequest(Map<String, Object> input, 
			Context context){
		this.verifyInputKeys(input);
		this.validateCredentials(input);
		this.storeUserIP(input);
		return this.generateResponse(input);
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

	private void storeUserIP(Map<String, Object> input) throws RuntimeException {
		dbManager.storeIP((String)input.get("userID"), (String) input.get("value"));
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
   