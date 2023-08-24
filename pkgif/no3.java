/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pkgif;

import java.util.Scanner;

/**
 *
 * @author RAHAYU KARTIKA SARI
 */
public class no3 {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
        System.out.print("Masukkan berat:  ");
        int berat = scan.nextInt();
       
       if(berat>2){
          float regular = berat*8000;
          float express1 = berat*25000;
          float express2 = berat*15000;
          float bc = berat*12000;
          
          System.out.println("Tarif Reguler (2 hari) : 8000/kg = Rp  " + regular);
          System.out.println("Tarif Ekspress (6 hari) : 25000/kg = Rp  " + express1);
          System.out.println("Tarif Ekspress (1 hari) : 15000/kg = Rp  " + express2);
          System.out.println("Tarif BC/Selimut/Sprey : 12000/kg = Rp  " + bc);
       }
       else {
           System.out.println("Berat tidak memenuhi batas minimum 2 kg");
       }
    }
}
