import java.util.*;

class Solution {
    HashMap<String, Integer> courseFood = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {

        List<String> answerList = new ArrayList<>();

        // 1. 각 order 정렬
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }
        
        // 2. 각 order를 기준으로 courseLengh 만큼의 조합 만들기
        for(int courseLength : course) {
            for(String order : orders)
                combination("", order, courseLength);

            // 3. 가장 많은 조합을 answer에 저장한다.
            if(!courseFood.isEmpty()) {
                List<Integer> countList = new ArrayList<>(courseFood.values());
                int max = Collections.max(countList);

                if(max > 1)
                    for(String key : courseFood.keySet())
                        if(courseFood.get(key) == max)
                            answerList.add(key);
                courseFood.clear();
            }
        }

        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = answerList.get(i);

        return answer;
    }

    public void combination(String order, String others, int count) {
        // 1. 탈출 조건
        if(count == 0) {
            courseFood.put(order, courseFood.getOrDefault(order, 0) + 1);
            return;
        }
        
        // 2. 수행 동작 : 메뉴 조합
        for(int i = 0; i < others.length(); i++)
            combination(order + others.charAt(i), others.substring(i+1), count-1);

    }
}