import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Util {

	public Util() {

	}

	public String createEmail(Template t, String g, boolean output)
			throws MalformedURLException, IOException {

		int template = t.getNumber();
		String senderName = t.getSender();
		String recName = t.getRec();
		String Semail = t.getSendEmail();
		String Remail = t.getRecEmail();
		new Templates();
		String infile = t.getName();
		String outfile = "Output_" + infile;
		String gender = g;

		File fIn = new File(infile);
		File fOut = makeFileAndDir("", outfile);
		FileInputStream inStream = new FileInputStream(fIn);
		FileOutputStream outStream = new FileOutputStream(fOut);

		byte[] arr;
		
		if(!(output)){
			int c;
			byte arr1[] = new  byte [1024];
			
			while((c = inStream.read(arr1))>0){
				outStream.write(arr1);
				
			}
			inStream.close();
			outStream.close();
			return outfile;
			
		}

		new User_Interface();

		switch (template) {

		case 1: {
			String sendEmail = "@sender_email@";
			String recEmail = "@rec_email";
			String rec = "@RECIVER@";
			String snd = "@SENDER@";
			String date = "@CURRENTDATE@";
			//Date dt = new Date();
			//SimpleDateFormat fmt = new SimpleDateFormat("MMMM dd, YYYY hh:mm a");
			String replaceDate = getDate(1);//fmt.format(dt);


			Document d = Jsoup.parse(inStream, "iso-8859-1", "null");
			changeHrefs(d);
			String temp = d.toString();
			temp = temp.replace(snd, senderName).replace(rec, recName)
					.replace(date, replaceDate);
			temp = temp.replace(recEmail, Remail).replace(sendEmail, Semail);
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}
		case 2: {
			Document d = Jsoup.parse(inStream, "iso-8859-1", "null");
			String oldStr = " @name@";
			changeHrefs(d);
			String temp = d.toString();
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			
			temp = temp.replace(oldStr, recName);
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}
		case 3: {
			
			Document d = Jsoup.parse(inStream, "UTF-8", "null");
			String oldStr = "@DATE@";
			SimpleDateFormat format = new SimpleDateFormat("MMMM YYYY");
			Date date = new Date();
			recName = format.format(date);
			changeHrefs(d);
			String temp = d.toString();
			temp = replaceValues(temp,t);
			temp = temp.replace(oldStr, recName);
			arr = temp.getBytes();
			outStream.write(arr);
			break;

		}
		case 4: {
			Document d = Jsoup.parse(inStream, "UTF-8", "null");
			String repSender = senderName;
			String repMessage = "Hey, I lost my phone yesterday, so I don't have your number, can you give me a call or send it to me on here?";
			String repLink = "@" + senderName.split(" ")[0] + "_930611";
			String textToreplace1 = "@SENDER@";
			String textToreplace2 = "@Message@";
			String textToreplace3 = "@SENDERLINK@";

			changeHrefs(d);

			String temp = d.toString();
			if (gender.equalsIgnoreCase("F")) {
				repMessage = "omg you have got to see these puppies!!!!";
				temp = temp.replace(textToreplace1, repSender)
						.replace(textToreplace2, repMessage)
						.replace(textToreplace3, repLink);
				temp = temp.replace("twitter_img.jpg", "puppies.jpeg");				
			}
			temp = temp.replace(textToreplace1, repSender)
					.replace(textToreplace2, repMessage)
					.replace(textToreplace3, repLink);
			if(gender.equalsIgnoreCase("m")){
				temp = temp.replace("goo.gl/R15Ei5", "");
			}
			
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}

			arr = temp.getBytes();
			outStream.write(arr);
			break;

		}
		case 5: {
			
			
			Document d = Jsoup.parse(inStream, "iso-8859-1", "null");
			// Elements e = d.body().getAllElements();
			

			Elements elinks = d.select("a[href]");
			for (Element link : elinks) {
				link.attr("onClick",
						"window.location='GOTCHA.html';return false");
				link.attr("oncontextmenu",
						"window.location='GOTCHA.html';return false");
				String temp = link.toString();
				if (gender.equalsIgnoreCase("M")) {
					if (temp.contains("Tennis_womens_")) {
						link.remove();
					}
				} else {
					if (temp.contains("Tennis_mens_")) {
						link.remove();
					}
				}
			}
			String temp = d.toString();
			//temp = temp.replace(oldStr, recName);
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}

		case 6: {
			Document d = Jsoup.parse(inStream, "UTF-8", "null");
			
			changeHrefs(d);
			String temp = d.toString();
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}
		
		case 7:{

			Document d = Jsoup.parse(inStream, "iso-8859-1", "null");
			changeHrefs(d);
			String temp = d.toString();
			
			//replaceValues(temp,t);
		for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			
			
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}
		
		case 8: {
			
			Document d = Jsoup.parse(inStream, "iso-8859-1", "null");
			changeHrefs(d);
			String temp = d.toString();
			
			//replaceValues(temp,t);
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			
			
			arr = temp.getBytes();
			outStream.write(arr);
			break;
			
		}
		
		case 9: {
			Document d = Jsoup.parse(inStream, "UTF-8", "null");
			changeHrefs(d);
			String temp = d.toString();
			
			//replaceValues(temp,t);
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			
			
			arr = temp.getBytes();
			outStream.write(arr);
			break;
		}
		
		case 10: {
			Document d = Jsoup.parse(inStream, "UTF-8", "null");
			changeHrefs(d);
			String temp = d.toString();
			
			//replaceValues(temp,t);
			for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
				String toReplace = val.getKey();
				String replacement = val.getValue();
				
				temp = temp.replace(toReplace, replacement);
			}
			
			
			arr = temp.getBytes();
			outStream.write(arr);
			
			break;
		}
	

		}
		inStream.close();
		outStream.close();
		return outfile;
	}
	
	public String getDate(int n){
		String arr[] = new String [4];
		SimpleDateFormat fmt = new SimpleDateFormat("MMMM dd, yyyy hh:mm a");
		Date nowDate = new Date();
		arr[1] = fmt.format(nowDate);
		fmt = new SimpleDateFormat("MMMM YYYY");
		arr[0] = fmt.format(nowDate);
		fmt = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss 'GMT'Z ");
		arr[2] = fmt.format(nowDate);
		fmt = new SimpleDateFormat("YYYY");
		arr[3] = fmt.format(nowDate);		
		return arr[n];
		
	}

	private void changeHrefs(Document doc) {
		Elements elinks = doc.select("a[href]");
		for (Element link : elinks) {
			link.attr("onClick", "window.location='GOTCHA.html';return false");
			link.attr("oncontextmenu",
					"window.location='GOTCHA.html';return false");
		}
	}
	
	private String replaceValues(String temp, Template t){
		
		for(Map.Entry<String, String> val : t.getReplaceValues().entrySet()){
			String toReplace = val.getKey();
			String replacement = val.getValue();
			
			temp = temp.replace(toReplace, replacement);
		}
		return temp;
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
