package phone;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager();

		while (true) {
			try {
				System.out.println("\n프로그램을 시작합니다");
				System.out.println("1. 정보 입력");
				System.out.println("2. 정보 검색");
				System.out.println("3. 정보 삭제");
				System.out.println("4. 프로그램 종료");
				System.out.print("선택 : ");
				int no = sc.nextInt();
				sc.nextLine();

				if (no < 1 || no > 4) {
					throw new WrongChoice(no);
				}

				switch (no) {
				case 1:
					manager.inputData();
					break;
				case 2:
					manager.searchData();
					break;
				case 3:
					manager.deleteData();
					break;
				case 4:
					manager.saveFile();
					System.out.println("프로그램을 종료합니다");
					return;
				}

			} 
			catch (WrongChoice e) {
				e.showWrong();
			}
		}

	}

}
