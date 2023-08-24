package palidrom;

import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static void main(String[] args) {
        Stack s = new Stack(99);
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_YELLOW+"PENGECEK PALIDROM"+ANSI_RESET);
        System.out.print("Input Kata =  ");
        String kata = sc.next();
        for(int i=0; i<kata.length();i++){
            s.push(kata.charAt(i));
        }
        String reverse="";
        while(!s.isEmpty()){
            reverse=reverse+s.pop();
        }
        String hasil="";
        if(kata.equals(reverse)){
            hasil="Palindrome";
        }
        else{
            hasil="Bukan Palindrome";
        }
        System.out.println(ANSI_CYAN+hasil+ANSI_RESET);
    }
}
