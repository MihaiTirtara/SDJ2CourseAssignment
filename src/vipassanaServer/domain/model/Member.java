package vipassanaServer.domain.model;

public class Member {
	
	
	private String name;
	private String lastName;
	private boolean payment;
	private int id;
	
	public Member(String name, String lastName, boolean payment,int id) {
		this.name = name;
		this.lastName = lastName;
		this.payment = payment;
		this.id = id;
	}

	public String toString() {
		return "ID."+id+" Name: "+name+" "+lastName+" | Paid: "+payment;
	}
}
