
package com.siddhi.rest.interview_1;


public class PatientHabit {
	Integer weeklyServingsVegetables;
	Integer weeklyServingsWholeGrains;
	Integer weeklyServingsFruits;
	Boolean isVegetarian;
	Integer weeklyServingsMeat;
	
	Boolean isCurrentSmoker;
	Integer weeklyCigarettesSmoked;
	Integer ageWhenBeganSmoking;
	
	Integer height;
	Integer weight;
	Integer systolicBloodPressure;
	Integer diastolicBloodPressure;
	String gender;
	
	public PatientHabit()
	{

	}
	
	public PatientHabit(Integer weeklyServingsWholeGrains,
			Boolean isVegetarian, Integer ageWhenBeganSmoking,
			Integer weeklyServingsMeat, Integer weeklyServingsFruits,
			Integer weight, Boolean isCurrentSmoker,
			Integer systolicBloodPressure, Integer weeklyCigarettesSmoked,
			String gender, Integer height, Integer weeklyServingsVegetables,
			Integer diastolicBloodPressure) {
		super();
		this.weeklyServingsWholeGrains = weeklyServingsWholeGrains;
		this.isVegetarian = isVegetarian;
		this.ageWhenBeganSmoking = ageWhenBeganSmoking;
		this.weeklyServingsMeat = weeklyServingsMeat;
		this.weeklyServingsFruits = weeklyServingsFruits;
		this.weight = weight;
		this.isCurrentSmoker = isCurrentSmoker;
		this.systolicBloodPressure = systolicBloodPressure;
		this.weeklyCigarettesSmoked = weeklyCigarettesSmoked;
		this.gender = gender;
		this.height = height;
		this.weeklyServingsVegetables = weeklyServingsVegetables;
		this.diastolicBloodPressure = diastolicBloodPressure;
	}
	@Override
	public String toString() {
		return "PatientHabit [weeklyServingsVegetables="
				+ weeklyServingsVegetables + ", weeklyServingsWholeGrains="
				+ weeklyServingsWholeGrains + ", weeklyServingsFruits="
				+ weeklyServingsFruits + ", isVegetarian=" + isVegetarian
				+ ", weeklyServingsMeat=" + weeklyServingsMeat
				+ ", isCurrentSmoker=" + isCurrentSmoker
				+ ", weeklyCigarettesSmoked=" + weeklyCigarettesSmoked
				+ ", ageWhenBeganSmoking=" + ageWhenBeganSmoking + ", height="
				+ height + ", weight=" + weight + ", systolicBloodPressure="
				+ systolicBloodPressure + ", diastolicBloodPressure="
				+ diastolicBloodPressure + ", gender=" + gender + "]";
	}
	public Integer getWeeklyServingsVegetables() {
		return weeklyServingsVegetables;
	}
	public void setWeeklyServingsVegetables(Integer weeklyServingsVegetables) {
		this.weeklyServingsVegetables = weeklyServingsVegetables;
	}
	public Integer getWeeklyServingsWholeGrains() {
		return weeklyServingsWholeGrains;
	}
	public void setWeeklyServingsWholeGrains(Integer weeklyServingsWholeGrains) {
		this.weeklyServingsWholeGrains = weeklyServingsWholeGrains;
	}
	public Integer getWeeklyServingsFruits() {
		return weeklyServingsFruits;
	}
	public void setWeeklyServingsFruits(Integer weeklyServingsFruits) {
		this.weeklyServingsFruits = weeklyServingsFruits;
	}
	public Boolean getIsVegetarian() {
		return isVegetarian;
	}
	public void setIsVegetarian(Boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	public Integer getWeeklyServingsMeat() {
		return weeklyServingsMeat;
	}
	public void setWeeklyServingsMeat(Integer weeklyServingsMeat) {
		this.weeklyServingsMeat = weeklyServingsMeat;
	}
	public Boolean getIsCurrentSmoker() {
		return isCurrentSmoker;
	}
	public void setIsCurrentSmoker(Boolean isCurrentSmoker) {
		this.isCurrentSmoker = isCurrentSmoker;
	}
	public Integer getWeeklyCigarettesSmoked() {
		return weeklyCigarettesSmoked;
	}
	public void setWeeklyCigarettesSmoked(Integer weeklyCigarettesSmoked) {
		this.weeklyCigarettesSmoked = weeklyCigarettesSmoked;
	}
	public Integer getAgeWhenBeganSmoking() {
		return ageWhenBeganSmoking;
	}
	public void setAgeWhenBeganSmoking(Integer ageWhenBeganSmoking) {
		this.ageWhenBeganSmoking = ageWhenBeganSmoking;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getSystolicBloodPressure() {
		return systolicBloodPressure;
	}
	public void setSystolicBloodPressure(Integer systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}
	public Integer getDiastolicBloodPressure() {
		return diastolicBloodPressure;
	}
	public void setDiastolicBloodPressure(Integer diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
