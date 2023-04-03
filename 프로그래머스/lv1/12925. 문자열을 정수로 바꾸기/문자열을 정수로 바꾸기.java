class Solution {
    public int solution(String s) {
        int answer = 0;
        int solCase = 1;
        
        switch(solCase) {
            case 1:
                answer = Integer.parseInt(s);
                break;
            default:
                String mark = "";
        
                for(int i = 1; i <= s.length(); i++) {
                    char ch = s.charAt(i-1);

                    if(i == 1) {
                        if(ch == '-') {
                            mark = "minus";
                        } else if(ch == '+') {
                            mark = "plus";
                        } else {
                            mark = "plus";
                            answer += (Character.getNumericValue(ch) * Math.pow(10, s.length() - i));
                        }

                        continue;
                    }

                    answer += (Character.getNumericValue(ch) * Math.pow(10, s.length() - i));
                }

                answer = mark.equals("plus") ? answer : answer * (-1);
                break;
        }
        
        return answer;
    }
}
