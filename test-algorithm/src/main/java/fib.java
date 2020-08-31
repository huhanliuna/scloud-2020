public class fib {


    public int fib(int N) {
        if (N==1 || N==0){
            return N;
        }
        //0,1,2,3,4,5,6,7,8,9,10,11
        //0,1,1,2,3,5,8,13,31,34,65
       int array[]=new int[N+1];

        array[0]=0;
        array[1]=1;
        for (int i=2;i<N+1;i++){
            array[i]=array[i-1]+array[i-2];
        }
        array[N]=array[N-1]+array[N-2];

       return array[N];
    }


    public void array(int[] array,int N){


    }


    public static void main(String[] args) {
        fib fib=new fib();
        fib.fib(3);
    }
}
