package vipassanaServer.domain.mediator;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import utility.observer.AbstractRemoteSubject;
import vipassanaServer.domain.model.MemberList;

public class ServerModelManager extends AbstractRemoteSubject<String> implements ServerModel 
{

	private static ServerModelManager instance;
	private  DbsPersistance dbsPersistance;

	private MemberList memberList;
	
	private ServerModelManager()
	{
		try {
			dbsPersistance = new DBS();
			Registry reg = LocateRegistry.createRegistry(1099);
			UnicastRemoteObject.exportObject(this, 0);
			Naming.rebind("vipassanaServer", this);
			System.out.println("Server is running");
			
		} catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public static ServerModelManager getInstance()
	{
		if(instance == null)
		{
			instance = new ServerModelManager();
		}
		return instance;
	}
	public synchronized void addMember(String name, String lastName, boolean payment) 
	{
		try {
			dbsPersistance.addMember(name, lastName, payment);
		} catch (SQLException e) {
			super.notifyObservers("Info from SERVER: Something went wrong while adding member");
			
			e.getMessage();
			return;
		}
		super.notifyObservers("Info from SERVER: Added member successfuly");
		
	}

}
