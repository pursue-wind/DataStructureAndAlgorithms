package LeetCode;

import java.util.TreeSet;

/**
 * @program: DataStructureAndAlgorithms
 * @description: 804. 唯一摩尔斯密码词
 * @author: mirrorming
 * @create: 2019-01-03 22:05
 **/

public class LeetCode_804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> ts = new TreeSet<>();
        for (String word : words) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < word.length(); i++)
                sb.append(codes[word.charAt(i) - 'a']);
            ts.add(sb.toString());
        }
        return ts.size();
    }
}