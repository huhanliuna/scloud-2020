import java.util.HashSet;
import java.util.Set;

public class LengthOfLongString {


    public static int lengthOfLongestSubstring(String s) {
        // set记录每个字符是否会出现过
        Set<Character> occ = new HashSet<Character>();
       int n=s.length();
       int lefty=0;
       //定义没有重复值的最大长度
       int ans=0;
       //i 定义字符串的起始位置
       for (int i=0;i<s.length();i++){
           if (i!=0){
               occ.remove(s.charAt(i-1));
           }
           while (lefty<n && !occ.contains(s.charAt(lefty))){
               occ.add(s.charAt(lefty));
               lefty++;
           }
           ans = Math.max(ans, occ.size());
       }
       return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbcefghbcefh"));
    }
}
