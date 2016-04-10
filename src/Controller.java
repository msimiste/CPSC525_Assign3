import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Controller {

	public static void main(String[] args) throws IOException, URISyntaxException {
		Scanner in = new Scanner(System.in);
		Util util = new Util();
		String infilePath = "Template1_Levelup.html";
		File infile = new File(infilePath);
		User_Interface ui = new User_Interface();
		ui.displayOptions();
		int choice = ui.getUserInput();
		util.createEmail(choice);
		//String temp = infile.getAbsolutePath().replace("\\", "/");
		//ui.openBrowser(temp);
	
		System.out.println("You chose the template: "+ui.t.getName(choice));

	}

}
