
public class ThreadTest extends Thread {

	static boolean autoSave = false;

	public static void main(String[] args) {

		ThreadTest obj = new ThreadTest();

		obj.setDaemon(true);
		// Thread 에 종속되어 실행되는 메소드로 true 일 경우 메인 쓰레드의 보조적인 역할을 수행 함
		// 메인 쓰레드가 종료되면 종속되어있는 다른 쓰레드의 작업이 끝나지 않았음에도 Daemon() 을 통해 강제 종료됨
		// 만일 setDaemon()이 없다면 메인 쓰레드는 종료되었다 할지라도 부수적인 다른 쓰레드는 종료되지 못한채 무한루프에 빠져 계속 프로그램
		// 뒤에서 돌 것이다.

		obj.start();

		for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(1000);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (i == 5) {
				autoSave = true;
			}
		}
		System.out.println("프로그램 종료");

	}

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			if (autoSave) {
				autoSave();
			}

		}

	}

	private void autoSave() {

		System.out.println("작업파일이 저장되었습니다.");

	}

}
