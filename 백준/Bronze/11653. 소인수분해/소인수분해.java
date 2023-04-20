import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int cur = num;
		int i = 2;
		
		while(cur != 1) {
			if(cur%i == 0) {
				cur = cur / i;
				System.out.println(i);
			} else {
				i++;
			}
		}
	}

}
