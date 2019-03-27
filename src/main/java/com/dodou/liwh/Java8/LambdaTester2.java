package com.dodou.liwh.Java8;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Finlay
 * @ClassName: LambdaTester2
 * @Description:
 * @date: 2019-03-27 5:01 PM
 */
public class LambdaTester2 {

    static String[] players = {"Rafael Nadal", "Novak Djokovic",
            "Stanislas Wawrinka", "David Ferrer",
            "Roger Federer", "Andy Murray",
            "Tomas Berdych", "Juan Martin Del Potro",
            "Richard Gasquet", "John Isner"};

    public static void main(String[] args) {
        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // 1.2 使用 lambda expression 根据 name 排序 players
        Arrays.sort(players, (s1, s2) -> s1.compareTo(s2));

    }

}
