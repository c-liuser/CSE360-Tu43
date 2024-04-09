package cse360;

import java.util.*;

class UserList{
	ArrayList<Doctor> doctors;
	ArrayList<Nurse> nurses;
	ArrayList<Patient> patients;

	public UserList() {
		doctors = new ArrayList<Doctor>();
		nurses = new ArrayList<Nurse>();
		patients = new ArrayList<Patient>();
	}
	
	public boolean valid(String user, String pass) {
		boolean exists = false;
		
		for(int i = 0; i < doctors.size(); i++) {
			if((doctors.get(i).userName).equals(user) && (doctors.get(i).password).equals(pass)) {
				exists = true;
			}
		}
		for(int i = 0; i < nurses.size(); i++) {
			if((nurses.get(i).userName).equals(user) && (nurses.get(i).password).equals(pass)) {
				exists = true;
			}
		}
		for(int i = 0; i < patients.size(); i++) {
			if((patients.get(i).userName).equals(user) && (patients.get(i).password).equals(pass)) {
				exists = true;
			}
		}
		
		return exists;
	}
	
	public void addPatient(Patient patient) {
		patients.add(patient);
	}
	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
	public void addNurse(Nurse nurse) {
		nurses.add(nurse);
	}
	
};
