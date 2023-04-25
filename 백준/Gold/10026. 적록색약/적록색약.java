import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n;
    public static char[][] artRGB;
    public static char[][] artRB;
    public static int dx[] = {1, 0, -1, 0};
    public static int dy[] = {0, -1, 0, 1};

    public static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        // 일반사람이 보는 그림, 적록색약인 사람이 보는 그림 동시에 세팅
        artRGB = new char[n][n];
        artRB = new char[n][n];

        for(int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < strArr.length; j++) {
                char ch = strArr[j].charAt(0);
                artRGB[i][j] = ch;

                if(ch == 'G') {
                    ch = 'R';
                }

                artRB[i][j] = ch;
            }
        }
        br.close();

        bw.write(String.valueOf(findArt(artRGB)) + "\n");
        bw.write(String.valueOf(findArt(artRB)));

        bw.flush();
        bw.close();
    }

    public static int findArt(char[][] art) {
        // 탐색을 위한 큐 생성
        Queue<Pair> q = new LinkedList<Pair>();
        // 방문처리를 위한 배열 생성
        boolean[][] visit = new boolean[n][n];
        // 구역 카운트
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 이미 방문한 칸이면 skip
                if(visit[i][j] == true) continue;

                // 방문하지 않은 칸이면
                q.offer(new Pair(i, j));
                visit[i][j] = true;
                cnt++;

                // 인접칸 탐색
                while(!q.isEmpty()) {
                    Pair pollCell = q.poll();

                    for(int k = 0; k < 4; k++) {
                        int nx = pollCell.x + dx[k];
                        int ny = pollCell.y + dy[k];

                        // 인접 칸이 그림 범위를 벗어나거나, 이미 방문한 칸이거나, 색이 다르면 skip
                        if(isNotRange(nx, ny) || visit[nx][ny]
                                || art[pollCell.x][pollCell.y] != art[nx][ny]) continue;

                        q.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }

        return cnt;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= n || y < 0 || y >= n) ? true : false;
    }
}