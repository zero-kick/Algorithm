import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, area, year;
    public static boolean isIceburg;
    public static int[][] iceburg;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        iceburg = new int[n][m];
        q = new LinkedList<Node>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                iceburg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        year = -1;   // 경과 년수 초기화, (빙산의 area를 카운트하는 시점이 그 빙산이 세팅이 된 다음 턴이므로)

        // 빙산이 2덩어리가 되거나, 0으로 없어질때까지 반복
        while(countArea() == 1);

        if(isIceburg) bw.write(String.valueOf(year));
        else bw.write("0");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int countArea() {
        isIceburg = false;  // 빙산 유무 flag
        area = 0;   // 덩어리 수 초기화
        visited = new boolean[n][m];    // 방문처리 초기화

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // 빙산이 아니거나, 이미 방문한 빙산이면 skip
                if(iceburg[i][j] <= 0 || visited[i][j]) continue;

                // 빙산이 있으면 flag true
                isIceburg = true;

                // 영역 +1
                area++;

                q.offer(new Node(i, j));
                visited[i][j] = true;

                while(!q.isEmpty()) {
                    Node curNode = q.poll();

                    int cnt = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = curNode.x + dx[k];
                        int ny = curNode.y + dy[k];

                        // 노출 면의 수 구하기, 해당 년도에 빙산이었던 경우는 제외해야하므로 방문 여부도 체크
                        if(iceburg[nx][ny] <= 0 && !visited[nx][ny]) cnt++;

                        // 바다 범위를 벗어나거나, 바다이거나, 이미 방문한 빙산이면 skip
                        if(isNotRange(nx, ny) || iceburg[nx][ny] <= 0 || visited[nx][ny]) continue;

                        // 다음 탐색 칸 큐에 넣고, 방문처리
                        q.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }

                    // 현재 칸의 노출 면수에 따라 높이 차감
                    iceburg[curNode.x][curNode.y] -= cnt;
                }
            }
        }

        // +1년 경과
        year++;

        // 빙산이 없을때 까지 2덩어리가 되지 못했으므로
        if(!isIceburg) return 0;
        else return area;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= m) ? true : false;
    }
}