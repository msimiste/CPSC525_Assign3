import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Attack {

	private Template tPlate;
	private String gender;
	private User_Interface ui = new User_Interface();
	private Util util = new Util();

	public Attack(Template t) {
		tPlate = t;
		//gender = g;
	}

	public void launchAttack() throws MalformedURLException, IOException {

		Util util = new Util();
		getMoreInfo(tPlate.getNumber());
		String attackFile = util.createEmail(tPlate, gender);
		ui.openBrowser(attackFile);

	}
	public String getGender(){
		return gender;
	}
	
	public void setGender(String g){
		gender = g;
		
	}

	private void getMoreInfo(int i) {

		switch (i) {
		case 1: {
			ui.askSender();
			String senderChoice = ui.getUserInputString();
			ui.askSendEmail();
			String sendEmail = ui.getUserInputString();
			this.tPlate.setSender(senderChoice);
			this.tPlate.setSendEmail(sendEmail);
			break;
		}
		case 2: {
			Scanner in = new Scanner(System.in);
			ui.askReciever();
			String receiver = in.nextLine();
			ui.askRecEmail();
			//System.out.print("Enter Receiver Email: ");
			String recEmail = in.nextLine();
			String curDate = util.getDate(1);
			tPlate.setRecEmail(recEmail);
			tPlate.setRec(receiver);
			this.tPlate.addReplaceValue("@RECEIVER@", this.tPlate.getRec());
			this.tPlate.addReplaceValue("@RECEIVEREMAIL@",this.tPlate.getRecEmail());
			this.tPlate.addReplaceValue("@CURRENTDATE@",curDate);
			break;
		}

		case 3: {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Receiver Email: ");
			String recEmail = in.nextLine();
			tPlate.setRecEmail(recEmail);
			this.tPlate.addReplaceValue("@RECEIVER@", this.tPlate.getRec());
			this.tPlate.addReplaceValue("@RECEIVEREMAIL@",this.tPlate.getRecEmail());
		}

		case 4: {
			Scanner in = new Scanner(System.in);
			ui.askGender();
			String gender = in.nextLine();
			this.setGender(gender);
			ui.askReciever();
			String receiver = in.nextLine();
			tPlate.setRec(receiver);
			
			if (gender.equalsIgnoreCase("M")) {
				ui.askSenderFemale();
			} else {
				ui.askSender();
			}
			String sendChoice = ui.getUserInputString();
			this.tPlate.setSender(sendChoice);
			break;
		}

		case 5: {
			Scanner in = new Scanner(System.in);
		
			ui.askReciever();
			String receiver = in.nextLine();
			ui.askGender();
			String g = in.nextLine();
			this.setGender(g);
			System.out.print("Enter Receiver's Email: ");
			String recEmail = in.nextLine();
			String curDate = util.getDate(1);
			tPlate.setRec(receiver);
			tPlate.setRecEmail(recEmail);
			
			tPlate.addReplaceValue("@RECEIVER@", tPlate.getRec());
			tPlate.addReplaceValue("RECEIVEREMAIL@", tPlate.getRecEmail());
			tPlate.addReplaceValue("@CURRENTDATE@", curDate);
			break;
		}

		case 6: {
			break;
		}

		case 7: {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Receiver's Email: ");
			String recEmail = in.nextLine();
			System.out.print("Enter Merchant Name: ");
			String merchant = in.nextLine();
			String merchant2 = new String(merchant);
			System.out.print("Enter Price: ");
			String price = in.nextLine();
			System.out.print("Enter Currency(ie USD or CAD etc): ");
			String currency = in.nextLine().toUpperCase(); 
			System.out.print("Enter the Product: ");
			String product = in.nextLine();
			System.out.print("Enter areacode and phone# (format ###-###-####): ");
			String phoneNum = in.nextLine();			
			String curDate = util.getDate(1); 			
			String date = util.getDate(2);
			
			tPlate.setRecEmail(recEmail);
			tPlate.addReplaceValue("@MERCHANT@", merchant2.toUpperCase());
			tPlate.addReplaceValue("@MERCHANTWEBSITE@", merchant2.replace(" ","").toLowerCase());
			tPlate.addReplaceValue("@PRICE@",price);
			tPlate.addReplaceValue("@CURRENCY@",currency);
			tPlate.addReplaceValue("@CURRENTDATE@", curDate);
			tPlate.addReplaceValue("@DATE@", date);
			tPlate.addReplaceValue("@PHONENUM@", phoneNum);		
			tPlate.addReplaceValue("@RECEIVEREMAIL@",tPlate.getRecEmail());
			tPlate.addReplaceValue("@RECEIVER@", tPlate.getRec());
			tPlate.addReplaceValue("@PRODUCT@",product );	
			tPlate.addReplaceValue("Copyright ", "Copyright &copy ");
			tPlate.addReplaceValue("@MERCHANTCONTACT@", merchant);
			break;
		}

		case 8: {
			
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Receiver's Email: ");
			String recEmail = in.nextLine();
			System.out.print("Enter Sender's Email: ");
			String sendMail = in.nextLine();
			System.out.print("Enter a message from Sender: ");
			String senderMessage = in.nextLine();
			System.out.print("Enter Sender's Name: ");
			String senderName = in.nextLine(); 
			String curDate = util.getDate(1); 			
			String year = util.getDate(3);
			
			tPlate.setRecEmail(recEmail);
			tPlate.setSendEmail(sendMail);
			tPlate.setSender(senderName);
			tPlate.addReplaceValue("@DATE@", curDate);
			tPlate.addReplaceValue("@YEAR@", year);
			tPlate.addReplaceValue("@YR@", year.substring(2));
			tPlate.addReplaceValue("@SENDERMESSAGE@",senderMessage);
			tPlate.addReplaceValue("@SENDER@", tPlate.getSender());
			tPlate.addReplaceValue("@RECEIVEREMAIL@",tPlate.getRecEmail());
			break;
		}

		case 9: {
			
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Receiver's Email: ");
			String recEmail = in.nextLine();
			System.out.print("Enter an amount for the free gift:  ");
			String amount = in.nextLine();
			String curDate = util.getDate(1);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 7);
			String endDate = cal.getTime().toString(); 
			
			tPlate.setRecEmail(recEmail);
			tPlate.addReplaceValue("@CURRENTDATE@", curDate);
			tPlate.addReplaceValue("@AMOUNT@", amount);
			tPlate.addReplaceValue("@OFFERENDDATE@", endDate);
			tPlate.addReplaceValue("@RECEIVEREMAIL@",tPlate.getRecEmail());
			tPlate.addReplaceValue("@RECEIVER@", tPlate.getRec());
			break;
		}

		case 10: {
			
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Receiver's Email: ");
			String recEmail = in.nextLine();
			String curDate = util.getDate(1);
						
			 
			
			tPlate.setRecEmail(recEmail);
			tPlate.addReplaceValue("@DATE@", curDate);
			tPlate.addReplaceValue("@RECEIVEREMAIL@",tPlate.getRecEmail());
			tPlate.addReplaceValue("@RECEIVER@", tPlate.getRec());
			
			
			break;
		}
		}

	}
}
