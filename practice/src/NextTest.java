import java.util.Scanner;

public class NextTest {
	public static void main(String[] args) {

		System.out.println("*** Scanner Test ***\n");

		Scanner sc1 = new Scanner("\n\nnext\n\nSophy\n");

		while (sc1.hasNext()) {
			System.out.println("next() : " + sc1.next());

		}

//		Scanner sc2 = new Scanner("next\n\nSophy");
//
//		while (sc1.hasNext()) {

			System.out.println("nextLine() : " + sc1.nextLine());

//		}

		while(true) {
	
			
			
			Scanner sc3 = new Scanner(System.in);
			while (sc3.hasNext()) {
	
				System.out.println("nextLine() : " + sc3.nextLine());
			}
			
			Scanner sc4 = new Scanner(System.in);
			
			while (sc4.hasNext()) {
				
				System.out.println("next() : " + sc4.next());
			}
			
		}
	}
}
