package maildata;

public class groupdata {
	String group;
	int groupid;
	
	public groupdata(int groupid,String group) {
		this.groupid=groupid;
		this.group=group;
	}
	public int getgroupid() {
		return groupid;
	}
	public String getgroup() {
		return group;
	}

}
