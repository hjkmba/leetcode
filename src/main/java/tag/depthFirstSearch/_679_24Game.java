package tag.depthFirstSearch;


import java.util.*;

/**
 * Created by he.dong on 10/13/2017.
 */
public class _679_24Game {
    public boolean judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v: nums) A.add((double) v);
//        return solve(A);
        return mySelfCopiedSolve(A);
    }
    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1) return Math.abs(nums.get(0) - 24) < 1e-6;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    ArrayList<Double> nums2 = new ArrayList<Double>();
                    for (int k = 0; k < nums.size(); k++) if (k != i && k != j) {
                        nums2.add(nums.get(k));
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) nums2.add(nums.get(i) + nums.get(j));
                        if (k == 1) nums2.add(nums.get(i) * nums.get(j));
                        if (k == 2) nums2.add(nums.get(i) - nums.get(j));
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    private boolean mySelfCopiedSolve(ArrayList<Double> nums) {
        if (nums.size()<=0)
            return false;
        if (nums.size() == 1 && Math.abs(nums.get(0) - 24) < 1e-6)
            return true;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                ArrayList<Double> next = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j)
                        next.add(nums.get(k));
                }
                ArrayList<Double> operation = new ArrayList<>();
                operation.addAll(Arrays.asList(nums.get(i) + nums.get(j),
                        nums.get(i) - nums.get(j),
                        nums.get(i) * nums.get(j)));
                if (Math.abs(nums.get(i) - nums.get(j))>1e-6) {
                    operation.add(nums.get(j) - nums.get(i));
                }
                if (nums.get(i) != 0)
                    operation.add(nums.get(i) / nums.get(j));
                if (nums.get(j) !=0)
                    operation.add(nums.get(j) / nums.get(i));
                for (Double optVal : operation) {
                    next.add(optVal);
                    if (mySelfCopiedSolve(next))
                        return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }



    public int count(int[] nums, int k) {
        int cnt = 0;
        for (int n : nums) {
            if (k == n)
                cnt++;
        }
        return cnt;
    }
    // recursive method
    public void permutation(int[] nums, int[] carry, Set<Integer> set, int pos) {
        for (int num : nums) {
            if (!set.contains(num)) {
                carry[pos] = num;
                if (pos == nums.length - 1) {
                    System.out.println(Arrays.toString(carry));
                    return;
                } else {
                    set.add(num);
                    permutation(nums, carry, set, pos + 1);
                    set.remove(num);
                }
            }
        }
    }

    private ArrayList<Integer> getLeft(int[] all, int[] carry, int pos) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : all) {
            list.add(i);
        }
        for (int i = 0; i < pos; i++) {
            list.remove(Integer.valueOf(carry[i]));
        }

        HashSet<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // recursive method
    public void permutationForDuplicatedItems(int[] nums, int[] carry, int pos) {
        ArrayList<Integer> left = getLeft(nums, carry, pos);
        for (int num : left) {
            carry[pos] = num;
            if (pos == nums.length - 1) {
                System.out.println(Arrays.toString(carry));
                return;
            } else {
                permutationForDuplicatedItems(nums, carry, pos + 1);
            }
        }
    }

    public class Data implements Cloneable{
        int val;
        int[] nums;
        int[] carry;
        HashSet<Integer> set;
        int pos;

        public Data(int val, int[] nums, int[] carry, HashSet<Integer> set, int pos) {
            this.val = val;
            this.pos = pos;
            this.set = set;
            this.carry = carry;
            this.nums = nums;
        }

        public Data(Data d) {
            val = d.val;
            pos = d.pos;
            set = new HashSet<>();
            for (int a : d.set) {
                set.add(a);
            }
            carry = new int[d.carry.length];
            for (int i = 0; i < d.carry.length; i++) {
                carry[i] = d.carry[i];
            }
            nums = d.nums;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Data o = (Data) super.clone();
            o.set = (HashSet<Integer>)set.clone();
//            o.carry = carry.clone();
            return o;
        }

    }

    public void permutationByStack(int[] nums) throws CloneNotSupportedException {
        Stack<Data> stack = new Stack<>();
        for (int num : nums) {
            stack.clear();
            int[] carry = new int[nums.length];
            carry[0] = num;
            HashSet<Integer> set = new HashSet<>();
            set.add(num);
            stack.push(new Data(num, nums, carry, set, 0));
            while (!stack.isEmpty()) {
                Data d = stack.pop();
                d.carry[d.pos] = d.val;
                d.set.add(d.val);
                if (d.pos == nums.length - 1) {
                    System.out.println(Arrays.toString(d.carry));
                    continue;
                }
                for (int n : nums) {
                    if (!d.set.contains(n)) {
                        Data next = (Data) d.clone();
                        next.pos = next.pos + 1;
                        next.val = n;
                        stack.push(next);
                    }
                }

            }
        }
    }

    public void test() throws CloneNotSupportedException {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        Data a = new Data(1,new int[]{1,2,3,4}, new int[]{1,0,0,0}, set, 1 );
//        Data b = new Data(a);
        Data b = (Data) a.clone();
        b.set.add(2);
        System.out.println(a.set.hashCode());
        System.out.println(b.set.hashCode());
        System.out.println(a.set.size());
        System.out.println(b.set.size());
        System.out.println(a.carry.hashCode());
        System.out.println(b.carry.hashCode());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
//        new _679_24Game().permutationByStack(new int[]{1,2,3});
//        new _679_24Game().permutation(new int[]{1, 2, 2}, new int[3], new HashSet<>(), 0);
//        new _679_24Game().permutationForDuplicatedItems(new int[]{1, 2, 3}, new int[3], 0);
//        new _679_24Game().test();
//        System.out.println(new _679_24Game().judgePoint24(new int[]{1,2,1,2}));
        Vector<Integer> v = new Vector<>();
        Queue<Integer> queue = new LinkedList<>();
        Integer[] a = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(a);
//        list.add(1);
        list.set(1, 9);
        System.out.println(Arrays.toString(a));
        System.out.println(list.toString());

        ArrayList<Integer> l = new ArrayList<>();

    }

}
