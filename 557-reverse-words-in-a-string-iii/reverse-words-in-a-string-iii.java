class Solution {
    public String reverseWords(String s) {
        String ans ="";
        String arr[]=s.split(" ");
        for (int i=0;i<arr.length;i++){
            int j=arr[i].length()-1;
            while(j>=0){
                ans+=arr[i].charAt(j);
                j--;
            }
            ans+=" ";
        }
        ans=ans.trim();
        return ans;
    }
}