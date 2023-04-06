import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        List<Integer> arrList = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) arrList.add(arr[i]);
        }
              
        int[] answer = new int[arrList.size() == 0 ? 1 : arrList.size()];
        
        if(arrList.size() == 0) {
            answer[0] = -1;
        } else {
            for(int i = 0; i < arrList.size(); i++) {
                answer[i] = arrList.get(i);
            }

            Arrays.sort(answer);
        }

        return answer;
    }
}