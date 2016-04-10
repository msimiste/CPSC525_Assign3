import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Util {

	public Util(){
		
	}
	
	public void createEmail(int template) throws MalformedURLException, IOException{
		
		Templates t = new Templates();
		String infile = t.getName(template);
		File f = new File(infile);
		//Elements el = f.
		Document d = Jsoup.parse(f.toURL(),1);//Jsoup.parse(infile,"ISO-8859-1");
		Elements e = d.body().getAllElements();
		infile = f.getAbsolutePath().replace("\\", "/");
		
		User_Interface ui = new User_Interface();
		
		switch (template)
		{
			case 1: for(Element elem :e){
				if (elem.text().equals("@name@")){
					elem.text("Robin Gonzalez");
					ui.openBrowser(infile);
				}
				
				break;
			}
			}
		
		}
		
		
	}

