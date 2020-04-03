package phone;

public class WrongChoice extends Exception{
	int wrongNumber;
	
	public WrongChoice(int no) {
		super(no+"잘못된 입력입니다");
		wrongNumber = no;
	}
	
	public void showWrong() {
		System.out.println("[ " + wrongNumber + " ] 잘못된 입력입니다");
		System.out.println("프로그램을 다시 시작합니다 \n");
	}
}
