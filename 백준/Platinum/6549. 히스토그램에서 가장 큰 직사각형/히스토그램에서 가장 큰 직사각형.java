import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] histogram;
    public static long area;
    public static Stack<Integer> stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트케이스가 종료될 때까지 반복
        while(true) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            // 0인 경우 테스트 종료이므로 break
            if(n == 0) break;
            // 0이 아닌 경우 테스트 진행, 히스토그램을 담을 배열 선언
            histogram = new int[n];

            for(int i = 0; i < n; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            
            // 최대 넓이 계산 시작
            bw.write(String.valueOf(getArea(histogram.length)) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static long getArea(int len) {
        stk = new Stack<Integer>();
        area = 0;

        for(int i = 0; i < len; i++) {
            // 스택의 최상단 원소를 idx로 갖는 직사각형의 높이보다 현재 직사각형의 높이가 낮으면,
            // 지금까지 스택에 쌓여있는 직사각형의 넓이를 순차적으로 구해나간다.
            while(!stk.isEmpty() && histogram[stk.peek()] >= histogram[i]) {
                int height = histogram[stk.pop()];
                // (중요) 너비를 구할 경우
                // 1) 스택 최상단 원소를 제거 하였는데도 스택에 원소가 남아있는 경우, 직사각형이 더 존재한다는 것이므로,
                //    현재 idx보다 1작은 idx가 출발점(i-1)이고, 다음 직사각형의 idx(stk.peek())가 종료지점이다.
                // 2) 스택 최상단 원소를 제거 하였는데, 스택에 원소가 남아있지 않는 경우, 현재 idx가 너비가 되므로,
                //    너비는 i이다.
                long width = stk.isEmpty() ? i : i-1-stk.peek();

                // 넓이 계산할 때마다 최대 넓이 갱신
                area = Math.max(area, height*width);
            }

            // while문 종료 시 스택에 담겨있는 원소들의 직사각형 높이는 i번째 직사각형 높이보다 작다는 것이므로,
            // i번째 idx를 스택에 담는다.
            stk.push(i);
        }

        // 직사각형의 개수만큼 반복문을 수행하고 난 후에도 스택에 원소가 남아있을 수 있으므로,
        // 똑같은 과정을 진행한다.
        while(!stk.isEmpty()) {
            int height = histogram[stk.pop()];
            long width = stk.isEmpty() ? len : len-1-stk.peek();

            area = Math.max(area, height*width);
        }

        return area;
    }
}