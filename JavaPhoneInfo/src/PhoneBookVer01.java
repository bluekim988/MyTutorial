/**
 * @author	김종형
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
		System.out.println("*** \t 데이터 출력을 시작합니다.");
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
		System.out.println("정보 입력을 시작합니다.");
		System.out.print("이름 : ");
		String na = sc.nextLine();
		System.out.print("전화번호 : ");
		String nu = sc.nextLine();
		System.out.print("생년월일 : ");
		String br = sc.nextLine();
		
		phInfo[curCnt] = new PhoneInfo(na, nu, br);
		curCnt++;
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}
	public void searchData() {
		System.out.println("정보 검색을 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		int no = search(name);
		if(no < 0) {
			System.out.println("입력한 정보가 없습니다.");
		}	else {
			phInfo[no].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다. \n");
		}
	}
	public void deleteData() {
		System.out.println("정보 삭제를 시작합니다.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		int ru = search(name);
		if(ru < 0) {
			System.out.println("입력한 정보가 없습니다.");
		}	else {
			for(int j=ru; j < curCnt; j++) {
				phInfo[ru] = phInfo[ru + 1];				
			}
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다. \n");
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
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("선택: ");
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
					System.out.println("프로그램을 종료합니다.");
					return;
				
			}
		}
	}
}