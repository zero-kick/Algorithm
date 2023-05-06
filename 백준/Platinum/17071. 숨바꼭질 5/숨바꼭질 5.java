import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static boolean visited[][];
    public static int[] dx = {2, -1, 1};
    public static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        q = new LinkedList<Integer>();
        visited = new boolean[2][500001];

        q.offer(n);
        visited[0][n] = true;   // 0초 방문 체크

        bw.write(String.valueOf(findBro()));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findBro() {
        if(n == k) return 0;

        int size, flag, time = 0;

        while(!q.isEmpty()) {
            size = q.size();
            time++;
            flag = time % 2;    // 짝수초는 0, 홀수초는 1

            // 동생 이동
            k += time;
            // 동생이 맵을 벗어나면 못찾으므로 return -1
            if(k > 500000) return -1;
            
            for(int i = 0; i < size; i++) {
                int cur = q.poll();
                
                for(int j = 0; j < 3; j++) {
                    int nx;
                    if(j == 0) {
                        nx = cur * dx[j];
                    } else {
                        nx = cur + dx[j];
                    }

                    if(isNotRange(nx) || visited[flag][nx]) continue;

                    q.offer(nx);
                    visited[flag][nx] = true;
                }
            }

            // 동생이 있는 위치가 방문되었다면
            if(visited[flag][k]) return time;
        }

        return -1;
    }

    public static boolean isNotRange(int x) {
        return (x < 0 || x >= 500001) ? true : false;
    }
}