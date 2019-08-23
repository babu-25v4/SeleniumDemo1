package mail.gmail;

public class TestConfig{

	public static String server="smtp.gmail.com";
	public static String from = "ri.testacc01@gmail.com";
	public static String password = "Welcome1234!";
	public static String[] to ={"babu25v4@gmail.com","trainer@way2automation.com"};
	public static String subject = "Babu Test Report";
	
	public static String messageBody ="Test Message for sending reports";
	public static String attachmentPath=System.getProperty("user.dir")+"//Reports.zip";
	public static String attachmentName="reports.zip";		 
}
