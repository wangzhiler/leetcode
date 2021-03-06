package leetcodeJava;

/*
Solution:
boolean dp[i][j] 的含义是s[0-i]与p[0-j]是否匹配
dp[0][0]=true

1. p.charAt(j)==s.charAt(i) ->  dp[i][j]=dp[i-1][j-1]
    当前字母一样，则状态与前一位判断的相同
    eg. "aa", "aa"
2. if p.charAt(j)=='.' ->  dp[i][j]=dp[i-1][j-1]
    若为. 则不需要判断s的字符
    eg. "aa", "a."
3. if p.charAt(j)=='*'
        1) if p.charAt(j-1) != s.charAt(i)
            -> dp[i][j] = dp[i][j-2]  //a* counts as empty a
            eg. "aab","c*aab"  c*=empty
        2) if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.'
            -> dp[i][j] = dp[i][j-1]
                eg. "aa","a*"
            -> dp[i][j] = dp[i-1][j]  //a* counts as multiple a
            -> dp[i][j] = dp[i][j-2]  //a* counts as empty a
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if(s==null || p==null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            //       012   01234
            //预处理 "aab","c*aab"
            //手动给dp[0][2]赋值true
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    // a* counts as empty a
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] =
                                (dp[i + 1][j])   //a* counts as single a
                             || (dp[i][j + 1])   //a* counts as multiple a
                             || (dp[i + 1][j - 1]);  //a* counts as empty a
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

}







