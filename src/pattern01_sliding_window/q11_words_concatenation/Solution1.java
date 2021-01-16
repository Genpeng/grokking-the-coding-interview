package pattern01_sliding_window.q11_words_concatenation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string and a list of words, find all the starting indices of substrings in the given string that
 * are a concatenation of all the given words exactly once without any overlapping of words. It is given that
 * all words are of the same length.
 *
 * Example 1:
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 *
 * Example 2:
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: string;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public List<Integer> findWordConcatenation(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        int sLen = s.length(), wordNum = words.length, wordLen = words[0].length();
        // 步骤1：统计所有词的词频
        Map<String, Integer> wordFreq = new HashMap<>(wordNum);
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        // 步骤2：遍历所有可能的起始位置，每次添加一个词，如果该词在词表中不存在，
        // 或者该词的词频多于词表的词频，则该起始位置不可能包含词表中所有的词；
        // 如果该起始位置最终可以得到词表中所有的词，则将该位置加入结果列表中
        for (int i = 0; i <= sLen - wordNum * wordLen; ++i) {
            Map<String, Integer> wordSeen = new HashMap<>(wordNum);
            for (int j = 0; j < wordNum; ++j) {
                int si = i + j * wordLen;
                String word = s.substring(si, si + wordLen);
                if (!wordFreq.containsKey(word)) {
                    break;
                }
                wordSeen.put(word, wordSeen.getOrDefault(word, 0) + 1);
                if (wordSeen.get(word) > wordFreq.get(word)) {
                    break;
                }
                if (j == wordNum - 1) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.findWordConcatenation("catfoxcat", new String[] {"cat", "fox"}));
        System.out.println(solu.findWordConcatenation("catcatfoxfox", new String[] {"cat", "fox"}));
    }
}