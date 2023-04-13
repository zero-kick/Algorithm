class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long usePrice = 0;
        
        for(int i = 1; i <= count; i ++) {
            usePrice += i * price;
        }
        
        if(money < usePrice) answer = usePrice - money;
        else answer = 0;
        
        return answer;
    }
}