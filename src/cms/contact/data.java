package cms.contact;


public class data {
	
	public String name;
	public String email;
	public String group;
	public int groupid;
    public data(String name, String email) {
    	this.name=name;this.email=email;
    }
    
}
class basiccontact extends data{

	public basiccontact(String name, String email) {
		super(name, email);
	}
	
}
class fulldata extends data{
	public String address;
	public fulldata(String name, String email,String address) {
		super(name, email); this.address=address;
		// TODO Auto-generated constructor stub
	}
	public String backaddress() {
		return address;
	}

	
	
}
