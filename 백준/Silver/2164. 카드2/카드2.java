import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            queue.offer(i+1);
        }

        while(queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        bw.write(String.valueOf(queue.poll()));
        bw.flush();
        bw.close();
    }
}