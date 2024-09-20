class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        // 최소공배수를 이용해 분모를 맞춘다.
        int lcm = getLcm(denom1, denom2);
        int mul1 = lcm / denom1;
        int mul2 = lcm / denom2;
        
        // 두 분수를 더한 결과의 분자와 분모를 구한다.
        int numer = (numer1 * mul1) + (numer2 * mul2);
        int denom = lcm;
        
        // 기약분수로 만들기 위해 최대공약수로 나눈다.
        int gcd = getGcd(numer, denom);
        answer[0] = numer / gcd;
        answer[1] = denom / gcd;
        
        return answer;
    }
    
    public int getLcm(int denom1, int denom2) {
        return (denom1 * denom2) / getGcd(denom1, denom2);
    }
    
    public int getGcd(int a, int b) {
        if(b == 0)
            return a;
        
        return getGcd(b, a % b);
    }
}