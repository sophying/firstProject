import java.util.Scanner;

public class NextTest_2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		//nextInt()
		System.out.println("정수 입력 nextInt() : ");
		int i = scanner.nextInt();
		System.out.println(i);
		
		//nextLine()
		System.out.println("문자열 입력 nextLine() : ");
		String str1 = scanner.nextLine(); 
		System.out.println(str1);
		
		//next()
		System.out.println("문자열 입력 next() : ");
		String str2 = scanner.next();
		System.out.println(str2);
		
		//nextLine()
		System.out.println("문자열 입력 nextLine() : ");
		String str3 = scanner.nextLine(); 
		System.out.println(str3);
				
	}
}
// NumberFormatException  =>숫자가 아닌 문자를 입력하였을 경우 
