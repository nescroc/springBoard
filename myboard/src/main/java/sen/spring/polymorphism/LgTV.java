package sen.spring.polymorphism;

public class LgTV implements TV {
	
	public LgTV() {
		System.out.println("LgTV ��ü ����");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV ������ �Ҵ�.");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV ������ ����.");

	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV ������ �ø���.");

	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV ������ ������.");

	}
	
	public void start() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
	}
	public void stop() {
		System.out.println("��ü ���� ���� ó���� ���� ó��");
	}
}
