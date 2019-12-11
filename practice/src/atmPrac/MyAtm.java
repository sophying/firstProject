package atmPrac;

class Atm {

	int total; // 계좌 금액

	public Atm(int total) {

		this.total = total;
		System.out.println("현재 잔액은 " + total + "입니다.\n");

	}

	// deposit Method
	public void deposit(int amount, String name) {

		total += amount;
		System.out.println(name + " 님의 현재 잔액은 " + amount + " 원 입금되어 " + total + " 입니다.");

	}

	// withdraw Method
	public void withdraw(int amount, String name) {

		if (amount < total) {

			total -= amount;
			System.out.println(name + " 님의 계좌에서 " + amount + "원이 출금되었습니다.");

		} else
			System.out.println("*** 잔액 부족으로 " + amount + " 원 출금 불가 ***");

	}

	// total count Method
	public void getTotal() {

		System.out.println("\n<<<<< 현재 잔액 총 " + total + " >>>>>>\n");
	}

}

class User extends Thread {
	// 여러명의 고객이 입출금을 한 계좌로 동시에 진행 할 것이므로 Thread 상속

	// 하나의 계좌
	Atm atm;

	// false = withdraw
	boolean flag = false;

	public User(String name, Atm atm) {

		// user name
		super(name);

		// 1초마다 반복적으로 입금 출금순으로 진행 (for문 , thread.sleep(1000) => try/catch)
		for (int i = 0; i < 2; i++) {

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (atm) {
				// 고객은 입금과 출금의 동작을 진행할 것 ( deposit, withdraw )

				if (flag) { // default = false

					atm.deposit((int) (Math.random() * 10000), name);
//					atm.getTotal();

				} else if (flag = !flag) {

					atm.withdraw((int) (Math.random() * 10000), name);
					atm.getTotal();
				}
			}

		}

	}

}

public class MyAtm {
	public static void main(String[] args) {

		// Atm class & User class 호출
		Atm atm = new Atm(10000);

		// Thread 를 상속하였으므로 Thread를 호출하는 참조변수 생성
		Thread thread1 = new Thread(new User("Tom", atm));
		Thread thread2 = new Thread(new User("Sophy", atm));
		Thread thread3 = new Thread(new User("Ann", atm));

		// Thread class 상속으로 start() 메소드 호출

		thread1.start();
		thread2.start();
		thread3.start();

	}

}
