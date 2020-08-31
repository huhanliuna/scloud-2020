public class test01 {
    private static int n1=1;

    static {
        n1=2;
        num=200;
    }
    private static int num=100;

    public static void main(String[] args) {
        test01 test01=new test01();
        try {
            test01.test1();
        } catch (Exception e) {
            System.out.println("-------");
            e.printStackTrace();
        }
    }

    public void test1() throws Exception{
        test2();
    }

    public void test2(){
        int n=10/0;
      //  Object[] a=new Object[]{1,'a','c'};
    }
}
