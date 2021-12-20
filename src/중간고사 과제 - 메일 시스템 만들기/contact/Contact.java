package cms.contact;
import cms.group.*;
public abstract class Contact {

	private String name;
	private String email;
	private group group;
	public Contact(String name, String email,group group) {
		this.group=group;
		this.name=name;
		this.email=email;	
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGroup() {
		return group.getGroupName();
	}

	public void setGroup(group group) {
		this.group = group;
	}
}
 