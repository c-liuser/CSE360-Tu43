package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DatabaseManager {
  private String loginDB = "" + System.getProperty("user.dir") + "/src/application/loginDB.txt";
  private String patientDB = "" + System.getProperty("user.dir") + "/src/application/patientDB/";
  private String docDB = "" + System.getProperty("user.dir") + "/src/application/docDB/";

  public DatabaseManager() {

  }

  public void addUserToLogin(String prefix, String username, String password) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(loginDB, true));
      writer.append(prefix + username + " " + password + '\n');
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void createInPatientDB(String username, String fName, String lName, String bday) {
    try {
      ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(patientDB + username + ".txt"));
      Patient patient = new Patient(fName, lName, username, bday);
      outputStream.writeObject(patient);
      System.out.println("Successfully wrote to the file.");
      outputStream.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void createInDocDB(String username, String fName, String lName, String bday) {
    try {
      ObjectOutputStream outputStream = new ObjectOutputStream(
          new FileOutputStream(docDB + fName.toLowerCase() + lName.toLowerCase() + ".txt"));
      Patient patient = new Patient(fName, lName, username, bday);
      outputStream.writeObject(patient);
      System.out.println("Successfully wrote to the file.");
      outputStream.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  public Patient readPatientFile(String filePath) {
    Patient patient = null;
    try {
      ObjectInputStream oit = new ObjectInputStream(new FileInputStream(filePath));
      try {
        patient = (Patient) oit.readObject();
        System.out.println("Read Patient");
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return patient;
  }
  
  public void editPatientFile(Patient p) {
    try {
      ObjectOutputStream outputStream = new ObjectOutputStream(
          new FileOutputStream(p.getDocDBFile()));
      outputStream.writeObject(p);
      System.out.println("Successfully wrote to the file.");
      outputStream.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    try {
      ObjectOutputStream outputStream = new ObjectOutputStream(
          new FileOutputStream(p.getPatientDBFile()));
      outputStream.writeObject(p);
      System.out.println("Successfully wrote to the file.");
      outputStream.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

}
