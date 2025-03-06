class Solution {
    public static boolean checkInt(char a) {
        if (a >= 48 && a <= 57) {
            return true;
        }
        return false;
    }

    public static int myAtoi(String x) {
        
        int MAX = 2147483647;

        String rs = "";
        String s = x.trim();
        if (s.isEmpty())
            return 0;
        boolean check1 = true, check2 = true;
        char first = '@';
        double lastRs = 0;

        // int pos = 1, cur = 0;

        // while (check1 == true) { // Kiem tra xem so am hay duong
        // char fc = s.charAt(cur);
        // if (fc == '-')
        // pos *= -1;
        // else if (fc == '+')
        // pos *= 1;
        // else {
        // check1 = false;
        // cur--;
        // }
        // cur++;
        // }

        int pos = 1, cur = 1;
        if (s.charAt(0) == '-')
            pos = -1;
        else if (s.charAt(0) == '+')
            pos = 1;
        else if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
            pos = 1;
            cur = 0;
        } else
            pos = 0;
        if (s.length() > 1)
            if ((s.charAt(1) < 48 || s.charAt(1) > 57) && pos == -1)
                pos = 0;
        if (pos == 0)
            return 0;

        s = s.substring(cur);

        for (int i = 0; i < s.length() && check2; i++) { // Kiem tra xau vua lay dau
            char checked = s.charAt(i); // co phai la xau hop phap
            if (!checkInt(checked)) {//
                check2 = false;
            } else {
                rs += checked;
                if (checked >= 48 && checked <= 57 && i + 1 < s.length()) {
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next < 48 || next > 57) {// check ki tu tiep theo cua so
                            check2 = false; // co phai la so nua khong,
                        } // neu khong thi dung vong lap
                    }
                }
            }
        }
        if (!rs.isEmpty())
            return Double.parseDouble(rs) > (double) MAX
                    ? pos == 1 ? MAX : -MAX - 1
                    : Integer.parseInt(rs) * pos;
        return 0;
    }
}
