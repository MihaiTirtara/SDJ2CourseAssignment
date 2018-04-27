package vipassanaClient.domain.mediator;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Observable;

import utility.observer.RemoteSubject;
import vipassanaServer.domain.mediator.ServerModel;
import vipassanaServer.domain.mediator.ServerModelManager;

public class ClientModelManager extends Observable implements ClientModel, Serializable {

	private ServerModel server;
	
	public ClientModelManager() {
			
		
		try {
			server = (ServerModel) Naming.lookup("rmi://localhost:1099/vipassanaServer");

			server.addObserver(this);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized String displayMembers() {
		String members = "";
		try {
			members = server.getMembers();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return members;
	}
	
	
	public synchronized void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println("Client model received the message "+updateMsg);
		notifyView(updateMsg);
		
		
	}
	
	public synchronized void notifyView(String updateMsg) {
		System.out.println("BLAH");
		System.out.println();
		
		super.setChanged();
		super.notifyObservers(updateMsg);
	}
	
	public synchronized void addMember(String name, String lastName, boolean payment) throws RemoteException{
		server.addMember(name, lastName, payment);
	}

	@Override
	public String displayNotPaidMembers() throws RemoteException {
		String returnMembers = "";
		returnMembers = server.getNotPaidMembers();
		return returnMembers;
	}

}
