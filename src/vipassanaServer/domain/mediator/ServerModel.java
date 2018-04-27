package vipassanaServer.domain.mediator;

import java.rmi.Remote;
import java.rmi.RemoteException;

import utility.observer.RemoteSubject;

public interface ServerModel extends Remote, RemoteSubject<String> {
	
	public void addMember(String name, String lastName, boolean payment) throws RemoteException;
	public String getMembers() throws RemoteException;
	public String getNotPaidMembers() throws RemoteException;

}
