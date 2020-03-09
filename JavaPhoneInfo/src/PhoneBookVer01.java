import java.lang.reflect.Array;
import java.util.Scanner;

/*
 * 전화번호 관리 프로그램 구현 프로잭트
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
			("이름 : " + name + "\t" + "전화번호 : " + phoneNumber + "\t" + "생년월일 : " + birthday);
		else 
			System.out.println("이름 : " + name + "\t" + "전화번호 : " + phoneNumber);
		System.out.println();
	}
}

class PhoneBookManager {
	final int MAX_CNT=100;
	PhoneInfo[] phInfo = new PhoneInfo[MAX_CNT];
	int curCnt = 0;
	
	public void inputData() {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 : ");
		String na = MenuViewer.sc.nextLine();
		System.out.print("전화번호 : ");
		String pn = MenuViewer.sc.nextLine();
		System.out.print("생년월일 : ");
		String br = MenuViewer.sc.nextLine();
		
		phInfo[curCnt++] = new PhoneInfo(na,pn,br);
		
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}
	
	public void infoSerch() {
		System.out.println("데이터 검색을 시작합니다. \n");
		System.out.print("이름 : ");
		String name1 = MenuViewer.sc.nextLine();	
		
		int no = search(name1);
			if(no < 0) {
				System.out.println("==> 해당 정보가 없습니다. \n");
			}	else	{				
			System.out.println();
			phInfo[no].showInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
}		
	
	
	public void deleteInfo() {
		System.out.println("데이터 삭제를 시작합니다.");
		
		System.out.print("이름 : ");
		String name2 = MenuViewer.sc.nextLine();
		

			int no = search(name2);
			if(no < 0) {
				System.out.println("==> 해당 정보가 없습니다. \n");
			}	else	{
				for(int i=no; i < (curCnt-1); i++) {
					phInfo[i] = phInfo[i+1];
					
					curCnt--;
					System.out.println("데이터 삭제가 완료되었습니다. \n");
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
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택 : ");
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
					System.out.println("프로그램을 종료합니다.");
					break ot;
					
			}
		}
	}	
}
