package phone;

public class CompPhoneInfo extends PhoneInfo {
	String company;
	
	public CompPhoneInfo(String name, String num, String comp) {
		super(name, num);
		company = comp;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("company: " + company);
	}
}
