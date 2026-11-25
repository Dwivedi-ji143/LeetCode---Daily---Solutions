class Solution {
    int[] nums;
    int base = 19;
    long modulo = 1_000_000_007L;
    long[] powers;
    HashMap<Long, Integer> hashValues = new HashMap<>();

    public int smallestUniqueSubarray(int[] nums) {
        this.nums = nums;
        powers = new long[nums.length + 1];

        int minPossibleLen = nums.length;
        int minLen = 1, maxLen = nums.length;

        while (minLen <= maxLen) {
            int midLen = (minLen + maxLen) / 2;

            if (checkUniqueness(midLen)) {
                minPossibleLen = Math.min(minPossibleLen, midLen);
                maxLen = midLen - 1;
            } else {
                minLen = midLen + 1;
            }
        }

        return minPossibleLen;
    }

    private boolean checkUniqueness(int subarrayLen) {
        powers[0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            powers[i] = (powers[i - 1] * base) % modulo;
        }

        long currentHash = 0;

        for (int i = 0; i < subarrayLen; i++) {
            currentHash = (currentHash * base + nums[i]) % modulo;
        }

        hashValues.clear();
        hashValues.put(currentHash, 1);

        for (int i = 1; i <= nums.length - subarrayLen; i++) {
            currentHash -= powers[subarrayLen - 1] * nums[i - 1];
            currentHash = (currentHash * base + nums[i + subarrayLen - 1]) % modulo;
            currentHash = (currentHash + modulo) % modulo;

            hashValues.put(currentHash, hashValues.getOrDefault(currentHash, 0) + 1);
        }

        return hashValues.containsValue(1);
    }
}