class Solution {
    public String convert(String test, int rows) {
        String result = "";
        int n = 2*rows-2;
        if( rows >= 2){
        for(int i = 0; i < test.length(); ++ i)
            if(i%n == 0)
                result += test.charAt(i);
        int mid = n-2;  // so char o giua k tinh dau cuoi
        int at = 1;
            for(int i = 1; i < rows-1; ++i){
//                System.out.println(i);
                boolean end = true;
                for(int col = 0; end ;++col)
                {
                    //System.out.println((i + n*col) + " " + (n+n*col-i));
                    if( i+ col * n < test.length())
                        result += test.charAt(i+col*n);
                    else 
                        end = true;
                    if (n+n*col-i >= 0 && n+n*col-i < test.length())
                        result += test.charAt(n+n*col-i);
                    else 
                        end = false;
                }
            }
            
        for(int i = 0; i < test.length(); ++ i)
            if(i%n == (rows - 1))
                result += test.charAt(i);
        return result;}
        else 
            return test;
    }
}