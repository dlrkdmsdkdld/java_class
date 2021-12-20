package StudentPackage;

import TeamPackage.Team;

public class Student extends Member{

	private String major;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Student(int id, String name, Team team, String major) {
		super(id, name, team);
		this.major = major;
	}
	@Override
	protected Object getCompany() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
