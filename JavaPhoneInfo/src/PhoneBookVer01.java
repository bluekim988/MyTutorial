/**
 * @author	������
 * @since	2020.03.10
 * @version ver.0.3
 */

import java.util.Scanner;

class PhoneInfo {
	String name;
	String num;
	String birth;
	
	public PhoneInfo(String name, String num, String br) {
		this.name = name;
		this.num = num;
		birth = br;
	}
	public PhoneInfo(String name, String num) {
		this.name = name;
		this.num = num;
		this.birth = null;
	}
	public void showPhoneInfo() {
		System.out.println("*** \t ������ ����� �����մϴ�.");
		System.out.println("name : " + name);
		System.out.println("phone : " + num);
		if(birth != null) {
			System.out.println("birth : " + birth);
		}
	}
}
class PhoneBookManager {
	final int MAX_CNT = 100;
	PhoneInfo[] phInfo = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	Scanner sc = new Scanner(System.in);
	public void inputData() {
		System.out.println("���� �Է��� �����մϴ�.");
		System.out.print("�̸� : ");
		String na = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String nu = sc.nextLine();
		System.out.print("������� : ");
		String br = sc.nextLine();
		
		phInfo[curCnt] = new PhoneInfo(na, nu, br);
		curCnt++;
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
	}
	public void searchData() {
		System.out.println("���� �˻��� �����մϴ�.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		int no = search(name);
		if(no < 0) {
			System.out.println("�Է��� ������ �����ϴ�.");
		}	else {
			phInfo[no].showPhoneInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	public void deleteData() {
		System.out.println("���� ������ �����մϴ�.");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		int ru = search(name);
		if(ru < 0) {
			System.out.println("�Է��� ������ �����ϴ�.");
		}	else {
			for(int j=ru; j < curCnt; j++) {
				phInfo[ru] = phInfo[ru + 1];				
			}
			curCnt--;
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�. \n");
		}
	}
	int search(String name) {
		for(int cnt = 0; cnt < curCnt; cnt++) {
			PhoneInfo info = phInfo[cnt];
			if(name.compareTo(info.name) == 0)
				return cnt;
		}
		
		return -1;
	}	
}

class MenuViewer {
	public static void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.print("����: ");
	}
}

class PhoneBookVer01 {
	public static void main(String[] args) {
		PhoneBookManager manager = new PhoneBookManager();
		int cho;
		
		while(true) {
			MenuViewer.showMenu();
			cho = manager.sc.nextInt();
			manager.sc.nextLine();
			
			switch(cho) {
			case 1 :
					manager.inputData();
					break;
			case 2 :
					manager.searchData();
					break;
			case 3 :
					manager.deleteData();
					break;
			case 4 :
					System.out.println("���α׷��� �����մϴ�.");
					return;
				
			}
		}
	}
}