import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int m, n, h;
    public static int[][][] box;
    public static int[][][] growTime;
    public static Queue<Pair> q;
    public static class Pair {
        int x, y, z;
        Pair(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

    public static int dx[] = {1, 0, -1, 0, 0, 0};
    public static int dy[] = { 0, -1, 0, 1, 0, 0};
    public static int dz[] = { 0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 상자의 가로, 세로, 높이
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // 상자 생성
        box = new int[h][n][m];
        // 방문, 익는 기간 체크를 위한 배열 생성
        growTime = new int[h][n][m];
        // 탐색을 위한 큐 생성
        q = new LinkedList<Pair>();

        for(int z = 0; z < h; z++) {
            for(int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for(int y = 0; y < m; y++) {
                    box[z][x][y] = Integer.parseInt(st.nextToken());

                    // 익은 토마토가 있으면 큐에 넣고, 방문시간 0으로 초기화
                    if(box[z][x][y] == 1) {
                        q.offer(new Pair(z, x, y));
                        growTime[z][x][y] = 0;
                    // 토마토가 없거나, 익지 않았으면 방문시간 -1로 초기화
                    } else {
                        growTime[z][x][y] = -1;
                    }
                }
            }
        }
        br.close();

        // 탐색 시작
        bw.write(String.valueOf(findBox()));
        bw.flush();
        bw.close();

    }

    public static int findBox() {
        // 익어있는 토마토가 없다면 return -1
        if(q.isEmpty()) return -1;

        // 탐색 시작
        while(!q.isEmpty()) {
            Pair pollCell = q.poll();

            // 인접칸 탐색 (하, 좌, 우, 상, 3차원 하, 3차원 상)
            for(int i = 0; i < 6; i++) {
                int nx = pollCell.x + dx[i];
                int ny = pollCell.y + dy[i];
                int nz = pollCell.z + dz[i];

                // 인접칸의 범위가 박스를 벗어나거나, 이미 방문한 칸이거나, 토마토가 없는 칸이면 skip
                if(isNotRange(nz, nx, ny) || growTime[nz][nx][ny] != -1 || box[nz][nx][ny] == -1) continue;

                q.offer(new Pair(nz, nx, ny));
                growTime[nz][nx][ny] = growTime[pollCell.z][pollCell.x][pollCell.y] + 1;
            }
        }

        // 케이스 체크
        int days = 0;
        int cnt = 0;

        for(int z = 0; z < h; z++) {
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < m; y++) {
                    // 익지 못한 토마토가 있는지 체크
                    if(box[z][x][y] != -1 && growTime[z][x][y] == -1) return -1;
                    
                    // 최소 일수 체크
                    if(days < growTime[z][x][y]) days = growTime[z][x][y];
                    
                    // 처음부터 모든 토마토가 익어있었는지 확인 (익어있지 않은 토마토가 있는지로 체크)
                    if(box[z][x][y] == 0) cnt++;
                }
            }
        }

        if(cnt == 0) return 0;

        return days;
    }

    public static boolean isNotRange(int z, int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= m || z < 0 || z >= h) ? true : false;
    }
}