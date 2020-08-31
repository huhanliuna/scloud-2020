public class IntegrReverse {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0.0;
    }

    public static int reverse(int x) {
        int ans=0;
        while (x!=0){
            int pos=x%10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pos > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pos < -8))
                return 0;
            ans=ans*10+pos;
            x=x/10;

        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(reverse(1234567899));

        System.out.println(Integer.MAX_VALUE+",,,"+Integer.MIN_VALUE);

    }

}
