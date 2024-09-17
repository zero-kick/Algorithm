import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int n, k, answer;
    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        graph = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        // 1. 그래프 생성
        int x, y;
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = true;
        }

        // 2. DFS
        dfs(1);

        br.close();

        bw.write(String.valueOf(answer - 1));
        bw.flush();
        bw.close();

    }

    public static void dfs(int idx) {
        answer++;
        visited[idx] = true;
        for(int i = 1; i <= n; i++)
            if(!visited[i] && graph[idx][i])
                dfs(i);
    }
}