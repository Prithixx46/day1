class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] two = new boolean[2048];
        boolean[] three = new boolean[2048];

        int n = nums.length;

        // XOR of every pair (i <= j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                two[nums[i] ^ nums[j]] = true;
            }
        }

        // XOR of pair result with every element
        for (int x = 0; x < 2048; x++) {
            if (two[x]) {
                for (int num : nums) {
                    three[x ^ num] = true;
                }
            }
        }

        int count = 0;
        for (boolean b : three) {
            if (b) count++;
        }

        return count;
    }
}