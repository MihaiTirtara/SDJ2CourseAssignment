package vipassanaServer.domain.mediator;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import utility.observer.AbstractRemoteSubject;
import vipassanaServer.domain.model.Member;
import vipassanaServer.domain.model.MemberList;

public class ServerModelManager extends AbstractRemoteSubject<String> implements ServerModel 
{

	private static ServerModelManager instance;
	private  DbsPersistance dbsPersistance;

	private MemberList members;
	
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
			
			System.out.println(e.getMessage());
			return;
		}
		super.notifyObservers("Info from SERVER: Added member successfuly");
		
	}
	
	public synchronized String getMembers() {
		ArrayList<Object[]> array = dbsPersistance.getMembers();
		members = new MemberList();
		
		for(int i=0;i<array.size();i++) {
			Object[] row = array.get(i);
			String name = row[0].toString();
			String lastName = row[1].toString();
			boolean payment = Boolean.parseBoolean(row[2].toString());
			int memberNo = Integer.parseInt(row[3].toString());

			members.addMember(new Member(name,lastName,payment,memberNo));
		}
		
		
		
		return members.toString();
	}

	@Override
	public String getNotPaidMembers() throws RemoteException {
		ArrayList<Object[]> array = dbsPersistance.getNotPaidMembers();
		members = new MemberList();
		
		for(int i=0;i<array.size();i++) {
			Object[] row = array.get(i);
			String name = row[0].toString();
			String lastName = row[1].toString();
			boolean payment = Boolean.parseBoolean(row[2].toString());
			int memberNo = Integer.parseInt(row[3].toString());

			members.addMember(new Member(name,lastName,payment,memberNo));
		}
		return members.toString();
	}

}
