package leetcode.zuo.day5.checkPrevious;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author JJChen
 * @version 1.0
 */
public class ceshi {
    public static void main(String[] args) {
        String a = "";
        StringBuffer stringBuffer = new StringBuffer();

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        characterIntegerHashMap.put('c', 2);
        characterIntegerHashMap.put('d',5);
        ArrayList<Character> characters = new ArrayList<>(characterIntegerHashMap.keySet());
        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return -characterIntegerHashMap.get(o1) + characterIntegerHashMap.get(o2);
            }
        });
        System.out.println(characters);

    }
}
