/**
 * @author	������
 * @since	2020.03.10
 * @version ver.0.4
 */
/*
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
interface INIT_MENU {
	int INPUT = 1, SEARCH = 2, DELETE = 3, EXIT = 4;
}
interface INPU_SELECT {
	int NORMAL = 1, UNIV = 2, COMPANY = 3;
}
class MenuChoiceException extends Exception {
	int WrongNumber = 0;
	public MenuChoiceException(int choice) {
		super("�߸��� ������ �ԷµǾ����ϴ�");
		WrongNumber = choice;
	}
	public void WrongChoice() {
		System.out.println(WrongNumber + " �� �߸��� ��ȣ �Է��Դϴ�!!!");
	}
}
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
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public boolean equals(Object obj) {
		PhoneInfo info = (PhoneInfo) obj;
		if(name.compareTo(info.name) == 0) {
			return true;
		} else {
			return false;
		}
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
	Scanner sc = new Scanner(System.in);
	HashSet<PhoneInfo> my = new HashSet<PhoneInfo>();
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst == null) {
			inst = new PhoneBookManager();
		} return inst;
	}
	private PhoneBookManager(){}
	
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
	
	public void inputData() throws MenuChoiceException {
		System.out.println("���� �Է��� �����մϴ�");
		System.out.println("1. �Ϲ� ,  2. ���� , 3. ȸ��");
		System.out.print("���� ==> ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		if(choice < 1 || choice > 3) {
			throw new MenuChoiceException(choice);
		}
		
		PhoneInfo inst = null ;
		switch(choice) {
		case 1 :
			inst = readFriendInfo();
			break;
		case 2 :
			inst = readUnivFriendInfo();	
			break;
		case 3 :
			inst = readCompFriendInfo();
			break;
		}
		boolean canAdd = my.add(inst);
		if(canAdd == true) {
			System.out.println("���� �Է��� �Ϸ�Ǿ����ϴ�.\n");		
		} else {
			System.out.println("�ش� ������ �̹� �ԷµǾ����ϴ�.\n");
		}
		
	}
	
	public void searchData() {
		System.out.println("���� �˻��� �����մϴ�.");
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		
		Iterator<PhoneInfo> itr = my.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			if(info.name.equals(name)) {
				info.showPhoneInfo();
				return;
			}
		}
		System.out.println("�Է��Ͻ� ������ �����ϴ�.\n");
	}
	
	public void deleteData() {
		System.out.println("���� ������ �����մϴ�");
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		
		Iterator<PhoneInfo> itr = my.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo info = itr.next();
			if(info.name.equals(name)) {
				itr.remove();
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.\n");
				return;
			}
		}
		System.out.println("�Է��Ͻ� ������ �����ϴ�.\n");
	}
	
}
*/

//----------------------------------------------------------
/*
class PhoneBookManager {
	final int MAX_CNT = 100;
	PhoneInfo[] phInfo = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	Scanner sc = new Scanner(System.in);
	
	static PhoneBookManager inst = null;
	public static PhoneBookManager createManagerInst() {
		if(inst == null) {
			inst = new PhoneBookManager();
		} return inst;
	}
	private PhoneBookManager(){}
	
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
	
	public void inputData() throws MenuChoiceException {
		System.out.println("���� �Է��� �����մϴ�.");
		System.out.println("1. �Ϲ� ,  2. ���� , 3. ȸ��");
		System.out.print("���� ==> ");
		int ci = sc.nextInt();
		sc.nextLine();
		PhoneInfo info = null;
		
		if(ci < INPU_SELECT.NORMAL || ci > INPU_SELECT.COMPANY)
			throw new MenuChoiceException(ci);
		
		switch(ci) {
		case INPU_SELECT.NORMAL :
			info = readFriendInfo();
			break;
		case INPU_SELECT.UNIV :
			info = readUnivFriendInfo();
			break;
		case INPU_SELECT.COMPANY :
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
*/
//------------------------------------------------------------
/*
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
		PhoneBookManager manager = PhoneBookManager.createManagerInst();
		
		int cho;
		
		while(true) {
			try {
			MenuViewer.showMenu();
			cho = manager.sc.nextInt();
			manager.sc.nextLine();
			if(cho < INIT_MENU.INPUT || cho > INIT_MENU.EXIT)
				throw new MenuChoiceException(cho);
			
				switch(cho) {
				case INIT_MENU.INPUT :
						manager.inputData();
						break;
				case INIT_MENU.SEARCH :
						manager.searchData();
						break;
				case INIT_MENU.DELETE :
						manager.deleteData();
						break;
				case INIT_MENU.EXIT :
						System.out.println("���α׷��� �����մϴ�.");
						return;
				}
			}
			catch(MenuChoiceException e) {
				e.WrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�. \n");
			
			}
		
			
		}
	}
}
*/