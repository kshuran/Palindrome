package com.kshuran.palindrom;

/**
 *
 * @author Кулацкий
 */
public class Palindrome {

    public Palindrome() {
    }

    /*Number (int) convert to string - stringNumber. From stringNumber take 
     *stringInverseNumber using reverse() method. And compare stringNumber and 
     *stringInverseNumber. If they aren't equal - to number(int) add 1. And do 
     *all again.
     */
    public int findPalindrome(String s) {
        int number = Integer.parseInt(s);
        String stringNumber, stringInverseNumber;
        while (true) {
            stringNumber = String.valueOf(++number);
            stringInverseNumber = new StringBuilder(stringNumber).reverse().toString();
            if (stringNumber.equals(stringInverseNumber))
               return number; 
        }        
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();       
        System.out.println(palindrome.findPalindrome(args[0]));
    }
}
