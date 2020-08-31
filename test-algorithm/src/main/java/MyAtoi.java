
public class MyAtoi {

    public int myAtoi(String str) {
        int length = str.length();
        int idx=0;
        while (idx<length && str.charAt(idx)==' '){
            idx++;
        }
        if (idx==length){
            return 0;
        }

        return 0;
    }
}
