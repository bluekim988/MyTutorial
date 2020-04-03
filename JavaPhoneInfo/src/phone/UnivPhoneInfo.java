package phone;

public class UnivPhoneInfo extends PhoneInfo{
	String major;
	
	public UnivPhoneInfo(String name, String num, String major) {
		super(name, num);
		this.major = major;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("major :" + major);
	}
	
}
