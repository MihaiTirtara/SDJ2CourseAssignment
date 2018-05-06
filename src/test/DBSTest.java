package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.sql.SQLException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import vipassanaClient.domain.mediator.ClientModelManager;
import vipassanaServer.domain.mediator.DBS;
import vipassanaServer.domain.mediator.ServerModelManager;

class DBSTest {
	
	

	
//	@Test
//	void testClientModel() {
//		ClientModelManager client = new ClientModelManager();
//		try {
//			client.addMember("Boris", "Sidllo", false);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test
	void testSingleton() {
		ServerModelManager server = ServerModelManager.getInstance();
		System.out.println(server);
		ServerModelManager server1 = ServerModelManager.getInstance();
		assertEquals(server+"", server1+"");
		
	}

}
