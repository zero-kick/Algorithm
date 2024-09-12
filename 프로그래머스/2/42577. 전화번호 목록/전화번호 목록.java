import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

//        /* sol1) Loop 활용 */
//        // 1. Sorting
//        Arrays.sort(phone_book);
//
//        // 2. Loop 비교
//        for(int i = 0; i < phone_book.length - 1; i++)
//            if(phone_book[i+1].startsWith(phone_book[i]))
//                return false;
//
//        // 3. 여기까지 왔다면 접두어가 없다는 것이다.
//        return true;

        /* sol2) hash 활용 */
        // 1. HashMap을 만든다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], 1);

        // 2. 각 전화번호의 접두어가 HashMap에 있는지 확인한다.
        for(int i = 0; i < phone_book.length; i++)
            for(int j = 1; j < phone_book[i].length(); j++)
                if(map.containsKey(phone_book[i].substring(0,j)))
                    return false;

        // 3. 여기까지 왔다면 접두어가 없다는 것이다.
        return true;
    }
}