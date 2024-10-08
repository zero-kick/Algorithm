import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 수열의 현재 원소가 스택의 top 원소보다 등장 횟수가 많을 때
            while (!stk.isEmpty() && map.get(arr[i]) > map.get(arr[stk.peek()]))
                answer[stk.pop()] = arr[i];    // 오등큰수를 찾은 것이므로 answer 배열에 기록

            // 스택에는 인덱스 정보를 저장
            stk.push(i);
        }

        // 스택에 아직 남아있는 원소의 경우 오등큰수가 없다는 것이므로 -1을 기록
        while (!stk.isEmpty())
            answer[stk.pop()] = -1;

        for (int i : answer)
            bw.write(i + " ");

        bw.flush();
        bw.close();
        br.close();
    }
}