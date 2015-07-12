package com.kshuran.palindrom;

/**
 *
 * @author Кулацкий
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome(args[0]);
        int k = palindrome.showPalindrom();
        System.out.println("For number " + args[0] + " nearest larger palindrom is " + k);
        
    }
    
}
