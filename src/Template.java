public class Template {
	private String sender;
	private String reciever;
	private String senderEmail;
	private String recieverEmail;
	private String name;
	private int number;
	private String dispName;

	public Template(String s, String r, String sE, String rE, String n,
			int num, String dsp) {
		sender = s;
		reciever = r;
		senderEmail = sE;
		recieverEmail = rE;
		name = n;
		number = num;
		dispName = dsp;
	}

	public void setSender(String s) {
		sender = s;
	}

	public void setRec(String r) {
		reciever = r;
	}

	public void setRecEmail(String e) {
		recieverEmail = e;
	}

	public void setSendEmail(String e) {
		senderEmail = e;
	}

	public void setName(String n) {
		name = n;
	}

	public void setNumber(int n) {
		number = n;
	}

	public void setDipsName(String s) {
		dispName = s;
	}

	// access to the templates attributes
	public String getSender() {
		return sender;
	}

	public String getRec() {
		return reciever;
	}

	public String getRecEmail() {
		return recieverEmail;
	}

	public String getSendEmail() {
		return senderEmail;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getDispName() {
		return dispName;
	}

}
