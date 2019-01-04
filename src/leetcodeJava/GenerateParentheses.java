package leetcodeJava;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
    Given n pairs of parentheses, write a function
    to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]

     */


    // back tracking
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        helper(res, "", n, n);
        return res;
    }

    /*
        n=3
        helper(null,"",3,3)
            helper(null,"(",2,3)
                helper(null,"((",1,3)
                    helper(null,"(((",0,3)
                        helper(res,"((()",0,2)
                            helper(res,"((())",0,1)
                                helper(res,"((()))",0,0)
                                    res.add("((()))")
                    helper(null,"(()",1,2)
                        helper(null,"(()(",0,2)
                            helper(res,"(()()",0,1)
                                helper(res,"(()())",0,0)
                                    res.add("(()())")
                        helper(null,"(())",1,1)
                            helper(res,"(())(",0,1)
                                helper(res,"(())()",0,0)
                                    res.add("(())()")
                helper(null,"()",2,2)
                    helper(null,"()(",1,2)
                        helper(null,"()((",0,2)
                            helper(null,"()(()",0,1)
                                helper(null,"()(())",0,0)
                                    res.add("()(())")
                        helper(null,"()()",1,1)
                            helper(null,"()()(",0,1)
                                    res.add("()()()")

            helper(null,")",3,2)
                return;

     */

    private void helper(List<String> res, String s, int left, int right) {
        /*
            5 pairs
            left:3
            right:2
            (()))
         */
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }

    }
}
