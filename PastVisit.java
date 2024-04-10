

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class PastVisit implements Serializable {
  private static final long serialVersionUID = 1L;
  public String findings;
  public ArrayList<String> prescriptions;
  
  public PastVisit() {
    findings = "";
    prescriptions = new ArrayList<String>();
  }
  
  public void changeFindings(String found) {
    findings = found;
  }
  
  public void addPrescription(String pre) {
    prescriptions.add(pre);
  }
  
  public ArrayList<PastVisit> getPastVisits(File f){
    int amountOfPastVisits = 0;
    PastVisit temp;
    ArrayList<PastVisit> pastVisits = new ArrayList<PastVisit>();
    try {
      FileReader fr = new FileReader(f);
      BufferedReader br = new BufferedReader(fr);
      String check = "1";
      //goes down to past visit in file
      while(!check.equals("Past Visits")) {
        check = br.readLine();
      }
      while(!check.equals("past visits done")) {
        while(!check.equals("Findings:")) {
          check = br.readLine();
        }
        pastVisits.add(new PastVisit());
        temp = pastVisits.get(amountOfPastVisits);
        temp.findings = br.readLine();
        
        while(!check.equals("New prescriptions:")) {
          check = br.readLine();
        }
        while(!check.equals("")) {
          check = br.readLine();
          temp.prescriptions.add(check);
        }
        check = br.readLine();
        amountOfPastVisits++;
      }
      br.close();
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 

    return pastVisits;
  }
}
