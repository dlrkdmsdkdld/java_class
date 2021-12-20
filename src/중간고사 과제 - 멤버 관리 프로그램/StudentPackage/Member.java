package StudentPackage;

import TeamPackage.Team;

public abstract class Member {
	private int id;
	private String name;
	private Team team;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeam() {
		return team.getName();
	}
	public Member(int id, String name, Team team) {
		this.id = id;
		this.name = name;
		this.team = team;
	}
	protected abstract Object getMajor();
	protected abstract Object getCompany();
}
