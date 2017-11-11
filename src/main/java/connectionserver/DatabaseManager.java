package connectionserver;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.tools.JavaCompiler;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class DatabaseManager {


	public boolean validateHomeServerCredentials(String homeServerID, String homeServerPassword) {
		//Make call to database
		if(homeServerID.equals("MurphysServer") && homeServerPassword.equals("homeServerPassword"))
			return true;
		return false;
	}

	public boolean validateUserCredentials(String userName, String userPassword) {
		if(userName.equals("Murphy") && userPassword.equals("userPassword"))
			return true;
		return false;
	}

	public void storeIP(String userID, String ipAddress) {  		
        ClassLoader classLoader = getClass().getClassLoader();
        File output = new File("/tmp/temp");
		try {     
			FileWriter fileWriter = new FileWriter(output);
			fileWriter.write("" + userID + ":" + ipAddress + "");			
			fileWriter.close();
			BasicAWSCredentials creds = new BasicAWSCredentials("AKIAJEA5BSRQX7CS7VEQ", 
					"PkV3fl7Zb+naYLkCiDpGwBdXfj5ny6FUKm70G5V6"); 
	        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(
	        		new AWSStaticCredentialsProvider(creds)).build();
			s3Client.putObject(new PutObjectRequest(
					"storeuserip", "USER_IP", output));
		} catch (Exception e) {
			throw new RuntimeException(e.toString());
		}
	}
	
	public String retriveIP(String userID) {  			
		String stringIP =  "";
		BasicAWSCredentials creds = new BasicAWSCredentials("AKIAJEA5BSRQX7CS7VEQ", "PkV3fl7Zb+naYLkCiDpGwBdXfj5ny6FUKm70G5V6"); 
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(
        		new AWSStaticCredentialsProvider(creds)).build();      
		S3Object object = s3Client.getObject(
		                  new GetObjectRequest("storeuserip", "USER_IP"));
		InputStream objectData = object.getObjectContent();
		int in = 0;
		char inchar;
		try {
			while((in =  objectData.read()) != -1) {
				inchar = (char) in;
				stringIP += inchar;
			}
		} catch (IOException e) {
			throw new RuntimeException(e.toString());
		}
		stringIP = stringIP.substring(stringIP.indexOf(":")+1);
		return  stringIP;
	}
}
