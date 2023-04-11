import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split("");
        
        Arrays.sort(strArr, Comparator.reverseOrder());
        
        for(int i = 0; i < strArr.length; i++) {
            answer += strArr[i];
        }
        
        return answer;
    }
}