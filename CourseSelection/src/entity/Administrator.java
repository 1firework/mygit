package entity;

public class Administrator implements IEntity{
	private String administratorID;
	private String administratorName;
	private String administratorGender;
	private int administratorAge;
	private String administratorDepartment;
	private String administratorPassword;
	
	public String getAdministratorID() {
		return administratorID;
	}
	public void setAdministratorID(String administratorID) {
		this.administratorID=administratorID;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName=administratorName;
	}
	public String getStudentGender() {
		return administratorGender;
	}
	public void setAdministratorGender(String administratorGender) {
		this.administratorGender=administratorGender;
	}
	public int getAdministratorAge() {
		return administratorAge;
	}
	public void setAdministratorAge(int administratorAge) {
		this.administratorAge=administratorAge;
	}
	public String getAdministratorDepartment() {
		return administratorDepartment;
	}
	public void setAdministratorDepartment(String administratorDepartment) {
		this.administratorDepartment=administratorDepartment;
	}
	public String getAdministratorPasswprd() {
		return administratorDepartment;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorDepartment=administratorPassword;
	}
}
