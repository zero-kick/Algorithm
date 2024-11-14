import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        // 모든 원소는 최소한 자기 자신만으로 이루어진 부분 수열이므로 길이 1로 초기화
        Arrays.fill(dp, 1);

        // 수열에서 이전 원소의 인덱스를 추적하기 위한 배열을 -1로 초기화
        // 모든 원소는 최소한 자기 자신만으로 이루어진 부분 수열이므로 이전 인덱스가 없는 것을 나타내기 위함
        Arrays.fill(prev, -1);

        // dp 점화식을 통한 LIS(Longest Increasing Subsequence) 계산
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && dp[i] < dp[j] + 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    prev[i] = j;
                }
            }
        }

        // 가장 긴 증가하는 수열 찾기
        int maxLen = 0;
        int lastIdx = -1;
        for (int i = 0; i < n; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        // LIS 복원
        List<Integer> lis = new ArrayList<>();
        while (lastIdx != -1) {
            lis.add(a[lastIdx]);
            lastIdx = prev[lastIdx];    // 이전 원소 추적
        }
        Collections.reverse(lis);

        bw.write(maxLen + "\n");
        for (int l : lis)
            bw.write(l + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}
