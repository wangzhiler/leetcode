package leetcodeJava;

public class RomantoInteger {
    /**
     13. Roman to Integer
     given an roman numeral, convert it to an integer
     Input is guaranteed to be within the range from 1 to 3999.

     规律：左边的数字如果小于右边的数字 = 右-左  VI=6 IV=4

     time:O(n)
     space:O(1)
     */

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = toNumber(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (toNumber(s.charAt(i)) > toNumber(s.charAt(i - 1))) {
                // *2是因为 eg IV  res=1 -> 读取到IV -> res=1+5-2*1
                res += toNumber(s.charAt(i)) - 2 * toNumber(s.charAt(i - 1));
            } else {
                res += toNumber(s.charAt(i));
            }
        }
        return res;
    }

    public int toNumber(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
                default:
                    return 0;
        }
    }
}
