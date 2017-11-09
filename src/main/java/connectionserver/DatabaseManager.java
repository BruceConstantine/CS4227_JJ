package connectionserver;

import static org.hamcrest.CoreMatchers.instanceOf;

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
		BasicAWSCredentials credsa = new BasicAWSCredentials("AKIAJEA5BSRQX7CS7VEQ", "PkV3fl7Zb+naYLkCiDpGwBdXfj5ny6FUKm70G5V6"); 
		AmazonS3 s3Clienta = AmazonS3ClientBuilder.standard().withCredentials(
        		new AWSStaticCredentialsProvider(credsa)).build();      
		S3Object object = s3Clienta.getObject(
		                  new GetObjectRequest("PkV3fl7Zb+naYLkCiDpGwBdXfj5ny6FUKm70G5V6", "key"));
		InputStream objectData = object.getObjectContent();
		// Process the objectData stream.
		try {
			objectData.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1.toString());
		}
		
//        ClassLoader classLoader = getClass().getClassLoader();
//        File output = new File(classLoader.getResource("USER_IP").getFile());
//		try {     
//			@SuppressWarnings("resource")
//			FileWriter fileWriter = new FileWriter(output);
//			fileWriter.write("\"" + userID + "\": \"" + ipAddress + "\"");
//			BasicAWSCredentials creds = new BasicAWSCredentials("AKIAJEA5BSRQX7CS7VEQ", 
//					"PkV3fl7Zb+naYLkCiDpGwBdXfj5ny6FUKm70G5V6"); 
//	        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(
//	        		new AWSStaticCredentialsProvider(creds)).build();
//	        
//	        String bucketName = "storeuserip";
//			String keyName = "AKIAJEA5BSRQX7CS7VEQ";
//			s3Client.putObject(new PutObjectRequest(
//	                bucketName, keyName, output));
//		} catch (Exception e) {
//			throw new RuntimeException(e.toString());
//		}
	}
}
