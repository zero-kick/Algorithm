import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int sum = 0;
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		String[] tmp = input.split(" ");
		
		for(int i = 0; i < tmp.length; i++)
			sum += Integer.parseInt(tmp[i]);
		
		System.out.println(sum);
		
		scan.close();
	}

}
