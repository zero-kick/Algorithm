class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int cnt = t.length() - p.length() + 1;
        
        long numT = 0;
        long numP = Long.parseLong(p);
        
        for(int i = 0; i < cnt; i++) {
            numT = Long.parseLong(t.substring(i, i+p.length()));
            if(numT <= numP) answer++;
        }
        
        return answer;
    }
}