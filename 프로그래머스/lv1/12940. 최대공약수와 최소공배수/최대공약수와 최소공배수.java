import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        List<Integer> maxDivisorList = new ArrayList<Integer>();
        List<Integer> minDivisorList = new ArrayList<Integer>();
       
        // 각각의 약수 구하기
        getSubMultiple(maxDivisorList, max);
        getSubMultiple(minDivisorList, min);
        
        // 최대공약수 구하기
        int gcd = 0;
        
        for(int i = 0; i < maxDivisorList.size(); i++) {
            for(int j = 0; j < minDivisorList.size(); j++) {
                if(maxDivisorList.get(i)%minDivisorList.get(j)==0) {
                    gcd = minDivisorList.get(j);
                    break;
                }
            }
            if(gcd != 0) break;
        }
        
        // 최소공배수 구하기
        boolean flag = true;
        int lcm = 0;
        int val = max;
        int i = 1;
        
        while(flag) {
            if(max%min==0) {
                lcm = max;
                flag = false;
            } else {
                i++;
                max = val * i;
            }
            
        }
        
        answer[0] = gcd;
        answer[1] = lcm;
        
        return answer;
    }
    
    public void getSubMultiple (List<Integer> DivisorList, int val) {
        for(int i = val; i > 0; i--) {
            if(val%i==0) {
                DivisorList.add(i);
            }
        }
    }
}