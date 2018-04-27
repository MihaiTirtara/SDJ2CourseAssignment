package vipassanaClient.domain.mediator;

import vipassanaClient.controller.ClientController;
import vipassanaClient.view.ClientView;

public class Client {

	
	public static void main(String [ ] args) {
		
		ClientModelManager clientModel = new ClientModelManager();
		ClientView clientView = new ClientView();
		clientModel.addObserver(clientView);
		System.out.println(clientModel.countObservers());
		
		ClientController clientController = new ClientController(clientView,clientModel);
		clientView.startView(clientController);
		
	}

}
