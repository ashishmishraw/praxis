package com.ashu.utils.puzz;

import java.util.*;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know
 * if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use
 * substrings or concatenation to create the words he needs.

 Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly
 using whole words from the magazine; otherwise, print No.

 Input Format

 The first line contains two space-separated integers describing the respective values of  (the number of words in the magazine) and  (the number of words in the ransom note).
 The second line contains  space-separated strings denoting the words present in the magazine.
 The third line contains  space-separated strings denoting the words present in the ransom note.

 Constraints

    1. 1 <= m, n <= 30,000
    2. 1 <= length of any word <= 5
    3. Each word consists of English alphabetic letters (i.e.,  to  and  to ).
    4. The words in the note and magazine are case-sensitive.


 Output Format

 Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

 Sample Input 1:
 6 4
 give me one grand today night
 give one grand today

 Sample Output 1:
    Yes

 Sample Input 2:
 15 17
 o l x imjaw bee khmla v o v o imjaw l khmla imjaw x
 imjaw l khmla x imjaw o l l o khmla v bee o o imjaw imjaw o


 Sample output 2:
    No

 Explanation

 All four words needed to write an untraceable replica of the ransom note are present in the magazine, so we print Yes as our answer.
 *
 */
public class RansomNoteSolution {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNoteSolution(String magazine, String note) {

        String[] magazineWords = magazine.split("\\s+");
        String[] noteWords = note.split("\\s+");

        magazineMap = new HashMap<>(magazineWords.length);
        noteMap = new HashMap<>(noteWords.length);

        populateMap(magazineMap, magazineWords);
        populateMap(noteMap, noteWords);

    }

    private void populateMap(Map<String, Integer> map, String[] words) {

        for (int i = words.length - 1; i >= 0; i--) {

            if (map.containsKey(words[i])) {
                Integer freq = map.get(words[i]);
                map.put(words[i], ++freq);
            } else {
                map.put(words[i], 1);
            }
        }

    }


    public boolean solve() {

        System.out.println(magazineMap.toString());
        System.out.println(noteMap.toString());
        Iterator<String> iter =  noteMap.keySet().iterator();

        while (iter.hasNext()) {
            String noteWord = iter.next();
            if ( ! magazineMap.containsKey(noteWord))
                return false;
            else {
                int freq = magazineMap.get(noteWord);

                if ( freq < noteMap.get(noteWord))
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNoteSolution s = new RansomNoteSolution(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
