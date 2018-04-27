package vipassanaServer.domain.mediator;

import java.sql.SQLException;

public interface DbsPersistance {
	
	public void addMember(String name, String lastName, boolean payment) throws SQLException;

}
