package vipassanaClient.domain.mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utility.observer.RemoteObserver;

public interface ClientModel extends Remote, RemoteObserver<String> {
	
	public void addMember(String name, String lastName, boolean payment) throws RemoteException;

}
