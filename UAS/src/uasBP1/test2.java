/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasBP1;

/**
 *
 * @author RAHAYU KARTIKA SARI
 */


import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.util.*;
import java.lang.Math;
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); 
   String username,password;
        System.out.println("Masukkan Username");
        username = scan.nextLine();
        System.out.println("Masukkan Password");
        password = scan.nextLine();
       
        if (username.equals("Cashier1")){
            if (password.equals("minimarket1")){
                cashier();
            } else {
                System.out.println("Password Anda Salah");
            }
        } else {
            if (username.equals("manager1")) {
                if (password.equals("bestmanager")) {
                  Manager();
                } else {
                    System.out.println("Password Anda Salah");
                }
            } else {
                if (username.equals("Owner1")) {
                    if (password.equals("thebestminimarket")) {
                        Owner();
                    } else {
                        System.out.println("Password Anda Salah");
                    }
                } else {
                    System.out.println("Username Anda Salah");
                }
            }
        }
    }
    
    public static void cashier(){
        Scanner scan = new Scanner(System.in);
        String[] sembar = new String[10];
        
        sembar[0] = "jelly";
        sembar[1] = "roti";
        sembar[2] = "mizone";
        sembar[3] = "lays";
        sembar[4] = "Cheetos";
        sembar[5] = "mie";
        sembar[6] = "keju";
        sembar[7] = "tepung";
        sembar[8] = "beras";
        sembar[9] = "ayam";
        int[] qtot = new int[10];
        
        qtot[0] = 1;
        qtot[1] = 2;
        qtot[2] = 3;
        qtot[3] = 4;
        qtot[4] = 5;
        qtot[5] = 6;
        qtot[6] = 7;
        qtot[7] = 8;
        qtot[8] = 9;
        qtot[9] = 10;
        int[] harga = new int[10];
        
        harga[0] = 5000;
        harga[1] = 7000;
        harga[2] = 3000;
        harga[3] = 8000;
        harga[4] = 6000;
        harga[5] = 2500;
        harga[6] = 5000;
        harga[7] = 15000;
        harga[8] = 100000;
        harga[9] = 30000;
        String[] barang = new String[10];
        int[] quantity = new int[10];
        int[] harbar = new int[10];
        int jumbar, counter, y,barlan, total;
        boolean lain, find;
        
        y = 0;
        jumbar = 0;
        lain = false;
        find = false;
        total = 0;
        while (!lain && jumbar <= 9) {
            System.out.println("Nama Barang");
            barang[jumbar] = scan.next();
            System.out.println("Jumlah Barang");
            quantity[jumbar] = scan.nextInt();
            System.out.println("Apakah ada barang lain");
            barlan = scan.nextInt();
            if (barlan==10) {
            } else {
                lain = true;
                jumbar = jumbar + 1;
            }
        }
        for (counter = 0; counter <= jumbar - 1; counter++) {
            while (!find || y < jumbar - 1) {
                if (barang[counter].equals(sembar[y])) {
                    find = true;
                    qtot[y] = qtot[y] + quantity[counter];
                    harbar[counter] = quantity[counter] * harga[y];
                } else {
                    y = y + 1;
                }
            }
        }
        for (counter = 0; counter <= jumbar - 1; counter++) {
            total = total + harbar[counter];
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        System.out.println(dtf.format(now));  
        for (counter = 0; counter <= jumbar - 1; counter++) {
            System.out.print(Integer.toString(counter + 1));
            System.out.print("/u0009"+barang[counter]);
            System.out.print("/u0009"+Integer.toString(quantity[counter]));
            System.out.println("/u0009"+harbar[counter]);
        }
        System.out.println("Total Harga Belanjaan : " + total);
    }
    public static void Manager(){

        Scanner scan = new Scanner(System.in);
        String[] sembar = new String[10];
        
        sembar[0] = "jelly";
        sembar[1] = "roti";
        sembar[2] = "mizone";
        sembar[3] = "lays";
        sembar[4] = "Cheetos";
        sembar[5] = "mie";
        sembar[6] = "keju";
        sembar[7] = "tepung";
        sembar[8] = "beras";
        sembar[9] = "ayam";
        int[] qtot = new int[10];
        
        qtot[0] = 1;
        qtot[1] = 2;
        qtot[2] = 3;
        qtot[3] = 4;
        qtot[4] = 5;
        qtot[5] = 6;
        qtot[6] = 7;
        qtot[7] = 8;
        qtot[8] = 9;
        qtot[9] = 10;
        int[] harga = new int[10];
        
        harga[0] = 5000;
        harga[1] = 7000;
        harga[2] = 3000;
        harga[3] = 8000;
        harga[4] = 6000;
        harga[5] = 2500;
        harga[6] = 5000;
        harga[7] = 15000;
        harga[8] = 100000;
        harga[9] = 30000;
        int counter, choice, pjumlah, y, choice2;
        String cbarang, gbarang;
        boolean find;
        
        y = 0;
        for (counter = 0; counter <= 9; counter++) {
            System.out.println(sembar[counter] + " ");
            System.out.print(qtot[counter] + " ");
            System.out.print(harga[counter] + " ");
            System.out.println("");
        }
        System.out.println("Mengubah data?");
        System.out.println("1. Menambah");
        System.out.println("2. Mengubah");
        System.out.println("3. Menghapus");
        choice = scan.nextInt();
        //pertambahan dan pengurangan kuantitas barang
        if (choice == 1) {
            System.out.println("Masukkan Barang yang Akan Ditambah/Dikurang");
            cbarang = scan.next();
            System.out.println("Berapa Jumlah Yang Akan Ditambah/Dikurang?");
            pjumlah = scan.nextInt();
            find = false;
            while (find == false && y < 10) {
                if (sembar[y].equals(cbarang)) {
                    qtot[y] = qtot[y] + pjumlah;
                    find = true;
                } else {
                    y = y + 1;
                }
            }
        } else {
            //perubahan barang
            if (choice == 2) {
                System.out.println("Apa Yang Akan Diubah");
                System.out.println("1. Barang");
                System.out.println("2. Harga");
                choice2 = scan.nextInt();
                //perubahan barang
                if (choice2 == 1) {
                    System.out.println("Masukkan Barang yang Akan Diubah");
                    cbarang = scan.next();
                    System.out.println("Akan Diganti Dengan Barang Apa?");
                    gbarang = scan.next();
                    find = false;
                    while (find == false && y < 10) {
                        if (sembar[y].equals(cbarang)) {
                            sembar[y] = gbarang;
                            qtot[y] = 0;
                            find = true;
                        } else {
                            y = y + 1;
                        }
                    }
                } else {
                    //perubahan harga
                    if (choice2 == 2) {
                        System.out.println("Masukkan Barang yang Akan Diubah Harganya");
                        cbarang = scan.next();
                        System.out.println("Harga Akan Diubah Menjadi Berapa?");
                        pjumlah = scan.nextInt();
                        find = false;
                        while (find == false && y < 10) {
                            if (sembar[y].equals(cbarang)) {
                                harga[y] = pjumlah;
                                find = true;
                            } else {
                                y = y + 1;
                            }
                        }
                    } else {
                        System.out.println("Pilihan Tidak Ditemukan");
                    }
                }
            } else {
                //penghapusan barang
                if (choice == 3) {
                    System.out.println("Barang Apa Yang Akan Dihapus?");
                    cbarang = scan.next();
                    find = false;
                    while (find == false && y < 10) {
                        if (sembar[y].equals(cbarang)) {
                            sembar[y] = "";
                            qtot[y] = 0;
                            harga[y] = 0;
                            find = true;
                        } else {
                            y = y + 1;
                        }
                    }
                    while (y > 9) {
                        sembar[y] = sembar[y + 1];
                        qtot[y] = qtot[y + 1];
                        harga[y] = harga[y + 1];
                        y = y + 1;
                    }
                    sembar[9] = "";
                    qtot[9] = 0;
                    harga[9] = 0;
                } else {
                    System.out.println("Pilihan Tidak Ditemukan");
                }
            }
        }
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(sembar[counter] + " ");
            System.out.print(qtot[counter] + " ");
            System.out.print(harga[counter] + " ");
            System.out.println("");
        }
    }
    public static void Owner () {
        
        Scanner scan = new Scanner(System.in);
        int[] senin     = {5,1,6,3,7,2,5,8,4,3};
        int[] selasa    = {6,3,6,8,2,6,2,5,8,1};
        int[] rabu      = {7,5,3,4,1,6,8,3,4,6};
        int[] kamis     = {1,7,4,7,3,4,8,3,2,4};
        int[] jumat     = {5,2,4,6,8,4,2,3,1,5};
        int[] sabtu     = {5,1,3,4,8,9,6,4,2,3};
        int[] minggu    = {7,8,2,3,1,5,7,8,9,2};
       
        String[] barang = new String[10];
        
        barang[0] = "jelly";
        barang[1] = "roti";
        barang[2] = "mizone";
        barang[3] = "lays";
        barang[4] = "cheetos";
        barang[5] = "mie";
        barang[6] = "keju";
        barang[7] = "tepung";
        barang[8] = "beras";
        barang[9] = "ayam";
        int[] harga = new int[10];
        
        harga[0] = 5000;
        harga[1] = 7000;
        harga[2] = 3000;
        harga[3] = 8000;
        harga[4] = 6000;
        harga[5] = 2500;
        harga[6] = 5000;
        harga[7] = 15000;
        harga[8] = 100000;
        harga[9] = 30000;
        int[] qtotal = new int[10];
        int[] sort = new int[10];
        String[] top = new String[5];
        boolean find;
        
        find = false;
        int y, counter, x, tempt;
        
        y = 0;
        for (counter = 0; counter <= 9; counter++) {
            System.out.println("Kolom " + (counter + 1) + " = " + barang[counter]);
        }
        System.out.println(" ");
        System.out.println("Hasil Penjualan Minggu Ini Adalah :");
        System.out.println("Senin");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(senin[counter] + " ");
        }
        System.out.println("");
        System.out.println("Selasa");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(selasa[counter] + " ");
        }
        System.out.println("");
        System.out.println("Rabu");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(rabu[counter] + " ");
        }
        System.out.println("");
        System.out.println("Kamis");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(kamis[counter] + " ");
        }
        System.out.println("");
        System.out.println("Jumat");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(jumat[counter] + " ");
        }
        System.out.println("");
        System.out.println("Sabtu");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(sabtu[counter] + " ");
        }
        System.out.println("");
        System.out.println("Minggu");
        for (counter = 0; counter <= 9; counter++) {
            System.out.print(minggu[counter] + " ");
        }
        System.out.println(" ");
        System.out.println(" ");
        for (counter = 0; counter <= 9; counter++) {
            qtotal[counter] = (int) (senin[counter] + selasa[counter] + rabu[counter] + kamis[counter] + jumat[counter] + sabtu[counter] + minggu[counter]);
            sort[counter] = (int) (senin[counter] + selasa[counter] + rabu[counter] + kamis[counter] + jumat[counter] + sabtu[counter] + minggu[counter]);
        }
        for (counter = 0; counter <= 9; counter++) {
            System.out.println("Total uang yang didapatkan dari " + barang[counter] + " sebanyak Rp." + qtotal[counter] * harga[counter]);
        }
        System.out.println(" ");
        for (counter = 0; counter <= 9; counter++) {
            for (x = 0; x <= 8; x++) {
                if (sort[x] > sort[x + 1]) {
                    tempt = sort[x];
                    sort[x] = sort[x + 1];
                    sort[x + 1] = tempt;
                }
            }
        }
        for (counter = 0; counter <= 4; counter++) {
            while (!find) {
                if (sort[counter] == qtotal[y]) {
                    top[counter] = barang[y];
                    find = true;
                    System.out.println("Top Nomor " + (counter + 1) + " adalah " + top[counter] + " dengan total " + sort[counter]);
                } else {
                    y = y + 1;
                }
            }
            find = false;
            y = 0;
        }
    }
}