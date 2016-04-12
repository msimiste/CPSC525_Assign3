import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Attack {

	private Template tPlate;
	private String gender;
	private User_Interface ui = new User_Interface();

	public Attack(Template t, String g) {
		tPlate = t;
		gender = g;
	}

	public void launchAttack() throws MalformedURLException, IOException {

		Util util = new Util();
		getMoreInfo(tPlate.getNumber());
		String attackFile = util.createEmail(tPlate, gender);
		ui.openBrowser(attackFile);

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
			break;
		}

		case 3: {
			break;
		}

		case 4: {
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
			System.out.println("Enter Price: ");
			String price = in.nextLine();
			System.out.println("Enter Currency(ie USD or CAD etc): ");
			String currency = in.nextLine();
			//SimpleDateFormat fmt = new SimpleDateFormat();
			tPlate.setRecEmail(recEmail);
			tPlate.addReplaceValue("@MERCHANT@", merchant);
			tPlate.addReplaceValue("@PRICE@",price);
			tPlate.addReplaceValue("@CURRENCY@",currency);
			
			break;
		}

		case 8: {
			break;
		}

		case 9: {
			break;
		}

		case 10: {
			break;
		}
		}

	}
}