import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main <T> {

    List<T> queue = new LinkedList<T>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Main<Integer> queueInt = new Main<Integer>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push" :
                    queueInt.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    bw.write(String.valueOf(queueInt.pop()) + "\n");
                    break;
                case "size" :
                    bw.write(String.valueOf(queueInt.size()) + "\n");
                    break;
                case "empty" :
                    bw.write(String.valueOf(queueInt.empty()) + "\n");
                    break;
                case "front" :
                    bw.write(String.valueOf(queueInt.front()) + "\n");
                    break;
                case "back" :
                    bw.write(String.valueOf(queueInt.back()) + "\n");
                    break;
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public void push(T x) {
        this.queue.add(x);
    }

    public int pop() {
        if(this.queue.isEmpty()) return -1;
        return (int) this.queue.remove(0);
    }

    public int size() {
        return this.queue.size();
    }

    public int empty() {
        if(this.queue.isEmpty()) return 1;
        return 0;
    }

    public int front() {
        if(this.queue.isEmpty()) return -1;
        return (int) this.queue.get(0);
    }

    public int back() {
        if(this.queue.isEmpty()) return -1;
        return (int) this.queue.get(this.queue.size()-1);
    }
}