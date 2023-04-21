import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int answer = 0;

        int[] aArr = new int[26];
        int[] bArr = new int[26];

        for(int i = 0; i < a.length(); i++) {
            aArr[a.charAt(i) - 'a']++;
        }

        for(int i = 0; i < b.length(); i++) {
            bArr[b.charAt(i) - 'a']++;
        }

        for(int i = 0; i < aArr.length; i++) {
            if(aArr[i] > bArr[i]) {
                answer += aArr[i] - bArr[i];
            } else if(aArr[i] < bArr[i]) {
                answer += bArr[i] - aArr[i];
            } else {
                continue;
            }
        }

        System.out.println(answer);
    }
}