package com.siddhi.rest.interview_1;

public class PatientQuetionarie {
	
	private PatientHabit	dietQuestionnaire;
	private PatientHabit	smokingQuestionnaire;
	private PatientHabit biometricsQuestionnaire;
	
	public PatientQuetionarie(){}
	
	public PatientQuetionarie(PatientHabit dietQuestionnaire,
			PatientHabit smokingQuestionnaire,
			PatientHabit biometricsQuestionnaire) {
		super();
		this.dietQuestionnaire = dietQuestionnaire;
		this.smokingQuestionnaire = smokingQuestionnaire;
		this.biometricsQuestionnaire = biometricsQuestionnaire;
	}
	public PatientHabit getDietQuestionnaire() {
		return dietQuestionnaire;
	}
	public void setDietQuestionnaire(PatientHabit dietQuestionnaire) {
		this.dietQuestionnaire = dietQuestionnaire;
	}
	public PatientHabit getSmokingQuestionnaire() {
		return smokingQuestionnaire;
	}
	public void setSmokingQuestionnaire(PatientHabit smokingQuestionnaire) {
		this.smokingQuestionnaire = smokingQuestionnaire;
	}
	public PatientHabit getBiometricsQuestionnaire() {
		return biometricsQuestionnaire;
	}
	public void setBiometricsQuestionnaire(PatientHabit biometricsQuestionnaire) {
		this.biometricsQuestionnaire = biometricsQuestionnaire;
	}
	
	
	
}
