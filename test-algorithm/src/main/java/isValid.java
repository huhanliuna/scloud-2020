import java.util.*;

public class isValid {

    public List<Character> punctLeft=new ArrayList(Arrays.asList('(','[','{'));

    public List<Character> punctRight=new ArrayList(Arrays.asList(')',']','}'));
    public boolean isValid(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }
            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek()!= pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();

    }

    public int threeSumClosest(int[] nums, int target) {
        List<Integer> list=new ArrayList<>();
        int len=nums.length;
        Arrays.sort(nums);
        for (int i=0;i<len-2;i++) {
            int a=nums[i];
            for (int j=i+1;j<len-1;j++){
                int b=nums[j];
                for (int m=j+1;m<nums.length;m++){
                    int c=nums[m];
                    list.add(Math.abs(target-a-b-c));
                }

            }
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        int num = target - list.get(0);

        return num;
    }

    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if (digits==null || "".equals(digits)){
            return list;
        }
        Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        int length = digits.length();
        for (int i=0;i<length;i++){
            char c = digits.charAt(i);
            String s = map.get(c);

        }


        return null;

    }
    public static void main(String[] args) {
        isValid isValid=new isValid();
       // int i = isValid.threeSumClosest(new int[]{1, -1, 2,4,9,5,9}, 9);
        //System.out.println(i);

        HashMap map=new HashMap();
        for(int i=0;i<11;i++){
            map.put("key1"+i,23+i);
        }
        map.put("key20",23);
        map.put("key21",224);

        System.out.println(1 << 30);
        long k=2;
       for (int i=0;i<29;i++){
        k=k*2;
       }
        System.out.println(k);
        System.out.println(Integer.MAX_VALUE);




    }



}
