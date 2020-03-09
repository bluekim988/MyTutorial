import java.lang.reflect.Array;
import java.util.Scanner;

/*
 * ��ȭ��ȣ ���� ���α׷� ���� ������Ʈ
 * version 0.2
 */


class PhoneInfo {
	String name;
	String phoneNumber;
	String birthday;

	public PhoneInfo(String na, String pn, String br) {
		name = na;
		phoneNumber = pn;
		birthday = br;
	}

	public PhoneInfo(String na, String pn) {
		name = na;
		phoneNumber = pn;
	}

	public void showInfo() {
		if(birthday != null)
			System.out.println
			("�̸� : " + name + "\t" + "��ȭ��ȣ : " + phoneNumber + "\t" + "������� : " + birthday);
		else 
			System.out.println("�̸� : " + name + "\t" + "��ȭ��ȣ : " + phoneNumber);
		System.out.println();
	}
}

class PhoneBookManager {
	final int MAX_CNT=100;
	PhoneInfo[] phInfo = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	public void inputData() {
		System.out.println("������ �Է��� �����մϴ�.");
		System.out.print("�̸� : ");
		String na = MenuViewer.sc.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String pn = MenuViewer.sc.nextLine();
		System.out.print("������� : ");
		String br = MenuViewer.sc.nextLine();
		
		phInfo[curCnt++] = new PhoneInfo(na,pn,br);
		
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
	}
	
	public void infoSerch() {
		System.out.println("������ �˻��� �����մϴ�. \n");
		System.out.print("�̸� : ");
		String name1 = MenuViewer.sc.nextLine();	
		
		int no = search(name1);
			if(no < 0) {
				System.out.println("==> �ش� ������ �����ϴ�. \n");
			}	else	{				
			System.out.println();
			phInfo[no].showInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�. \n");
		}
}		
	
	
	public void deleteInfo() {
		System.out.println("������ ������ �����մϴ�.");
		
		System.out.print("�̸� : ");
		String name2 = MenuViewer.sc.nextLine();
		

			int no = search(name2);
			if(no < 0) {
				System.out.println("==> �ش� ������ �����ϴ�. \n");
			}	else	{
				for(int i=no; i < (curCnt-1); i++) {
					phInfo[i] = phInfo[i+1];
					
					curCnt--;
					System.out.println("������ ������ �Ϸ�Ǿ����ϴ�. \n");
				}
			}
	
	}
	
	int search(String na) {
		for(int i=0; i < curCnt; i++) {
			PhoneInfo curInfo = phInfo[i];
			if(na.compareTo(curInfo.name) == 0)
				return i;
		}
		return -1;
	}
}


class MenuViewer {
	public static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����");
		System.out.print("���� : ");
	}
}
public class PhoneBookVer01 {
	
	public static void main(String[] args) {
		PhoneBookManager pbk = new PhoneBookManager();
		int no;
		
		ot:
		while(true) {
			MenuViewer.showMenu();
			no = MenuViewer.sc.nextInt();
			MenuViewer.sc.nextLine();
			
			switch(no) {
			case 1:
					pbk.inputData();
					break;
			case 2: 
					
					
					pbk.infoSerch();
					break;
			case 3:
					pbk.deleteInfo();
					break;		
			case 4:
					System.out.println("���α׷��� �����մϴ�.");
					break ot;
					
			}
		}
	}	
}
