
class Patient {
	String fName;
	String lName;
	String userName;
	String bday;
	String password;
	String phoneNum;
	String pharmacy;
	String insurance;
	int weight;
	int height;
	int bodyTemp;
	int bloodPressure;
	String[] allergies;
	String[] healthConcerns;
	boolean over12;
	String[] history;
	String[] medications;
	String[] immunizations;

	public Patient() {
		fName = "test";
	}

	public Patient(String user, String pass) {
		userName = user;
		password = pass;
	}

	public Patient(String fNames, String lNames, String userNames, String bdays, String passwords, String phoneNums) {
		fName = fNames;
		lName = lNames;
		userName = userNames;
		bday = bdays;
		password = passwords;
		phoneNum = phoneNums;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public String getUser() {
		return userName;
	}

	public String getBday() {
		return bday;
	}

	public String getPass() {
		return password;
	}

	public String getPhone() {
		return phoneNum;
	}

	public String getPharm() {
		return pharmacy;
	}

	public String getInsurance() {
		return insurance;
	}

	public int getWeight() {
		return weight;
	}

	public int getTemp() {
		return bodyTemp;
	}

	public int getPressure() {
		return bloodPressure;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public String[] getConcerns() {
		return healthConcerns;
	}

	public String[] getHist() {
		return history;
	}

	public String[] getMeds() {
		return medications;
	}

	public String[] getImmun() {
		return immunizations;
	}

	public void setPhone(String num) {
	}

	public void setPharm(String pharmacy) {
	}

	public void setInsurance(String insurance) {
	}

	public void setWeight(int weight) {
	}

	public void setHeight(int height) {
	}

	public void setTemp(int temp) {
	}

	public void setPressure(int pressure) {
	}

	public void setAllergies(String[] allergies) {
	}

	public void setConcerns(String[] concerns) {
	}

	public void addHist(String data) {
	}

	public void addMeds(String medication) {
	}

	public void addImmun(String immun) {
	}

};
