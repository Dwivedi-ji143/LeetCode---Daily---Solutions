class Solution {
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        StringBuilder sb = new StringBuilder();

        for (String part : parts) {
            if (sb.length() > 0) sb.append("-");
            sb.append(Integer.toBinaryString(Integer.parseInt(part)));
        }

        return sb.toString();
    }
}