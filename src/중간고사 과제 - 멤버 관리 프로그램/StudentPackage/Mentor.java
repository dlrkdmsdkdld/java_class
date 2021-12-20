package StudentPackage;

import TeamPackage.Team;

public class Mentor extends Member{

	String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Mentor(int id, String name, Team team, String company) {
		super(id, name, team);
		this.company = company;
	}

	@Override
	protected Object getMajor() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	
}
