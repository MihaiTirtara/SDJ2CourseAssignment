package vipassanaServer.domain.mediator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

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
			System.out.println(sql);
			dbs.query(sql, name, lastName, payment);
			System.out.println(sql);
		
	}
	
	

	
	
		
		
	

}
