import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int tc, n, cnt, result;
    public static int pick[];
    public static boolean visited[];
    public static boolean finished[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            pick = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            cnt = 0;
            result = 0;
            for(int i = 1; i <= n; i++) {
                pick[i] = Integer.parseInt(st.nextToken());
            }

            findTeam();

            result = n - cnt;
            bw.write(String.valueOf(result) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findTeam() {
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) dfs(i);
        }
    }

    public static void dfs(int cur) {
        if(visited[cur]) return;

        visited[cur] = true;
        int next = pick[cur];

        if(!visited[next]) {
            dfs(next);
        // 노드 순회가 끝나지 않았는데, 이미 방문한 노드를 만난 경우 싸이클 형성
        } else {
            // 싸이클 형성 세팅 전 싸이클 내 학생 수 count
            if(!finished[next]) {
                // 싸이클을 순회하면서 학생수 + 1
                for(int i = next; i != cur; i = pick[i]) {
                    cnt++;
                }
                cnt++;      // 자기자신 count
            }
        }

        // 현재 노드는 싸이클
        finished[cur] = true;
    }
}
