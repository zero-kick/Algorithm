import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        br.close();

        int pipeCnt = 0;
        int cnt = 0;
        boolean laserYn = true;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 파이프조각이 생성되는 상황
            // 1. 레이저가 생성되었을때  ex. ((() : 두 조각 (열려있는 파이프 수만큼)
            // 2. 파이프가 닫혔을때  ex. ((()) : 두 조각 + 한 조각 (닫힌 파이프 수만큼)
            if(ch == '(') {
                pipeCnt++;
                laserYn = true;     // 좌괄호가 열린 후 최초로 우괄호가 닫히는 순간 레이저 생성됨
            } else {
                if(laserYn) {
                    pipeCnt--;
                    laserYn = false;
                    cnt += pipeCnt;
                } else {
                    pipeCnt--;
                    cnt += 1;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}