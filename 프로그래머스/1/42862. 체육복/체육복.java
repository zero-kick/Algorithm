class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //        /* HashSet 사용 */
//        // 1. set 생성
//        HashSet<Integer> resSet = new HashSet<>();
//        HashSet<Integer> lostSet = new HashSet<>();
//
//        for(int res : reserve)
//            resSet.add(res);
//        for(int los : lost) {
//            if(resSet.contains(los))
//                resSet.remove(los);
//            else
//                lostSet.add(los);
//        }
//
//        // 2. 여분 체육복이 있는 학생을 기준으로 체육복을 빌려준다.
//        for(int i : resSet) {
//            if(lostSet.contains(i-1))
//                lostSet.remove(i-1);
//            else if(lostSet.contains(i+1))
//                lostSet.remove(i-1);
//        }
//
//        // 3. 전체 학생 수에서 lostSet에 남은 학생 수를 빼준다.
//        return n - lostSet.size();

        /* 배열 사용 */
        int answer = 0;

        // 1. student 배열 생성 (체육복이 있으면 0)
        int[] student = new int[n+2];

        // 2. 체육복 초기화
        for(int i :reserve)
            student[i]++;
        for(int i : lost)
            student[i]--;

        // 3. 빌려주기
        for(int i = 1; i < n+1; i++) {
            if(student[i] > 0) {
                if(student[i-1] < 0) {
                    student[i]--;
                    student[i-1]++;
                } else if(student[i+1] < 0) {
                    student[i]--;
                    student[i+1]++;
                }
            }
        }

        // 3. 체육복 1개 이상 보유한 학생 카운트
        for(int i = 1; i < student.length-1; i++)
            if(student[i] >= 0)
                answer++;

        return answer;
    }
}