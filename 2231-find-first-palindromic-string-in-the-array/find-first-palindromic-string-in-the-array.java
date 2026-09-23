class Solution {
    public String firstPalindrome(String[] words) {
        int n=words.length;
        boolean op = false;
        for(int i=0;i<n;i++){
            int j=words[i].length()-1;
            int k=0;
            if(j==0){
                return words[i];
            }
            while(k<j){
                if(words[i].charAt(k)==words[i].charAt(j)){
                    k++;
                    j--;
                    op=true;
                }
                else{
                    op=false;
                    break;
                }
            }
            if(op){
                return words[i];
            }
        }
        return "";
    }
}