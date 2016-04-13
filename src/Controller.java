import java.io.IOException;
import java.net.URISyntaxException;



public class Controller {

	public static void main(String[] args) throws IOException, URISyntaxException {
	
		User_Interface ui = new User_Interface();
		ui.initialMessage();

		ui.displayOptions();
		int choice = ui.getUserInputTemplate();
		
		Template t = ui.t.getTemplate(choice);
		
		
		Attack attack = new Attack(t);
		attack.launchAttack();
			
		
	}

}
