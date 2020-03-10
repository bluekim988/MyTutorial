/**
 * @author	������
 * @since	2020.03.10
 * @version ver.0.4
 */

import java.util.Scanner;

class PhoneInfo {
	String name;
	String num;

	public PhoneInfo(String name, String num) {
		this.name = name;
		this.num = num;		
	}
	public void showPhoneInfo() {
		System.out.println("���� ����� �����մϴ�.");
		System.out.println("*************************");
		System.out.println("name : " + name);
		System.out.println("phone : " + num);
	}
}
class PhoneUnivInfo extends PhoneInfo	{
	String major;
	int year;
	
	public PhoneUnivInfo(String name, String num, String major, int year) {
		super(name, num);
		this.major = major;
		this.year = year;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("major : " + major);
		System.out.println("year : " + year);
	}
}
class PhoneCompanyInfo extends PhoneInfo {
	
	String company;
	
	public PhoneCompanyInfo(String name, String num, String comp) {
		super(name, num);
		company = comp;
	}
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("company : " + company);
	}
}
class PhoneBookManager {
	final int MAX_CNT = 100;
	PhoneInfo[] phInfo = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	Scanner sc = new Scanner(System.in);
	
	private PhoneInfo readFriendInfo() {
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String num = sc.nextLine();
		
		return new PhoneInfo(name, num);
	}
	private PhoneInfo readUnivFriendInfo() {
		System.out.println("�̸� : ");
		String name = sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String num = sc.nextLine();
		System.out.println("���� : " );
		String major = sc.nextLine();
		System.out.println("�г� : ");
		int year = sc.nextInt();
		sc.nextLine();
		
		return new PhoneUnivInfo(name, num, major, year);
	}
	private PhoneInfo readCompFriendInfo() {
		System.out.println("�̸� : ");
		String name = sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String num = sc.nextLine();
		System.out.println("ȸ�� : ");
		String comp = sc.nextLine();
		
		return new PhoneCompanyInfo(name, num, comp);
	}
	
	public void inputData() {
		System.out.println("���� �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ� ,  2. ���� , 3. ȸ��");
		System.out.print("���� ==> ");
		int ci = sc.nextInt();
		sc.nextLine();
		PhoneInfo info = null;
		
		switch(ci) {
		case 1 :
			info = readFriendInfo();
			break;
		case 2 :
			info = readUnivFriendInfo();
			break;
		case 3 :
			info = readCompFriendInfo();
			break;
		}
		phInfo[curCnt] = info; 
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