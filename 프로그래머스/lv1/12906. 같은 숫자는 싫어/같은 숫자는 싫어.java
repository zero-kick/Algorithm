import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> stack = new ArrayList<Integer>();
        stack.add(arr[0]);
        
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] != arr[i+1]) {
                stack.add(arr[i+1]);
            } else {
                continue;
            }
        }
        
        int[] answer = new int[stack.size()];
        
        for(int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}