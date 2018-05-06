package vipassanaServer.domain.mediator;

import java.sql.SQLException;
import java.util.ArrayList;

import utility.persistence.MyDatabase;

public class DBS implements DbsPersistance  {

private MyDatabase dbs;
	
	public DBS()  {
		
	}
	
	public void addMember(String name, String lastName, boolean payment) throws SQLException {
		// quering the database
			
		
	}

	@Override
	public ArrayList<Object[]> getMembers() {
		
		ArrayList<Object[]> array = new ArrayList<Object[]>();
		Object[] e = {"Malaga","Piechota",true,3};
		Object[] a = {"Jakub","White",false,4};
		Object[] b = {"Priss","Brown",true,1};
		Object[] c = {"Tom","Brwon",true,2};
		Object[] d = {"Dan","Trees",false,5};
		array.add(e);
		array.add(a);
		array.add(b);
		array.add(c);
		array.add(d);
		return array;
	}

	@Override
	public ArrayList<Object[]> getNotPaidMembers() {
		ArrayList<Object[]> array = new ArrayList<Object[]>();
		Object[] e = {"Malaga","Piechota",false,9};
		Object[] a = {"Jakub","White",false,4};
		Object[] b = {"Chris","Brown",false,7};
		Object[] c = {"Eric","Brwon",false,8};
		Object[] d = {"Dan","Trees",false,5};
		array.add(e);
		array.add(a);
		array.add(b);
		array.add(c);
		array.add(d);
		return array;
	}
	
		
		
	

}
