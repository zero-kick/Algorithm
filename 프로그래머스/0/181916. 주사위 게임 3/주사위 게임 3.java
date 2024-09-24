import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int answer = 0;

        if (counts.size() == 1) {
            // 네 주사위 모두 같은 숫자
            answer = 1111 * arr[0];
        } else if (counts.size() == 2) {
            // 두 개의 숫자가 각각 3개와 1개 또는 2개와 2개인 경우
            Collection<Integer> frequencies = counts.values();
            if (frequencies.contains(3)) {
                // 세 개의 같은 숫자
                int p = 0, q = 0;
                for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                    if (entry.getValue() == 3) p = entry.getKey();
                    else q = entry.getKey();
                }
                answer = (int) Math.pow((10 * p + q), 2);
            } else {
                // 두 쌍의 숫자가 같은 경우
                List<Integer> nums = new ArrayList<>(counts.keySet());
                int p = nums.get(0);
                int q = nums.get(1);
                answer = (p + q) * Math.abs(p - q);
            }
        } else if (counts.size() == 3) {
            // 한 쌍의 같은 숫자와 두 개의 다른 숫자
            int pairNum = 0;
            List<Integer> singleNums = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                if (entry.getValue() == 2) pairNum = entry.getKey();
                else singleNums.add(entry.getKey());
            }
            answer = singleNums.get(0) * singleNums.get(1);
        } else {
            // 모든 숫자가 다른 경우
            answer = arr[0];
        }

        return answer;
    }
}