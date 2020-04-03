package phone;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhoneBookManager manager = new PhoneBookManager();

		while (true) {
			try {
				System.out.println("\n���α׷��� �����մϴ�");
				System.out.println("1. ���� �Է�");
				System.out.println("2. ���� �˻�");
				System.out.println("3. ���� ����");
				System.out.println("4. ���α׷� ����");
				System.out.print("���� : ");
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
					System.out.println("���α׷��� �����մϴ�");
					return;
				}

			} 
			catch (WrongChoice e) {
				e.showWrong();
			}
		}

	}

}
