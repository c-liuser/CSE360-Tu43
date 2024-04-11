import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable{
	private static final long serialVersionUID = 1L;
	public ArrayList<String> healthIssues;
	public ArrayList<String> prescrips;
	public ArrayList<String> immunizations;
	
	public History() {
		healthIssues = new ArrayList<String>();
		prescrips = new ArrayList<String>();
		immunizations = new ArrayList<String>();
	}
	
	public void addIssues(String issue) {
		healthIssues.add(issue);
	}
	
	public void addPrescrip(String prescrip) {
		prescrips.add(prescrip);
	}
	
	public void addImmunizations(String immunization) {
		immunizations.add(immunization);
	}
}
