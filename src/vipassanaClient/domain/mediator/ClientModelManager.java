package vipassanaClient.domain.mediator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Observable;

import utility.observer.RemoteSubject;
import vipassanaServer.domain.mediator.ServerModel;
import vipassanaServer.domain.mediator.ServerModelManager;

public class ClientModelManager extends Observable implements ClientModel {

	private ServerModel server;
	
	public ClientModelManager() {
			
		
		try {
			server = (ServerModel) Naming.lookup("rmi://130.226.139.247:1099/vipassanaServer");

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

	@Override
	public synchronized void update(RemoteSubject<String> subject, String updateMsg) throws RemoteException {
		System.out.println("Client model received the message "+updateMsg);
		super.notifyObservers(updateMsg);
		
	}
	
	public synchronized void addMember(String name, String lastName, boolean payment) throws RemoteException{
		server.addMember(name, lastName, payment);
	}

}
