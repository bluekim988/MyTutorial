package phone;

import java.io.Serializable;

/**
 * @author	������
 * 
 * 
 * 			�� Ŭ������ ��ȭ��ȣ������ ���� �⺻ ������ ����ִ�.
 *				
 */
public class PhoneInfo implements Serializable {
	String name;
	String number;
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		number = num;
	}
	
	public void showInfo() {
		System.out.println("\nname: " + name);
		System.out.println("number: " + number);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		PhoneInfo pare = (PhoneInfo) obj;
		if(name.compareTo(pare.name) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
