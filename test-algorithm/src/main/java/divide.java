import java.util.Random;

public class divide {
    public static int divide(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if(dividend>0) {
            dividend = -dividend;
        }
        if(divisor>0) divisor = -divisor;
        while(dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while(dividend <= (temp_divisor << 1)) {
                if(temp_divisor <= (Integer.MIN_VALUE >> 1))break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if(!sign) {
            if(result <= Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }
            result = - result;
        }
        return result;


    }

    private static int judgeValue(int dividend, int divisor, int value) {
        if((dividend<0 && divisor<0) || (dividend>0 && divisor>0)){
            return value;
        }else{
            return -value;
        }
    }

    public static int dicide(int dividend,int divisor){
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int divide = divide(-2147483648, -1);
        //System.out.println(divide);
//        double pow = Math.pow(2, 31);
        int dicide = divide(9, 2);
        System.out.println(dicide);


        // int a=128;
//        String i = Integer.toString(128, 4);
//        System.out.println("-------i:"+i);
     //   int i1 = i << 1;

   //     System.out.println("------i1:"+i1);

//        int max=0;
////        int d = new Random().nextInt(100);
//        Random r = new Random();
//        long start = System.currentTimeMillis();
//        for (int i=0;i<Integer.MAX_VALUE;i++){
//           max += r.nextInt(100);
//        //    System.out.println(max);
//        }
//        System.out.println(System.currentTimeMillis()-start);
//        System.out.println(max);

//        int x = 0;
//        int x1 = x + Integer.MAX_VALUE;
//        System.out.println(x1);
//        int x2 = x1 + 1;
//        System.out.println(x2);
//        int x3 = x2 +Integer.MAX_VALUE;
//        System.out.println(x3);
//        int x4 = x3 +3;
//        System.out.println(x4);


    }
}
