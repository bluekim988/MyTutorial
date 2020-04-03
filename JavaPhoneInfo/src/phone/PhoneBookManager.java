package phone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {
	private final File dataFile = new File("JavaPhoneInfo/src/phone/PhoneBook2.dat");
	
	
	HashSet<PhoneInfo> user = new HashSet<PhoneInfo>();
	
	Scanner sc = new Scanner(System.in);
	
	public PhoneBookManager() {
		readFile();
	}
	
	private PhoneInfo readNecessary() {
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("전화번호: ");
		String num = sc.nextLine();

		return new PhoneInfo(name, num); 
	}
	
	private PhoneInfo readUniv() {
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("전화번호: ");
		String num = sc.nextLine();
		System.out.print("전공: ");
		String major = sc.nextLine();
		
		return new UnivPhoneInfo(name, num, major);
	}
	
	private PhoneInfo readComp() {
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("전화번호: ");
		String num = sc.nextLine();
		System.out.print("회사: ");
		String comp = sc.nextLine();
		
		return new CompPhoneInfo(name, num, comp);
	}
	
	public void inputData() throws WrongChoice {
		System.out.println("\n정보 입력을 시작합니다");
		System.out.println("1.일반 \t2.대학\t3.회사");
		System.out.print("선택 : ");
		int no = sc.nextInt();
		sc.nextLine();
		
		if(no<1 || no>3) {
			throw new WrongChoice(no);
		}
		
		PhoneInfo inst = null;
		switch(no) {
		case 1:
			inst = readNecessary();
			break;
		case 2:
			inst = readUniv();
			break;
		case 3:
			inst = readComp();
			break;
		}
		boolean isAdded = user.add(inst);
		if(isAdded == true) {
			System.out.println("입력이 완료되었습니다");	
		} else {
			System.out.println("이미 사용된 이름입니다.");
		}
	}
	
	public void searchData() {
		System.out.println("정보 검색을 시작합니다");
		System.out.print("이름: ");
		String name = sc.nextLine();
		
		Iterator<PhoneInfo> itr = user.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo pare = itr.next();
			if(pare.name.equals(name)) {
				pare.showInfo();
				return;
			}
		}
		System.out.println("입력하신 정보가 없습니다");
	}
	
	public void deleteData() {
		System.out.println("정보 삭제를 시작합니다");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		Iterator<PhoneInfo> itr = user.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo pare = itr.next();
			if(pare.name.equals(name)) {
				itr.remove();
				System.out.println("정보 삭제가 완료되었습니다");
				return;
			}
		}
		System.out.println("입력하신 정보가 없습니다.");
	}
	
	public void readFile() {
		if(dataFile.exists() == false) {
			return;
		}
		FileInputStream fin = null;
		ObjectInputStream in = null;
		try {
			fin = new FileInputStream(dataFile);
			in = new ObjectInputStream(fin);
			while(true) {
				Object buff = in.readObject();
				if(buff == null) {
					break;
				}
				PhoneInfo info = (PhoneInfo)buff;
				user.add(info);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void saveFile() {
		FileOutputStream fout = null;
		ObjectOutputStream out = null;
		Iterator<PhoneInfo> itr = user.iterator();
		try {
			fout = new FileOutputStream(dataFile);
			out = new ObjectOutputStream(fout);
			while(itr.hasNext()) {
				out.writeObject(itr.next());
			}
			out.writeObject(null);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
