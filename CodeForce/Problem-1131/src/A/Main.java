package A;
import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner cin = new Scanner(new BufferedInputStream(System.in));
		int w1 = cin.nextInt();
		int h1 = cin.nextInt();
		int w2 = cin.nextInt();
		int h2 = cin.nextInt();
		System.out.println(((h1 + h2 ) * 2 + (w1 + 2) * 2));
	}
}
