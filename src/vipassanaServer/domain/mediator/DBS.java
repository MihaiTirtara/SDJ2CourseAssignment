package vipassanaServer.domain.mediator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.persistence.MyDatabase;

public class DBS implements DbsPersistance  {

private MyDatabase dbs;
	
	public DBS()  {
		try {
			dbs = new MyDatabase("org.postgresql.Driver",
					"jdbc:postgresql://localhost:5432/vipassanaMembers", "postgres", "hTrEa9982231");
		} catch (ClassNotFoundException e) {
			
			e.getMessage();
		}
	}
	
	public void addMember(String name, String lastName, boolean payment) throws SQLException {
		String sql = "INSERT INTO public.members values (?, ?, ?)";
			
			dbs.update(sql, name, lastName, payment);
			
		
	}

	@Override
	public ArrayList<Object[]> getMembers() {
		String sql = "select name, lastname, payment, idno from members";
		ArrayList<Object[]> array = null;
		try {
			array = dbs.query(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public ArrayList<Object[]> getNotPaidMembers() {
		String sql = "select name, lastname, payment, idno from members where (payment=?)";
		ArrayList<Object[]> array = null;
		try {
			array = dbs.query(sql, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	public ArrayList<Object[]> getMembersNotPay() {
		String sql = "select name, lastname, payment, idno from members when payment='false'";
		ArrayList<Object[]> array = null;
		try {
			array = dbs.query(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
	
	

	
	
		
		
	

}
