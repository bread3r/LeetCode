class Solution {
   public String longestPalindrome(String s) {
        int maxLength = 0, resSt = 0, resEn = 0;
        int n = s.length();
        int[][] F = new int[n+1][n+1];
        //Length = 1
        for (int i = 0; i < n; ++i) {
            F[i][i] = 1;
        }
        //Length = 2;
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if (maxLength < 2) {
                    maxLength = 2;
                    resSt = i;
                    resEn = i + 1;
                }
                F[i][i + 1] = 1;
            } else {
                F[i][i + 1] = 0;
            }
        }
        //Length > 2
        for (int length = 3; length <= n; ++length) {
            for (int start = 0; start+length-1 < n; ++start) {
                //System.out.println(start + " " + (start+length-1));
                if (F[start + 1][start + length - 2] == 1 && s.charAt(start) == s.charAt(start + length-1)) {
                    if (maxLength < length) {
                        maxLength = length;
                        resSt = start;
                        resEn = start + length-1;
                    }
                    F[start][start + length-1] = 1;
                }
            }
        }
//        for(int i = 0 ; i <n ; ++i){
//            for(int j = 0 ; j < n ;++j)
//                System.out.print(F[i][j]);
//            System.out.println();
//        }
//        System.out.println(resSt + " "+ resEn);
        return s.substring(resSt, resEn+1);
    }
    
}