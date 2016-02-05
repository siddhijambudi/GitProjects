package com.siddhi.rest.interview_1;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/healthdata")
public class HealthManagementService {
	
	@GET
	@Path("/print")
	public Response getMsg() {
 
		String output = "Jersey say : "; 
		return Response.status(200).entity(output).build();
 	}
	
	@POST
	@Path("/post")
	@Produces("application/json")
	@Consumes("application/json")
	public Patient consumeHealthManagementJSON(PatientQuetionarie patient) { 
		String gender = patient.getBiometricsQuestionnaire().getGender();
		Integer ageWhenBeganSmoking = patient.getDietQuestionnaire().getAgeWhenBeganSmoking();
		
		Patient patientResult = new Patient();
		//add more validations as below 
		if((gender.equals("male") || gender.equals("female"))){
			patientResult.setResult("valid");
		}
		return patientResult; 
	}	
}
