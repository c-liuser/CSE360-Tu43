package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseManager {
  private String loginDB = "./src/loginDB.txt";
  private String patientDB = "./src/patientDB/";
  private String docDB = "./src/docDB/";
  
  public DatabaseManager() {
    
  }
  
  public void addUserToLogin(String prefix, String username, String password) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(loginDB, true));
      writer.append(prefix + username +" "+ password + '\n');
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  public void createInPatientDB(String username, String fName, String lName, String bday) {
    try {
      String data = "Username:\n"
          + username
          + "\n\n"
          + "First Name:\n"
          + fName
          + "\n\n"
          + "Last Name:\n"
          + lName
          + "\n\n"
          + "Birthday:\n"
          + bday
          + "\n\n"
          + "Phone Number:\n"
          + "None"
          + "\n\n"
          + "History\n\n"
          + "Health Issue:\n"
          + "None"
          + "\n\n"
          + "Precriptions:\n"
          + "None"
          + "\n\n"
          + "Immunization History:\n"
          + "None"
          + "\n\n"
          + "Past Visits\n\n"
          + "Findings:\n"
          + "None"
          + "\n\n"
          + "New prescriptions:\n"
          + "None"
          + "\n\n"
          + "past visits done\n";
      File myObj = new File(patientDB + username+".txt");
      myObj.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(patientDB + username+".txt", true));
      writer.append(data);
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }
  
  public void createInDocDB(String username, String fName, String lName, String bday) {
    try {
      String data ="Username:\n"
          + username
          + "\n\n"
          + "First Name:\n"
          + fName
          + "\n\n"
          + "Last Name:\n"
          + lName
          + "\n\n"
          + "Birthday:\n"
          + bday
          + "\n\n"
          + "Phone Number:\n"
          + "None"
          + "\n\n"
          + "Weight:\n"
          + "None"
          + "\n\n"
          + "Body Temperature:\n"
          + "None"
          + "\n\n"
          + "Blood Pressure:\n"
          + "None"
          + "\n\n"
          + "History"
          + "\n\n"
          + "Health Issue:\n"
          + "None"
          + "\n\n"
          + "Precriptions:\n"
          + "None"
          + "\n\n"
          + "Immunization History:\n"
          + "None"
          + "\n\n"
          + "Past Visits\n"
          + "\n"
          + "Findings:\n"
          + "None"
          + "\n\n"
          + "New prescriptions:\n"
          + "None"
          + "\n\n"
          + "past visits done\n";
      File myObj = new File(docDB + fName.toLowerCase() + lName.toLowerCase() +".txt");
      myObj.createNewFile();
      BufferedWriter writer = new BufferedWriter(new FileWriter(docDB + fName.toLowerCase() + lName.toLowerCase() +".txt", true));
      writer.append(data);
      writer.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  
}
