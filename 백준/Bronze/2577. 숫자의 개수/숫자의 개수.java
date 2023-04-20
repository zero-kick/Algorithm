import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int arr[] = new int[10];
        
        String mul = String.valueOf(a * b * c);
        
        for(int i = 0; i < mul.length(); i++) {
            arr[mul.charAt(i)-'0']++;
        }
        
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
    }
}