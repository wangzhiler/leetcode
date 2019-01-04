package leetcodeJava;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    /*
    Given a string containing digits from 2-9 inclusive,
    return all possible letter combinations that the number could represent.
    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.

            2 abc    3 def
    4 ghi   5 jkl    6 mno
    7 pqrs  8 tuv    9 wxyz

    Example:
    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */


    public final static String[] phone = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();


        if (digits == null || digits.length() == 0) {
            return resultList;
        }

        // index从0开始, 即digits的第一个数字
        // null,23,"",0
        // temp=phone[2]="abc"
        // next=a ->
            // null,23,"a",1
        letterCombinations(resultList, digits, "", 0);

        return resultList;
    }

    private void letterCombinations(List<String> resultList, String digits,
                                    String currentList, int index) {
        // 最后一层退出条件
        if (index==digits.length()) {
            if (currentList.length()!=0) {
                resultList.add(currentList);
            }
            return;
        }

        // 找到数字对应的字符串
        String temp = phone[digits.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            // 每次把不同字符串加到currentList中
            String next = currentList + temp.charAt(i);
            letterCombinations(resultList, digits, next, index + 1);
        }
    }

}
