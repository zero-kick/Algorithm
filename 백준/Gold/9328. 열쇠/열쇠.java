import java.io.*;
import java.util.*;

public class Main {
    public static int tc, h, w, doc;
    public static char[][] bd;
    public static List<Character> keys;
    public static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static Queue<Node> q;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static List<Node>[] doors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            // 빌딩 세팅 => bd
            bd = new char[h][w];
            for(int i = 0; i < h; i++) {
                String[] strArr = br.readLine().split("");
                for(int j = 0; j < w; j++) {
                    char ch = strArr[j].charAt(0);
                    bd[i][j] = ch;
                }
            }

            // 최초에 소지한 키 => keys
            String[] keysArr = br.readLine().split("");
            keys = new ArrayList<Character>();
            for(int i = 0; i < keysArr.length; i++) {
                char ch = keysArr[i].charAt(0);
                if(ch != '0') keys.add(ch);
            }

            q = new LinkedList<Node>();
            visited = new boolean[h][w];

            // 키가 없는 문을 담아둘 리스트형 배열 초기화
            doors = new ArrayList[26];
            for(int k = 0; k < doors.length; k++) {
                doors[k] = new ArrayList<Node>();
            }

            // 출발지점 세팅
            doc = 0;
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    // 출발지점 세팅 (가장자리인 경우에만)
                    if(i == 0 || j == 0 || i == h-1 || j == w-1) {
                        // 이미 방문한 적이 있거나, 벽이면 skip
                        if(visited[i][j] || bd[i][j] == '*') continue;

                        // 탐색 진행
                        setNode(i, j);
                    }
                }
            }

            bw.write(String.valueOf(findDoc()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findDoc() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                // 빌딩 범위를 벗어나거나, 이미 방문하였거나, 벽이면 skip
                if(isNotRange(nx, ny) || visited[nx][ny] || bd[nx][ny] == '*') continue;

                // 탐색 진행
                setNode(nx, ny);
            }

            // 열쇠가 없어서 못열었던 문 중에 열쇠를 획득하여 이제는 열 수 있는 문이 있는지 확인하고,
            // 열 수 있으면 큐에 담아서 탐색
            for(int i = 0; i < doors.length; i++) {
                char chUpper = (char) ('A' + i);
                char chLower = String.valueOf(chUpper).toLowerCase().charAt(0);
                if(keys.contains(chLower)) {
                    for(int j = 0; j < doors[i].size(); j++) {
                        Node tmp = doors[i].get(j);
                        q.offer(new Node(tmp.x, tmp.y));
                        visited[tmp.x][tmp.y] = true;
                    }
                    doors[i].clear();
                }
            }
        }

        return doc;
    }

    public static boolean isNotRange(int x, int y) {
        return (x < 0 || x >= h || y < 0 || y >= w) ? true : false;
    }

    public static void setNode(int x, int y) {
        // 문인 경우, 해당 문을 열 수 있는 키가 없으면 별도 리스트에 담아두었다가 향후 열쇠를 얻는 경우 큐에 넣고 탐색
        char ch = String.valueOf(bd[x][y]).toLowerCase().charAt(0);
        if(bd[x][y] >= 'A' && bd[x][y] <= 'Z'
                // 최초에 키가 주어지지 않는 경우도 있으므로 size != 0 조건은 제거
                // && keys.size() != 0 && !keys.contains(ch)) {
                && !keys.contains(ch)) {
            doors[bd[x][y] - 'A'].add(new Node(x, y));
            return;
        }
        // 열쇠이면
        else if(bd[x][y] >= 'a' && bd[x][y] <= 'z') {
            keys.add(bd[x][y]);
        }
        // 문서이면
        else if(bd[x][y] == '$') {
            doc++;
        }

        q.offer(new Node(x, y));
        visited[x][y] = true;
    }
}