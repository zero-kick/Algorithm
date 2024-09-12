import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

//        /* sol1) 정렬 사용 */
//        // 1. 두 배열을 정렬한다.
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//
//        // 2. 두 배열이 다를 때까지 찾는다.
//        int i = 0;
//        for(; i < completion.length; i++) {
//            if(!participant[i].equals(completion[i]))
//                break;
//        }
//
//        // 3. 완주 배열만큼 돌았는데도, 서로 다른 사람을 찾지 못하였다면,
//        //    마지막 주자가 완주하지 못한 선수
//        return participant[i];

        /* sol2) hash 사용 */
        // 1. HashMap을 만든다. (participant 기준)
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant)
            map.put(player, map.getOrDefault(player, 0) + 1);

        // 2. HashMap을 돈다. (completion 기준)
        for (String player : completion)
            map.put(player, map.get(player) - 1);

        // 3. value가 0이 아닌, 완주하지 못한 선수를 찾는다.
//        // 3-1. keySet
//        for (String key : map.keySet()) {
//            if(map.get(key) != 0) {
//                answer = key;
//                break;
//            }
//        }

        // 3-2. entrySet
        Iterator<Map .Entry<String, Integer>> iter = map.entrySet().iterator();

        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0 ) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}