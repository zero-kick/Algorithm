import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            deque.offer(i+1);
        }

        int[] findArr = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            findArr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int i = 0; i < m; i++) {
            int tgtIdx = deque.indexOf(findArr[i]);
            int midIdx = deque.size()%2 == 0 ? deque.size()/2 - 1 : deque.size()/2;

            if(tgtIdx <= midIdx) {
                for (int j = 0; j < tgtIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    answer++;
                }
            } else {
                for(int j = deque.size(); j > tgtIdx; j--) {
                    deque.offerFirst(deque.pollLast());
                    answer++;
                }
            }

            deque.pollFirst();
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}