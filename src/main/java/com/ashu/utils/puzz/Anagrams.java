package com.ashu.utils.puzz;

import java.util.*;

/**
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams
 * of each other if the first string's letters can be rearranged to form the second string. In other words, both strings
 * must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams,
 * but bacdc and dcbad are not.

 Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number
 of character deletions required to make the two strings anagrams. Can you help her find this number?

 Given two strings,  and , that may or may not be of the same length, determine the minimum number of character
 deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

 *Input Format
 * The first line contains a single string, .
 * The second line contains a single string, .

 * Constraints
 * It is guaranteed that  and  consist of lowercase English alphabetic letters (i.e.,  through ).

 * Output Format
 * Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

 * Sample Input
 * cde
 * abc

 * Sample Output
 * 4

 * Explanation
 * We delete the following characters from our two strings to turn them into anagrams of each other:

 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 * We must delete  characters to make both strings anagrams, so we print  on a new line.
 *
 */
public class Anagrams {

    static int count = 0;

    /**
     * This is what I tried using my dumb mind ..
     * @param first
     * @param second
     * @return
     */
    public static int numberNeeded(String first, String second) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < first.length(); i ++) {
            set.add(first.charAt(i));
        }
        for (int i = 0; i < second.length(); i ++) {
            set.add(second.charAt(i));
        }

        Iterator<Character> i = set.iterator();

        System.out.println(set.toString());

        while(i.hasNext()) {
            char character = i.next().charValue();

            if ( first.indexOf(character) == -1) {
                System.out.println("if " + character + " exists in " + first);
                count++;
            }

            if ( second.indexOf(character) == -1 ) {
                System.out.println("if " + character + " exists in " + second);
                count++;
            }
        }

        return count;

    }


    /**
     * This is what I found when I wasn't unable to use my dumb mind ..
     * @param first
     * @param second
     * @return
     */
    public static int notMySolution( String first, String second) {

        int[] lettercounts = new int[26];
        for(char c : first.toCharArray()){
            lettercounts[c-'a']++;
        }
        for(char c : second.toCharArray()){
            lettercounts[c-'a']--;
        }

        for (int c: lettercounts) {
            System.out.print(c + " ");
        }
        int result = 0;
        for(int i : lettercounts){
            result += Math.abs(i);
        }
        return result;
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        //System.out.println(" " + numberNeeded(a, b));

        System.out.println(" " + notMySolution(a, b));
    }
}
