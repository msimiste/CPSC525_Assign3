import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Util {

	public Util() {

	}

	public String createEmail(int template, String senderName, String recName) throws MalformedURLException, IOException {

		Templates t = new Templates();
		String infile = t.getName(template);
		String outfile = "Output_"+infile;
		
	
		
		File fIn = new File(infile);
		File fOut = makeFileAndDir("",outfile);
		FileInputStream inStream = new FileInputStream(fIn);
		FileOutputStream outStream = new FileOutputStream(fOut);

		byte[] arr;
		
		//infile = fIn.getAbsolutePath().replace("\\", "/");

		User_Interface ui = new User_Interface();

		switch (template) {
		case 1:
		{
			String sender;
			String receiver;
			String Date;
			
			
		}
		case 2:
		{
			Document d = Jsoup.parse(inStream, "iso-8859-1", "null");
			//Elements e = d.body().getAllElements();
			
  			String oldStr = " @name@";
			Elements elinks = d.select("a[href]");
			for(Element link : elinks){
				link.attr("onClick", "window.location='https://gotcha';return false");
				//link.attr("href","http://gotcha");
				
			}
			String temp = d.toString();
			temp = temp.replace(oldStr, recName);
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}
		case 3:{
 			//
			Document d = Jsoup.parse(inStream, "UTF-8", "null");
			//Elements e = d.body().getAllElements();
			String oldStr = "@DATE@";
			SimpleDateFormat format = new SimpleDateFormat("MMMM YYYY");
			Date date = new Date();
			recName = format.format(date);
			Elements elinks = d.select("a[href]");
			for(Element link : elinks){
				link.attr("onClick", "window.location='https://gotcha';return false");
			}
			String temp = d.toString();
			temp = temp.replace(oldStr, recName);
			arr = temp.getBytes();
			outStream.write(arr);
			break;
			
		}
			/* {
			int count = 0;
			String temp = "";
			String oldStr = " @name@";
			while ((count = inStream.read(arr)) > 0) {
				temp += new String(arr);			

			}
			boolean tester = temp.contains("@name@");
			temp = temp.replace(oldStr, "Robin Gonzalez");
			byte[] arr2 = temp.getBytes();
			outStream.write(arr2);
			
			break;
		}*/
		}
		inStream.close();
		outStream.close();
		return outfile;

	}
	
	private File makeFileAndDir(String path, String fileName) {
		// concatenate the file path
		String dir = System.getProperty("user.dir");
		String separator = System.getProperty("file.separator");
		String absPath = dir + separator + path;

		File outFile = new File(absPath, fileName);

		outFile.getParentFile().mkdirs();
		try {
			outFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outFile;
	}

}
