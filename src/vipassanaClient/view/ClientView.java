package vipassanaClient.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import vipassanaClient.controller.ClientController;

public class ClientView implements IClientView, Runnable, Observer {

	private ClientController clientController;
	private Scanner input;

	public ClientView() {
		input = new Scanner(System.in);
		
	}

	
	public void startView(ClientController clientController) {
		this.clientController = clientController;
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		
	}

	@Override
	public void run() {
		boolean continueWorking = true;
		while (continueWorking) {
			// Read input from user input.
			System.out.print("1) Type 1 to add new member" +" Type 0 to \"EXIT\"\n Enter choice: ");
			int choice = input.nextInt();
			input.nextLine();

			// clientController.execute(choice);
			if (choice == 0) {
				continueWorking = false;
			} else {
				clientController.execute(choice);
			}
		}
	}

	
	public String get(String text) {
		System.out.print("Enter " + text + ": ");
		return input.nextLine();
	}

	
	public void show(String text) {
		System.out.println(text);
	}

	





}
