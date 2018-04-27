package vipassanaServer.domain.mediator;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DbsPersistance {
	
	public void addMember(String name, String lastName, boolean payment) throws SQLException;
	public ArrayList<Object[]> getMembers();
	public ArrayList<Object[]> getNotPaidMembers();
}
