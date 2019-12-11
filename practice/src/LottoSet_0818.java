import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class LottoSet_0818 {
	public static void main(String[] args) {
		System.out.println("로또 번호를 추출할 횟수를 입력하세요.");

		Scanner sc = new Scanner(System.in);
		int play_count = sc.nextInt();

		for (int i = 1; i <= play_count; i++) {
			System.out.println(i + " 번째" + making_lottonumber());
		}

	}

	public static String making_lottonumber() {

		Set<Integer> set = new HashSet<Integer>();

		while (set.size() != 6) {
			set.add((int) (Math.random() * 45 + 1));
		}

		List<Integer> list = new ArrayList<Integer>(set);

		Collections.sort(list);

		return list.toString();
	}

}
