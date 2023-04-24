import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int tc, i;
    public static char[][] board;
    public static int[][] visit;
    public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static Queue<Pair> q;

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
        StringTokenizer st;

        tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++) {
            i = Integer.parseInt(br.readLine());

            q = new LinkedList<Pair>();
            board = new char[i][i];
            visit = new int[i][i];
            for(int k = 0; k < i; k++) {
                Arrays.fill(visit[k], -1);
            }

            for(int k = 0; k < 2; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if(k == 0) {
                    board[x][y] = 'N';

                    q.offer(new Pair(x, y));
                    visit[x][y] = 0;
                } else {
                    board[x][y] = 'G';
                }
            }

            bw.write(String.valueOf(findGoal()) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int findGoal() {
        while(!q.isEmpty()) {
            Pair pollCell = q.poll();

            if(board[pollCell.x][pollCell.y] == 'G') return visit[pollCell.x][pollCell.y];

            for(int k = 0; k < 8; k++) {
                int nx = pollCell.x + dx[k];
                int ny = pollCell.y + dy[k];

                if(isNotRange(nx, ny) || visit[nx][ny] != -1) continue;

                q.offer(new Pair(nx, ny));
                visit[nx][ny] = visit[pollCell.x][pollCell.y] + 1;
            }
        }

        return 0;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= i || y < 0 || y >= i) ? true : false;
    }
}