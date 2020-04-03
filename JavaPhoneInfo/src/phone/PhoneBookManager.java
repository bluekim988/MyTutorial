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
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String num = sc.nextLine();

		return new PhoneInfo(name, num); 
	}
	
	private PhoneInfo readUniv() {
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String num = sc.nextLine();
		System.out.print("����: ");
		String major = sc.nextLine();
		
		return new UnivPhoneInfo(name, num, major);
	}
	
	private PhoneInfo readComp() {
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String num = sc.nextLine();
		System.out.print("ȸ��: ");
		String comp = sc.nextLine();
		
		return new CompPhoneInfo(name, num, comp);
	}
	
	public void inputData() throws WrongChoice {
		System.out.println("\n���� �Է��� �����մϴ�");
		System.out.println("1.�Ϲ� \t2.����\t3.ȸ��");
		System.out.print("���� : ");
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
			System.out.println("�Է��� �Ϸ�Ǿ����ϴ�");	
		} else {
			System.out.println("�̹� ���� �̸��Դϴ�.");
		}
	}
	
	public void searchData() {
		System.out.println("���� �˻��� �����մϴ�");
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		
		Iterator<PhoneInfo> itr = user.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo pare = itr.next();
			if(pare.name.equals(name)) {
				pare.showInfo();
				return;
			}
		}
		System.out.println("�Է��Ͻ� ������ �����ϴ�");
	}
	
	public void deleteData() {
		System.out.println("���� ������ �����մϴ�");
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		Iterator<PhoneInfo> itr = user.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo pare = itr.next();
			if(pare.name.equals(name)) {
				itr.remove();
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�");
				return;
			}
		}
		System.out.println("�Է��Ͻ� ������ �����ϴ�.");
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
