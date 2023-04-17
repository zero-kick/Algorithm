import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        String[] alphabetLower = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] alphabetUpper = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        List<String> apbLcList = Arrays.asList(alphabetLower);
        List<String> apbUcList = Arrays.asList(alphabetUpper);
        
        for(int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i, i+1);
            
            if(subStr.equals(" ")) {
                answer += subStr;
            } else {
                if(apbLcList.indexOf(subStr) > -1) {
                    try {
                        answer += apbLcList.get(apbLcList.indexOf(subStr) + n);
                    } catch (Exception e) {
                        answer += apbLcList.get(n - (apbLcList.indexOf("z") - apbLcList.indexOf(subStr) + 1));
                    }
                } else if(apbUcList.indexOf(subStr) > -1) {
                    try {
                        answer += apbUcList.get(apbUcList.indexOf(subStr) + n);
                    } catch (Exception e) {
                        answer += apbUcList.get(n - (apbUcList.indexOf("Z") - apbUcList.indexOf(subStr) + 1));
                    }
                }
            }
        }
        
        return answer;
    }
}