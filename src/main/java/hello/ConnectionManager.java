package hello;

import java.util.EmptyStackException;
import java.util.concurrent.atomic.AtomicLong;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionManager {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private DatabaseManager databaseManager =  new DatabaseManager();
    private PutDispatcher putDispatcher = new PutDispatcher();
	
	@RequestMapping(value= {"/device"}, method=RequestMethod.POST)
    public ResponseEntity<HomeServerResponse> updateDevice(@RequestBody HomeServerRequest homeServerRequest){
    	try{
    		verifyInput(homeServerRequest);
    		validateMessage(homeServerRequest);
    	}catch (Exception e) {
    		return new ResponseEntity<HomeServerResponse>(new HomeServerResponse(e), HttpStatus.UNAUTHORIZED);
    	}
		putDispatcher.notify(homeServerRequest);
    	executeAction(homeServerRequest);
        return new ResponseEntity<HomeServerResponse>(new HomeServerResponse("aMessage"), HttpStatus.OK);
    }



	@RequestMapping(value= {"/device"}, method={RequestMethod.GET})
    public ResponseEntity<HomeServerResponse> getDeviceStatus(@RequestParam(value="homeServerID") String homeServerID,
    		@RequestParam(value="userName") String userName,
    		@RequestParam(value="userPassword") String userPassword,
    		@RequestParam(value="homeServerPassword") String homeServerPassword,
    		@RequestParam(value="device") String device,
    		@RequestParam(value="action") String action,
    		@RequestParam(value="value") String value){
    	try{
    		verifyInput(homeServerID, homeServerPassword, userName, userPassword, device, action, value);
    		validateHomeServerCredentials(homeServerID, homeServerPassword);  	
    		ValidateUserCredentials(userName, userPassword);
    	}catch (Exception e) {
    		return new ResponseEntity<HomeServerResponse>(new HomeServerResponse(e), HttpStatus.UNAUTHORIZED);
    	}
    	//interception Point
    	executeAction(new HomeServerRequest());
        return new ResponseEntity<HomeServerResponse>(new HomeServerResponse("aMessage"), HttpStatus.OK);
    }
	
	private void verifyInput(HomeServerRequest homeServerRequest) throws IllegalAccessException {
		if(homeServerRequest == null || !(homeServerRequest.isValidRequest()))
			throw new IllegalAccessException("Invalid input: Fields Not All Present");
	}
	
	private void verifyInput(String homeServerID, String homeServerPassword, 
			String userName, String userPassword, String device, String action, String value) throws IllegalAccessException {
		if(homeServerID == null || userName == null || userPassword == null || homeServerPassword == null
				|| device == null || action == null || value == null)			
			throw new IllegalAccessException("Invalid input: Fields Not All Present");
	}
	
    private void validateMessage(HomeServerRequest homeServerRequest) throws IllegalAccessException{
    	validateHomeServerCredentials(homeServerRequest.getHomeServerID(), homeServerRequest.getHomeServerPassword());
		ValidateUserCredentials(homeServerRequest.getUserName(), homeServerRequest.getUserPassword());	
	}

    private void validateHomeServerCredentials(String homeServerID, String homeServerPassword) throws IllegalAccessException{
		if (!databaseManager.validateHomeServerCredentials(homeServerID, homeServerPassword)) 
			throw new IllegalAccessException("Invalid homeServer Credentials");
	}

    private void ValidateUserCredentials(String userName, String userPassword) throws IllegalAccessException{
		if (!databaseManager.validateUserCredentials(userName, userPassword)) 
			throw new IllegalAccessException("Invalid User Credentials");
    }

	private void executeAction(HomeServerRequest homeServerRequest) {

		
	}

    public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public void setDatabaseManager(DatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}
}
