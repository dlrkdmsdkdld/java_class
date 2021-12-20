package cms.contact;

public class FullContact extends Contact {

	String addr;
	public FullContact(String name, String email, cms.group.group group,String addr) {
		super(name, email, group);
		this.addr=addr;
		// TODO Auto-generated constructor stub
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	

}
