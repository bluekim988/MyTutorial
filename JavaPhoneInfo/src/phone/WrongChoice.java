package phone;

public class WrongChoice extends Exception{
	int wrongNumber;
	
	public WrongChoice(int no) {
		super(no+"�߸��� �Է��Դϴ�");
		wrongNumber = no;
	}
	
	public void showWrong() {
		System.out.println("[ " + wrongNumber + " ] �߸��� �Է��Դϴ�");
		System.out.println("���α׷��� �ٽ� �����մϴ� \n");
	}
}
