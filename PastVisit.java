import java.io.File;
import java.util.ArrayList;

public class PastVisit {
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

}
