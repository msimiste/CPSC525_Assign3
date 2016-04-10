import java.util.Scanner;

public class User_Interface {

	Templates t;

	public User_Interface() {
		t = new Templates();
	}

	public void displayOptions() {

		System.out.println("Enter the Number to Choose an Option\n");
		System.out.println("Option (1): " + t.getName(1));
		System.out.println("Option (2): " + t.getName(2));
		System.out.println("Option (3): " + t.getName(3));
		System.out.println("Option (4): " + t.getName(4));
		System.out.println("Option (5): " + t.getName(5));
		System.out.println("Option (6): " + t.getName(6));
		System.out.println("Option (7): " + t.getName(7));
		System.out.println("Option (8): " + t.getName(8));
		System.out.println("Option (9): " + t.getName(9));
		System.out.println("Option (10): " + t.getName(10));
		System.out.print("\nYour Choice: ");
	}

	public int getUserInput() {
		Scanner in = new Scanner(System.in);
		int temp = in.nextInt();
		in.close();
		return temp;
	}

	public void openBrowser(String url) {
		
		
		//String os = System.getProperty("os.name");
		//Document d = Jsoup.parse(infile,"ISO-8859-1");	
		
	/*	if(Desktop.isDesktopSupported())
		{
		  Desktop.getDesktop().browse(new URI(temp));
		}*/
		
		
		// String url = "http://www.google.com";
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
				String[] browsers = { "firefox", "chrome",
						"konqueror", "netscape", "opera", "links", "lynx" };

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
