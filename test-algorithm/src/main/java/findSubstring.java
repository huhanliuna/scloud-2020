import java.util.*;

public class findSubstring {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> startList = new ArrayList<>();
        int len = s.length();
        int wordLen = words[0].length();
        int wordNum = words.length;

        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            Integer count = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, count + 1);
        }
        for (int i = 0; i < len - wordLen * wordNum + 1; i++) {
            int num = 0;
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            while (num < wordNum) {
                String currentWord = s.substring(i + num * wordLen, i + (num + 1) * wordLen);

                if (wordsMap.containsKey(currentWord)) {
                    int value = hasWords.getOrDefault(currentWord, 0);
                    hasWords.put(currentWord, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(currentWord) > wordsMap.get(currentWord)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                startList.add(i);
            }
        }

        return startList;
    }

    public static List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();
        //HashMap1 存所有单词
        HashMap<String, Integer> allWords = new HashMap<String, Integer>();
        for (String w : words) {
            int value = allWords.getOrDefault(w, 0);
            allWords.put(w, value + 1);
        }
        //遍历所有子串
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            //HashMap2 存当前扫描的字符串含有的单词
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                //判断该单词在 HashMap1 中
                if (allWords.containsKey(word)) {
                    int value = hasWords.getOrDefault(word, 0);
                    hasWords.put(word, value + 1);
                    //判断当前单词的 value 和 HashMap1 中该单词的 value
                    if (hasWords.get(word) > allWords.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }
            //判断是不是所有的单词都符合条件
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }


    //-2 ,-2, 2 ,2,-2-,2,2,2
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int maxAreaA = (C - A) * (D - B);

        int maxAreaB = (G - E) * (H - F);


        //求出交叉面积
        long leftDownX = Math.max(E, A);
        long leftDownY = Math.max(F, B);

        long rightUpX = Math.min(C, G);
        long rightUpY = Math.min(D, H);

        if (rightUpX - leftDownX > 0 && rightUpY - leftDownY > 0) {
            long s = (rightUpX - leftDownX) * (rightUpY - leftDownY);
            return (int) (maxAreaA+maxAreaB-s);
        }
        return maxAreaA+maxAreaB;



}

    public static void main(String[] args) {

        int i = computeArea(-3, 0, 3, 4, 4, -1, 9, 2);
        System.out.println("---------"+i);
        //"wordgoodgoodgoodbestword"
        //["word","good","best","good"]
        List<Integer> barfoofoobarthefoobarman = findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});


        System.out.println("------------" + barfoofoobarthefoobarman);
    }


}
