package com.kshuran.palindrom;

import java.util.ArrayList;

/**
 *
 * @author Кулацкий
 */
public class Palindrome {

    private int number, size, middle;
    private ArrayList<Integer> list;

    public Palindrome(String s) {
        number = Integer.parseInt(s);
    }

    //dissasemble number on digits and put each digit into array
    private void breakNumber() {
        int a = number;
        list = new ArrayList<>();
        while (a != 0) {
            list.add(a % 10);
            a /= 10;
        }
        size = list.size();
        middle = size / 2;
    }
    
    //plus one to digit in the number
    private void addOneToNumber() {
        int v = 1;
        for (int j = 0; (middle + j) < size; j++) {
            if (list.get(middle + j) == 9) {
                list.set(middle + j, 0);
            } else {
                list.set(middle + j, (list.get(middle + j) + v));
                break;
            }
        }
    }

    //compare digits in even number of digits
    private void compareDigitsInEvenNumber() {
        M1:
        {
            for (int a = 0; a < middle; a++) {
                switch (list.get(middle + a).compareTo(list.get(middle - a - 1))) {
                    case -1:
                        addOneToNumber();
                        break M1;
                    case 0: ;
                        break;
                    case 1: ;
                        break M1;
                }
            }

        }
    }

    //compare digits in odd number of digits
    private void compareDigitsInOddNumber() {
        M2:
        {
            for (int a = 1; a <= middle; a++) {
                switch (list.get(middle + a).compareTo(list.get(middle - a))) {
                    case -1:
                        addOneToNumber();
                        break M2;
                    case 0: ;
                        break;
                    case 1: ;
                        break M2;
                }
            }

        }
    }

    //find palindrom for provided number
    private int findPalindrom() {
        String s = "";
        breakNumber();
        if (0 == (size % 2)) {
            compareDigitsInEvenNumber();
            for (int i = 1; i < (middle + 1); i++) {
                s += list.get(size - i);
            }
            for (int i = 0; i + middle < size; i++) {
                s += list.get(i + middle);
            }
        } else {
            compareDigitsInOddNumber();
            for (int i = 1; i < (middle + 2); i++) {
                s += list.get(size - i);
            }
            for (int i = 1; i + middle < size; i++) {
                s += list.get(i + middle);
            }
        }
        return Integer.parseInt(s);
    }

    //if provided number is palindrom the program find other nearest larger palindrom
    public int showPalindrom() {
        int k = findPalindrom();
        if (Integer.compare(k, number) == 0) {
            number += 1;
            return findPalindrom();
        }
        return k;
    }

}
