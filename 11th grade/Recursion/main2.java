public class Main {
        public static int prefixSum(int[] nums, int limit) {
            return prefixSum(nums, limit, 0);
        }

        public static int prefixSum(int[] nums, int limit, int pos) {
            if (pos == limit)
                return 0;
            return nums[pos] + prefixSum(nums, limit, pos + 1);
        }

        public static int suffixSum(int[] nums, int limit) {
            return suffixSum(nums, limit, nums.length - 1);
        }

        public static int suffixSum(int[] nums, int limit, int pos) {
            if (pos < limit)
                return 0;
            return nums[pos] + suffixSum(nums, limit, pos - 1);
        }

        public static int countEven(int[] nums, int limit) {
            return countEven(nums, limit, 0);
        }

        public static int countEven(int[] nums, int limit, int pos) {
            if (pos == limit)
                return 0;
            if (nums[pos] % 2 == 0)
                return 1 + countEven(nums, limit, pos + 1);
            return countEven(nums, limit, pos + 1);
        }


        public static int findIndex(int[] nums, int target) {
            return findIndex(nums, target, 0);
        }

        public static int findIndex(int[] nums, int target, int pos) {
            if (pos == nums.length)
                return -1;
            if (nums[pos] == target)
                return pos;
            return findIndex(nums, target, pos + 1);
        }

        public static void main(String[] args) {
            int[] arr = {2, 4, 6, 0, 4, 10,7};
            System.out.println(prefixSum(arr, 4));
            System.out.println(prefixSum(arr, 0));
            System.out.println(prefixSum(arr, 5));
            System.out.println(suffixSum(arr, 9));
            System.out.println(suffixSum(arr, 4));
            System.out.println(suffixSum(arr, 2));
            System.out.println(countEven(arr, 6));
            System.out.println(countEven(arr, 4));
            System.out.println(countEven(arr, 6));
            System.out.println(countEven(arr, 4));
            System.out.println(findIndex(arr, 1));
            System.out.println(findIndex(arr, 5));
            System.out.println(findIndex(arr, 89));
            System.out.println(findIndex(arr, 1));
        }
}
