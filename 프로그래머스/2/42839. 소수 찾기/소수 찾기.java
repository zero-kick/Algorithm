import java.util.HashSet;
import java.util.Iterator;

class Solution {
    
    HashSet<Integer> numberSet = new HashSet<>();
    public void recursive(String comb, String others) {
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
        
        for(int i = 0; i < others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
    }
    
    public boolean isPrime(int num) {
        if(num == 0 || num == 1)
            return false;
        
        int limit = (int) Math.sqrt(num);
        
        for(int i = 2; i <= limit; i++)
            if(num % i == 0)
                return false;
        
        return true;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 1. 모든 숫자의 조합을 만든다.
        recursive("", numbers);
        
        // 2. 소수의 개수를 카운트한다.
        int cnt = 0;
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()) {
            int num = it.next();
            if(isPrime(num))
                cnt++;
        }
        
        // 3. 결과를 반환한다.
        return cnt;
    }
}