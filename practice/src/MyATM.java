
class ATM{
	
	int total;
	
	public ATM( int total) {
		
		this.total += total;
		System.out.println("current total money is"+total);
		
	}
	
	synchronized public void deposit (int amount, String name) {
		
		total+=amount;
		System.out.println(name+"!, your amount of account is "+total);
	}
	
	synchronized public void withdraw(int amount, String name) {
		
		if (total > amount) {
			total -= amount;
			System.out.println(name+"!, your remaining amount is "+total);
			
		}else {
			
			System.out.println(name+"!, Insufficient account balance. current amount is "+total);
		}
		
	}
	
	public void gettotal() {
		System.out.println("current money is "+ total);
	}
}

class User extends Thread{
	
	boolean flag = false;
	ATM atm;
	
	public User(String name, ATM atm) {
		super(name);
		
		for (int i = 0; i < 2; i++) {
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (flag) {
				atm.deposit((int)( Math.random()*10000), name);
				atm.gettotal();
			}else if (flag =! flag){
				atm.withdraw((int) (Math.random()*10000), name);
				atm.gettotal();
			}
			
		}
	}
	
	
}

public class MyATM {
	
	public static void main(String[] args) {
		
		ATM atm = new ATM(10000);
		
		Thread user1 = new Thread( new User("TOM", atm));
		Thread user2 = new Thread( new User("ANNY", atm));
		Thread user3 = new Thread( new User("SOPHY", atm));
		
		user1.start();
		user2.start();
		user3.start();
		
		
	}

}
