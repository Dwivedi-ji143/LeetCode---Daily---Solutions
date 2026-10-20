class Solution {
  public int sumOddLengthSubarrays(int[] arr) {
    int ans = 0; 
    int prevEvenSum = 0;  
    int prevOddSum = 0;   
    for (int i = 0; i < arr.length; ++i) {
      int currEvenSum = prevOddSum + ((i + 1) / 2) * arr[i];
      int currOddSum = prevEvenSum + (i / 2 + 1) * arr[i];
      ans += currOddSum;
      prevEvenSum = currEvenSum;
      prevOddSum = currOddSum;
    }

    return ans;
  }
}


