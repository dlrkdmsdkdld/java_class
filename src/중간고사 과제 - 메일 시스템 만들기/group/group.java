package cms.group;

public class group {

	String groupName;
    int id;
	public String getGroupName() {
		return groupName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public group(String groupName,int id) {
		this.groupName=groupName;
		this.id=id;
	}


}
