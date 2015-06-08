package org.parse4j;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;

import org.junit.Test;
import org.parse4j.callback.FunctionCallback;

public class LeanCloudReadTestCase  extends LeanCloudTestCase {

	/*
		Parse.Cloud.define("helloWorld", function(request, response) {
		  response.success("Hello, " + request.params.name + "!!!");
		});
	
		Parse.Cloud.define("Multiply", function(request, response) {
		  response.success(request.params.A * request.params.B);
		});
	
		Parse.Cloud.define("ForcedError", function(request, response) {
		  response.error("forced error");
		});
	*/
	
	@Test
	public void testInvalidFunction() {
		System.out.println("InvalidFunction(): initializing...");
	
	}	
	
	
	
}

