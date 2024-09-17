import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int N, C;

    public static int binarySearch(ArrayList<Integer> sum, int target) {
        int left = 0;
        int right = sum.size() - 1;
        int mid;
        int answer = -1;
        while(left <= right) {
            mid = (left + right) / 2;
            if(sum.get(mid) <= target) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void dfs(int idx, int sum, ArrayList<Integer> weight, ArrayList<Integer> comb) {
        // 3. 탈출조건
        if(sum > C) return;
        if(idx == weight.size()) {
            comb.add(sum);
            return;
        }

        // 1. 물건을 넣는 경우
        dfs(idx+1, sum+weight.get(idx), weight, comb);

        // 2. 물건을 안 넣는 경우
        dfs(idx+1, sum, weight, comb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer> weight1 = new ArrayList<>();
        ArrayList<Integer> weight2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            if(i < N / 2) weight1.add(Integer.parseInt(st.nextToken()));
            else weight2.add(Integer.parseInt(st.nextToken()));
        }

        // 1. dfs로 sum1, sum2 만들기
        ArrayList<Integer> sum1 = new ArrayList<>();
        ArrayList<Integer> sum2 = new ArrayList<>();

        dfs(0, 0, weight1, sum1);
        dfs(0, 0, weight2, sum2);

        // 2. sort 및 binary search
        Collections.sort(sum2);
        int answer = 0;
        for(int i = 0; i < sum1.size(); i++) {
            int searchVal = C - sum1.get(i);
            answer += binarySearch(sum2, searchVal) + 1;
        }

        bw.write(String.valueOf(answer));
        bw.flush();

        bw.close();
        br.close();
    }
}