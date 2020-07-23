package niuke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dun Wenlong
 * @time 2020/7/3 21:11
 */
public class FindChar {
    class CharAndCount {
        public Character c;
        public Integer counts;

        public CharAndCount(Object c, Object counts) {
            this.c = (Character) c;
            this.counts = (Integer) counts;
        }
    }

    public String findChars(String str) {
        TreeMap<Character, Integer> conutCharMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            conutCharMap.put(tempChar, conutCharMap.getOrDefault(tempChar, 0) + 1);
        }
        CharAndCount[] res = new CharAndCount[conutCharMap.size()];
        int j = 0;
        for (Map.Entry entry : conutCharMap.entrySet()) {
            CharAndCount tempCharAndCount = new CharAndCount(entry.getKey(), entry.getValue());
            res[j] = tempCharAndCount;
            j++;
        }
        Arrays.sort(res, new Comparator<CharAndCount>() {
            @Override
            public int compare(CharAndCount o1, CharAndCount o2) {
                if (!o1.counts.equals(o2.counts)) {
                    return o2.counts - o1.counts;
                } else {
                    return o1.c - o2.c;
                }
            }
        });
        StringBuilder resStb = new StringBuilder();
        for (int i = 0; i < j; i++) {
            resStb.append(res[i].c);
        }
        return resStb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String tempStr = null;
        StringBuilder inputStb = new StringBuilder();
        while((tempStr =bf.readLine())!= null){
            inputStb.append(tempStr);
            FindChar findChar = new FindChar();
            System.out.println(findChar.findChars(inputStb.toString()));
        }
    }
}
