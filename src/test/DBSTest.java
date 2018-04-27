package test;

import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import vipassanaClient.domain.mediator.ClientModelManager;
import vipassanaServer.domain.mediator.DBS;
import vipassanaServer.domain.mediator.ServerModelManager;

class DBSTest {
	
	
	@BeforeEach
	void createDbs(){
	}

//	@Test
//	void testDbs() {
//		try {
//			dbs.addMember("Katarina", "Maholoc", true);
//		} catch (SQLException e) {
//			
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	@Test
//	void testServerModel() {
//		
//			serverModelManager.addMember("Blazeus", "Drawner", false);
//		
//		
//	}
	
	@Test
	void testClientModel() {
		ClientModelManager client = new ClientModelManager();
		try {
			client.addMember("Boris", "Sidllo", false);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
