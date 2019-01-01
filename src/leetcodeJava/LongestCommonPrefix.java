package leetcodeJava;

public class LongestCommonPrefix {
    /**
     * 以第一个为基准比较
     * 【indexOf】
     case: "edwardshi", "edward", "edwar", "edwardshidd"
     res=edwardshi -> i=1, 在edward中找res 找不到
     res=edwardsh
     res=edwards
     res=edward -> edward中找到了且为0， i=2, 在edwar中找res
     res=edwar -> i=3
     res=edwar

     time:O(n)
     space:O(1)

     *
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res)!=0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

}
