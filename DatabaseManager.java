import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DatabaseManager {
  private String loginDB = "./src/loginDB.txt";
  private String patientDB = "./src/patientDB/";
  private String docDB = "./src/docDB/";

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

}
