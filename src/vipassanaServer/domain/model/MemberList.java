package vipassanaServer.domain.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MemberList implements Serializable{

	ArrayList<Member> members;
	
	public MemberList() {
		members = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		members.add(member);
	}
	
	public Member[] getMembers() {
		Member[] memberRet = members.toArray(new Member[members.size()]);
		return memberRet;
	}
	
	public String toString() {
		String returnString = "";
		
		for (int i=0;i<members.size();i++) {
			returnString += members.get(i).toString()+"\n";
		}
		
		return returnString;
	}
	
	
}
