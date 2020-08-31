public class JudgeCircle {

    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        int len=moves.length();
        for(int i=0;i<len;i++){
            char c = moves.charAt(i);
            if (c=='U'){
                y++;
            }else if(c=='D'){
                y--;
            }else if (c=='L'){
                x--;
            }else if (c=='R'){
                x++;
            }
        }
        if (x==0 && y==0){
            return true;
        }else{
            return false;
        }

    }
}
