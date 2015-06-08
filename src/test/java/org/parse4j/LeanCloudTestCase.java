package org.parse4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class LeanCloudTestCase  {
	
	public static String CLASS_NAME = "parse4j";
	private static String APP_ID = "g0aeaj0c2j5iab43aj7e94ouwqsgvuw6x46986tcu7oaap4x";
	private static String APP_REST_API_ID = "mkmi33s2skg7keg1s126xuzn2hoik464xsgjudq04d9bj927";

	@BeforeClass
	public static void setupParse() {
		System.out.println("setupParse(): initializing...");
		Parse.initialize(APP_ID, APP_REST_API_ID);
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("tearDown(): finalizing...");
		ParseExecutor.getExecutor().shutdown();
		//while(!ParseExecutor.getExecutor().isTerminated()) { }
	}
	
	protected ParseObject getEmptyParseObject(String className) {
		ParseObject parseObject = new ParseObject(className);
		return parseObject;
	}
	
	protected ParseObject getParseObject(String className) {
		ParseObject parseObject = new ParseObject(className);
		parseObject.put("name", "parse developer");
		parseObject.put("int", 10);
		parseObject.put("long", 10l);
		parseObject.put("boolean", true);
		parseObject.put("dob", new Date());
		parseObject.put("double", 10.5);
		
		List<String> types = new ArrayList<String>();
		types.add("type1");
		types.add("type2");
		types.add("type3");
		parseObject.put("types", types);
		
		ParseGeoPoint gp  = new ParseGeoPoint(40.0, -30.0);
		parseObject.put("location", gp);
		
		return parseObject;
	}
	
	protected ParseUser getParseUser(String number) {
		ParseUser parseUser = new ParseUser();
		parseUser.setUsername("parse4j-user" + number);
		parseUser.setPassword("parse4j-password");
		parseUser.setEmail("parse4j-email"+number+"@gmail.com");
		parseUser.put("dob", new Date());
		parseUser.put("city", "westbury");
		parseUser.put("state", "ny");
		return parseUser;
	}
	
	protected void sleep(int millis) {
		try {
			Thread.sleep(millis);
		}
		catch(InterruptedException e) {
			
		}
	}
	
	public byte[] getBytes(String fileName) throws ParseException {
		try {
			RandomAccessFile f = new RandomAccessFile(getClass().getResource(fileName).getFile(), "r");
			byte[] b = new byte[(int)f.length()];
			f.read(b);
			f.close();
			return b;
		}
		catch(IOException e) {
			throw new ParseException(e);
		}
	}
	
}
