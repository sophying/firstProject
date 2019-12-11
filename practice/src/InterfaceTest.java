
interface Interface{
	
	int i = 0;
	public default void hello() {
		
		System.out.println("sfdsfds");
	}
	
	public String hi();
	
}

public class InterfaceTest implements Interface{
	public static void main(String[] args) {
		
		
	}

	@Override
	public String hi() {
		// TODO Auto-generated method stub
		return null;
	}
}

// 자바 8 부터 인터페이스 메소드는 default 를 넣어 몸체까지 구현가능하도록 됨