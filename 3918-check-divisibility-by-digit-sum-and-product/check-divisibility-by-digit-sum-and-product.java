class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int k = n;

        while (k > 0) {
            int digit = k % 10;
            sum += digit;
            product *= digit;
            k /= 10;
        }

        return n % (sum + product) == 0;
    }
}