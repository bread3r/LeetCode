class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> HM = new HashSet<> ();
        int max = 0, start = 0;
        for(int end = 0; end < s.length(); ++end){
           while(HM.contains(s.charAt(end))){
               HM.remove(s.charAt(start));
               start++;
           }
           HM.add(s.charAt((end)));
           max = Math.max(max, end - start + 1);
        }
        return max;
    } 
}