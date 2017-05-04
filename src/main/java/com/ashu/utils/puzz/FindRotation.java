package com.ashu.utils.puzz;

import java.util.Arrays;

/**
 * Created by mishra.ashish@icloud.com
 */
public class FindRotation {

    private static String[] words = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "zootopia",
            "asymptote",
            "babka",
            "banoffee",
            "engender",
            "karoatka",
            "othelloladkage"
    };


    private static String[] words1 = new String[]{
            "ptolemaic",
            "retrograde",
            "supplant",
            "undulate",
            "xenoepist",
            "arotationpoint",
            "babka",
            "banoffee",
            "cracouzvah",
            "engender",
            "inalsa",
            "karoatka",
            "monamour",
            "nebraskalization",
            "nuttah",
            "othelloladkage"
    };

    private static int getRotationPoint(String[] arrayOfWords) {

        int start = 0;
        int end = arrayOfWords.length-1;

        while(start <= end) {

            Character st = arrayOfWords[start].charAt(0);
            int mid = (start + end) / 2;

            Character mi = arrayOfWords[mid].charAt(0);

            if (mi.charValue()  == st.charValue() ) {
                return mid;
            }
            else if (mi.charValue() > arrayOfWords[0].charAt(0)) {
                start = mid ;
            } else {
                end = mid ;
            }
        }
        return start;
    }





    public static void main(String[] args) {
        System.out.println("\n rotation point in " + Arrays.asList(words) +  " is : "  + words[getRotationPoint(words) + 1]);
        System.out.println("\n rotation point: in " + Arrays.asList(words1) +  " is : "  + words1[getRotationPoint(words1) + 1]);

        String[] chars = new String[]{ "k","v","a","b","c","d","e","g","i" };
        System.out.println("\n rotation point in " + Arrays.asList(chars) +  " is : " + chars[getRotationPoint(chars) + 1]);

    }
}

