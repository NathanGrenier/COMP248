package test;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
<<<<<<< Upstream, based on branch 'master' of https://github.com/NathanGrenier/COMP248.git
=======

		int total_1 = 0;
		int total_2 = 0;
>>>>>>> 9ee4d04 Pc Test local files
		
<<<<<<< Upstream, based on branch 'master' of https://github.com/NathanGrenier/COMP248.git
		Scanner scanner = new Scanner(System.in);
=======
		for (int k = 0; k<7; ++k) {
			total_1 += k;
		}
>>>>>>> 9ee4d04 Pc Test local files
		
<<<<<<< Upstream, based on branch 'master' of https://github.com/NathanGrenier/COMP248.git
		String value = scanner.next();
		String value2 = scanner.next();
		
		System.out.printf(value + "||" + value2);
		//System.out.println(str.substring(4));
		}
=======
		for (int i = 0; i<7; i++) {
			total_2 += i;
		}
		
		System.out.printf("%d : %d",total_1, total_2);
	}
>>>>>>> 9ee4d04 Pc Test local files
}
