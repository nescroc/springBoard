package sen.spring.polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV ��ü ����");
	}
	
	public SamsungTV(Speaker speaker,int price) {
		System.out.println("SamsungTV ��ü ���� : ������ ������ - ���߸���");
		this.speaker = speaker;
		this.price = price;
	}
	
	public Speaker getSpeaker() {
		System.out.println("getSpeaker() �޼��� ȣ��");
		return speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() �޼��� ȣ��");
		this.speaker = speaker;
	}
	
	public void setPrice(int price) {
		System.out.println("setPrice() �޼��� ȣ��");
		this.price = price;
	}
	
	public int getPrice() {
		System.out.println("getPrice() �޼��� ȣ��");
		return price;
	}
	
	public void powerOn() {
		System.out.println("SamsungTV ������ �Ҵ�. ���� : "+price+"��");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV ������ ����.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}