import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] graph = new int[201];
        
        for(int[] line : lines) {
            int stt = line[0] + 100;
            int end = line[1] + 100;
            
            for(int i = stt; i < end; i++)
                graph[i]++;
        }
        
        for(int i : graph)
            if(i > 1)
                answer++;
        
        return answer;
    }
}