package vipassanaClient.controller;

import vipassanaClient.view.ClientView;

import java.rmi.RemoteException;

import vipassanaClient.domain.mediator.ClientModel;

public class ClientController {

	private ClientView clientView;

	private ClientModel clientModel;
	
	public ClientController(ClientView clientView, ClientModel clientModel) {
		
			this.clientView=clientView;
			this.clientModel=clientModel;
	}
	
	public void execute(int choice){
	
		switch(choice) {
			case 1:
				String name;
				String lastName,paymentStr;
				boolean payment;
				
				name = clientView.get("name");
				lastName = clientView.get("lastname");
				paymentStr = clientView.get("payment(true or false)");
				if (paymentStr.equals("true"))
				{
					payment = true;
				} else
				{
					payment = false;
				}
			try {
				clientModel.addMember(name, lastName, payment);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} break;
			
			case 2:
				
			try {
				clientView.show(clientModel.displayMembers());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				break;
				
			case 3 :
			try {
				clientView.show(clientModel.displayNotPaidMembers());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
				
				
	
			
				
				
		}
	}
}
