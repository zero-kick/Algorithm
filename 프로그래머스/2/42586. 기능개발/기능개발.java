import java.util.*;

class Solution {
    //    public static class Work {
//        int num, p, s, day;
//        Work(int num, int p, int s, int day) {
//            this.num = num;
//            this.p = p;
//            this.s = s;
//            this.day = day;
//        }
//    }
//    public static Queue<Work> q;

    public int[] solution(int[] progresses, int[] speeds) {

//        q = new LinkedList<Work>();
//        for(int i = 0; i < progresses.length; i++)
//            q.offer(new Work(i, progresses[i], speeds[i], 1));
//
//        int[] commit = new int[progresses.length];
//        while(!q.isEmpty()) {
//            Work peek = q.poll();
//            if(peek.p + peek.s >= 100)
//                commit[peek.num] = peek.day;
//            else
//                q.offer(new Work(peek.num,peek.p+peek.s, peek.s, peek.day+1));
//        }
//
//        for(int i = 0; i < commit.length-1; i++)
//            if(commit[i] > commit[i+1]) commit[i+1] = commit[i];
//
//        System.out.println(Arrays.toString(commit));
//
//        HashMap<Integer, Integer> map = new LinkedHashMap<>();
//        for(int i : commit)
//            map.put(i, map.getOrDefault(i, 0)+1);
//
//        int[] answer = map.values().stream().mapToInt(Integer::intValue).toArray();
//
//        return answer;

        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            // 1. 한 개 기능을 개발하는데 필요한 날짜 계산
            double days = (100-progresses[i]) / (double) speeds[i];
            int daysUp = (int) Math.ceil(days);

            // 2. 함께 배포할 기능의 index 찾기
            int j = i + 1;
            for(; j < progresses.length; j++) {
                if(progresses[j] + daysUp * speeds[j] < 100)
                    break;
            }

            // 3. 이번에 배포할 기능의 개수를 추가하기
            answer.add(j - i);
            i = j - 1;
        };

        return answer.stream().mapToInt(i -> i.intValue()).toArray();
    }
}