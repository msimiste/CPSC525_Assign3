import java.util.Scanner;

public class User_Interface {

	Templates t;
	Template[] temps;

	public User_Interface() {
		t = new Templates();
		temps = t.templates;
	}

	public void displayOptions() {

		System.out.println("Enter the Number to Choose an Option\n");

		for (int i = 1; i < temps.length; i++) {
			System.out.println("Option (" + i + "): " + temps[i].getDispName());
		}
	
		System.out.print("\nYour Choice: ");
	}

	public void initialMessage() {
		String greeting = "Deep C Phishing";

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < greeting.length(); j++) {
				if (i == 1 && j == 0) {
					System.out.println(greeting);
				} else if (i != 1) {
					System.out.print("*");
				}
			}
			if(i!=1){
				System.out.println();
			}
		}

	}

	public int getUserInputTemplate() {
		Scanner in = new Scanner(System.in);
		int temp = Integer.parseInt(in.nextLine());
		return temp;
	}

	public String getUserInputString() {
		Scanner in = new Scanner(System.in);
		String temp = "";
		if (in.hasNext()) {
			temp = in.nextLine();
		} else {
			temp = in.next();
		}

		return temp;
	}

	public void askSender() {

		System.out.print("Sender Name: ");
	}
	
	public void askSenderFemale() {

		System.out.print("Enter Female Sender Name: ");
	}
	
	public void askSenderMale() {

		System.out.print("Enter Male Sender Name: ");
	}

	public void askSendEmail() {
		System.out.print("Sender Email: ");
	}

	public void askReciever() {
		System.out.println();
		System.out.print("Receiver Name: ");
	}

	public void askRecEmail() {
		System.out.print("Reciever Email: ");
	}

	public void askGender() {
		System.out.print("Reciever's Gender? (F=female, M=male): ");
	}
	
	public void askPrice(){
		System.out.print("Please enter a price(format = xx.xx): ");
	}
	
	public void askMerchant(){
		System.out.print("Please enter a Merchant: ");
	}
	

	public void openBrowser(String url) {

		
		String os = System.getProperty("os.name").toLowerCase();
		Runtime rt = Runtime.getRuntime();

		try {
			if (os.indexOf("win") >= 0) {

				// this doesn't support showing urls in the form of
				// "page.html#nameLink"
				rt.exec("rundll32 url.dll,FileProtocolHandler " + url);

			} else if (os.indexOf("mac") >= 0) {

				rt.exec("open " + url);

			} else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {

				// Do a best guess on unix until we get a platform independent
				// way
				// Build a list of browsers to try, in this order.
				String[] browsers = { "firefox", "chrome", "konqueror",
						"netscape", "opera", "links", "lynx" };

				// Build a command string which looks like
				// "browser1 "url" || browser2 "url" ||..."
				StringBuffer cmd = new StringBuffer();
				for (int i = 0; i < browsers.length; i++)
					cmd.append((i == 0 ? "" : " || ") + browsers[i] + " \""
							+ url + "\" ");

				rt.exec(new String[] { "sh", "-c", cmd.toString() });

			} else {
				return;
			}
		} catch (Exception e) {
			return;
		}
	}
}
