class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int c = 0;
        boolean[] allowedChars = new boolean[26];
        for(char ch : allowed.toCharArray()){
            allowedChars[ch - 'a'] = true;
        }
        for(String s: words){
            boolean valid = true;
            for(char ch : s.toCharArray()){
                if(!allowedChars[ch - 'a']){
                    valid = false;
                    break;
                }
            }
            if(valid){
                    c++;
            }
            
        }
        return c;
        
    }
}