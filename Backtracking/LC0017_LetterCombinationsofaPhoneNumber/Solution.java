package Backtracking.LC0017_LetterCombinationsofaPhoneNumber;
import java.util.*;

class Solution {

    List<String> list = new ArrayList<>();

    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return list;
        }

        backtrack(digits, 0, "");

        return list;
    }

    void backtrack(String digits, int index, String current) {

        if (index == digits.length()) {
            list.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            backtrack(
                digits,
                index + 1,
                current + letters.charAt(i)
            );
        }
    }
}