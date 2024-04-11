
import java.io.Serializable;
import java.util.ArrayList;

class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String userName;
	private String bday;
	// private String password;
	private String phoneNum;
	private String pharmacy;
	private String insurance;
	private int weight;
	private int height;
	private int bodyTemp;
	private int bloodPressure;
	private ArrayList<String> allergies;
	private ArrayList<String> healthConcerns;
	private boolean over12;
	private ArrayList<String> messages;

	public ArrayList<PastVisit> pastVisits;
	public History hist;

	private String docDBFile;
	private String patientDBFile;

	public Patient() {
		fName = "test";
	}

	public Patient(String user, String pass) {
		userName = user;
		// password = pass;
		this.allergies = new ArrayList<String>();
		this.healthConcerns = new ArrayList<String>();
		this.messages = new ArrayList<String>();
		this.pastVisits = new ArrayList<PastVisit>();
		this.hist = new History();
	}

	public Patient(String fNames, String lNames, String userNames, String bdays) {
		fName = fNames;
		lName = lNames;
		userName = userNames;
		bday = bdays;
		this.allergies = new ArrayList<String>();
		this.healthConcerns = new ArrayList<String>();
		this.messages = new ArrayList<String>();
		this.pastVisits = new ArrayList<PastVisit>();
		this.hist = new History();

		docDBFile = "./src/docDB/" + fNames.toLowerCase() + lNames.toLowerCase() + ".txt";
		patientDBFile = "./src/patientDB/" + userNames + ".txt";

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

	// public String getPass() {
	// return password;
	// }

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

	public int getHeight() {
		return height;
	}

	public int getTemp() {
		return bodyTemp;
	}

	public int getPressure() {
		return bloodPressure;
	}

	public ArrayList<String> getAllergies() {
		return allergies;
	}

	public ArrayList<String> getConcerns() {
		return healthConcerns;
	}

	public String getDocDBFile() {
		return docDBFile;
	}

	public String getPatientDBFile() {
		return patientDBFile;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void setFirstName(String fName) {
		this.fName = fName;
	}

	public void setLastName(String lName) {
		this.lName = lName;
	}

	public void setPhone(String num) {
		phoneNum = num;
	}

	public void setPharm(String pharmacy) {
		this.pharmacy = pharmacy;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setTemp(int temp) {
		this.bodyTemp = temp;
	}

	public void setPressure(int pressure) {
		this.bloodPressure = pressure;
	}

	public void addAllergy(String allergy) {
		this.allergies.add(allergy);
	}

	public void addConcern(String concern) {
		this.healthConcerns.add(concern);
	}

	public void addMsg(String msg) {
		this.messages.add(msg);
	}

};
