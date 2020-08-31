import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AddDigits {


    public int addDigits(int num) {
        if (num==0 || num<10){
            return num;
        }
        List<Integer> list=new ArrayList<>();
        return splitNumAdd(num,list);

    }
    private int splitNumAdd(int num,List<Integer> list) {
        String s = num + "";
        int len = s.length();
        int subNum=0;
        for (int i=0;i<len;i++){
            subNum+=Integer.parseInt(s.charAt(i)+"");
        }

        if (subNum>=10){
            splitNumAdd(subNum,list);
        }else{
            list.add(subNum);
        }
        return list.get(0);

    }

    public static void main(String[] args) {
        AddDigits addDigits=new AddDigits();
        int i = addDigits.addDigits(299);
        System.out.println("-------:"+i);
    }


}
