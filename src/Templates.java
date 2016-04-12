public class Templates {

	Template[] templates = new Template[11];

	public Templates() {
		createTemplates();
	}

	public Template getTemplate(int n) {
		return templates[n];

	}

	private void createTemplates() {
		templates[1] = new Template("", "Robin Gonzalez",
				"someone@ucalgary.ca", "gonzalre@ucalgary.ca",
				"Template1_Robin.html", 1, "Robin Gonzalez Attack");
		templates[2] = new Template("", "", "", "", "Template2_Levelup.html",
				2, "Level Up Attack");
		templates[3] = new Template("", "", "", "", "Template3_Shaw.html", 3,
				"Shaw Attack");
		templates[4] = new Template("", "", "", "", "Template4_Twitter.html",
				4, "Twitter Attack");
		templates[5] = new Template("", "", "", "",
				"Template5_TennisExpress.html", 5, "Tennis Express Attack");
		templates[6] = new Template("", "", "", "", "Template6_Coursera.html",
				6, "Coursera Attack");
		templates[7] = new Template("", "", "", "", "Template7_Paypal.html", 7,
				"Paypal Attack");
		templates[8] = new Template("", "", "", "", "Template8_MLB.html", 8,
				"MLB Attack");
		templates[9] = new Template("", "", "", "", "Template1_Robin.html", 9,
				"temp");
		templates[10] = new Template("", "", "", "", "Template1_Robin.html",
				10, "temp");
	}
}
