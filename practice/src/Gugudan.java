import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		int gugu = 0;
		int gugu2 = 0;
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println(" 첫번째 단을 입력해주세요");
			try {
				gugu = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println(" 숫자만 입력하세요.");
				continue;
			}

			System.out.println("두번째 단을 입력해주세요");

			try {
				gugu2 = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println(" 숫자만 입력하세요.");
				continue;
			}

			for (int j = gugu; j <= gugu2; j++) {

				for (int i = 1; i <= 9; i++) {

					System.out.println(j + "*" + i + "=" + (j * i));
				}
				System.out.println();

			}
		}
	}
}