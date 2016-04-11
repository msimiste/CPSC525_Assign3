/*import java.awt.Desktop;
import java.io.File;*/
import java.io.IOException;
//import java.net.URI;
import java.net.URISyntaxException;
/*import java.nio.charset.Charset;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;*/

public class Controller {

	public static void main(String[] args) throws IOException, URISyntaxException {
	
		User_Interface ui = new User_Interface();
		ui.initialMessage();
		ui.askReciever();
		String recChoice = ui.getUserInputString();
		ui.askGender();
		String gender = ui.getUserInputString();
		
		ui.displayOptions();
		int choice = ui.getUserInputTemplate();
		
		Template t = ui.t.getTemplate(choice);
		t.setRec(recChoice);
		
		Attack attack = new Attack(t,gender);
		attack.launchAttack();
			
		
	}

}
