/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uasBP1;

/**
 *
 * @author RAHAYU KARTIKA SARI
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class test {
    //data test
    static String[] data_barang = {"gantungan", "strap", "liontin", "boneka", "plushies", "slime", "keycharm", "bandul"};
    static String[] data_barcode={"0001", "0002", "0003", "0004", "0005", "0006", "0007", "0008"};
    static int[] data_harga = {12500, 12600, 13000, 18000, 15000, 16000, 21000, 9900};
    static int[] indeks_penjualan = new int [data_barang.length];
    static String[] data_penjualan = {""};
    static String[] tanggal_penjualan = {""};
    
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("RAHAYU MERCHANTDISE SHOP'S SYSTEM");
        System.out.println("Selamat datang, semoga harimu menyenangkan!!");
        role();
        
    }
    
    static void role(){
        System.out.println("Anda adalah seorang... \n1. Kasir\n2. Admin\n3. Owner\n99. Keluar");
        System.out.print("Jawab: ");
        int role = input.nextInt();
        switch (role){
            case 1 ->{
                kasir();
            }
            case 2 ->{
                role();
            }
            case 3 ->{
                owner();
            }
            case 99 ->{
                System.out.println("Terimakasih, telah menggunakan aplikasi");
                break;
            }
        }
        System.out.println();
    }
    
    public static void kasir(){
        System.out.println("SELAMAT DATANG KASIR!");
        System.out.println();
        int tetap;
        do{
        //transaksi (pilih dan cari)
        int tambah, total=0, jumlah, harga, indeks;
        String barcode;
        
        //tanggal transaksi
        System.out.println("Tanggal: (dd/mm/yyyy)");
        String tanggal= input.next();
        //add tanggal
        List<String> newdata_tanggal = new ArrayList<>(Arrays.asList(tanggal_penjualan));
        newdata_tanggal.add(tanggal);
        tanggal_penjualan = newdata_tanggal.toArray(tanggal_penjualan);
        String penjualan = "";  
        
        do{ 
            do{
            //cari harga bds barcode
            System.out.print("Masukkan barcode \n=>");
            barcode=input.next();
            indeks=cariBarcode(barcode);
                //jika barang tidak ada
                if(indeks<0){
                    System.out.println("Maaf barang tidak ada dalam data, mohon hubungi admin");
                    break;
                }
            //harga
            harga = data_harga[indeks];
            System.out.println("Barang: "+data_barang[indeks]+"\nHarga: "+data_harga[indeks]);
            //jumlah
            System.out.print("Jumlah: ");
            jumlah=input.nextInt();
            //harga
            harga= data_harga[indeks]*jumlah;
            System.out.println("Total harga barang: "+harga);
            
            //total harga
            total = total+harga;
            System.out.println("Total: "+total);
            
            //data penjualan
            indeks_penjualan[indeks]=indeks_penjualan[indeks]+jumlah;
            penjualan=penjualan+data_barang[indeks]+" "+jumlah+"\n";
            
            indeks = -1;
            }while (indeks>=0);
            
            System.out.print("Tambah barang? (1/0)");
            tambah= input.nextInt();
        }while (tambah>0);
        
        //output harga
        System.out.println("Total harga: " + total);
        
        //diskon
        System.out.println("Diskon: ");
        int diskon = input.nextInt();
        if(diskon<=1){
            diskon = total*diskon;
        }
        total = total - diskon;
        
        //bayar akhir
        System.out.println("Total bayar: " + total);
        
        //add data penjualan
        List<String> newdata_penjualan = new ArrayList<>(Arrays.asList(data_penjualan));
        newdata_penjualan.add(penjualan);
        data_penjualan = newdata_penjualan.toArray(data_penjualan);
        
        //log out/tetap
        System.out.println("Apakah anda ingin tetap di mode kasir?(1/0)");
        System.out.print("Jawab: ");
        tetap = input.nextInt();
        }while(tetap !=0);
            
        System.out.println("Terimakasih telah menjadi kasir");
        System.out.println();
        role();
        
    }
    
    public static void owner(){
        System.out.println("Hallo! Owner");
        System.out.println("LAPORAN RAHAYU MERCHANDISE SHOP");
        int tetap;
        do{
            // data penjualan
            for(int i =0; i<data_barang.length; i++){
                System.out.println(data_barang[i]+" terjual: "+indeks_penjualan[i]); 
            }
            System.out.println();
        
            // 5 barang paling laris
            String[] barang = Arrays.copyOf(data_barang,data_barang.length);
            int[] penjualan = Arrays.copyOf(indeks_penjualan,indeks_penjualan.length);
            
            terlaris(barang, penjualan);
            System.out.println("5 BARANG TERLARIS: ");
            for (int i=0; i<5; i++){
                System.out.println((i+1)+". "+barang[i]+" terjual: "+penjualan[i]);
            }
            
            // daftar harian dalam satu pekan
            System.out.println("PENJUALAN SEPEKAN");
            if (data_penjualan.length>7){
                for(int i=data_penjualan.length-1; i>data_penjualan.length-7; i--){
                    System.out.println(tanggal_penjualan[i]+data_penjualan[i]);
                }
            }
            else if (data_penjualan.length<7){
                for(int i=data_penjualan.length-1; i>-1; i--){
                    System.out.println(tanggal_penjualan[i]+data_penjualan[i]);
                }
            }
            
            //log out/tetap
            System.out.println("Apakah anda ingin tetap di mode admin?(1/0)");
            System.out.print("Jawab: ");
            tetap = input.nextInt();

        }while (tetap!=0);
        
        System.out.println("Terimakasih telah menjadi admin");
        System.out.println();
        role();
    }
    
    
    static int cariBarcode(String x){
        int idx = -1;
        boolean ada = false;
        
        for (int i = 0; i<data_barcode.length; i++){
                if(data_barcode[i].equals(x)){
                idx = i;
                ada = true;
                break;
                }
        }
        return idx;
    }
   
    static void terlaris(String[] barang, int[] penjualan){
        int temp, max_idx;
        String stemp;
        for (int i=0; i<barang.length-1; i++){
            max_idx=i;
            for(int j=i; j<barang.length; j++){
                if (penjualan[max_idx]<penjualan[j]){
                    max_idx = j;
                }
                if(max_idx != i){
                    stemp = barang[max_idx];
                    barang[max_idx]=barang[i];
                    barang[i]=stemp;
                    
                    temp = penjualan[max_idx];
                    penjualan[max_idx]=penjualan[i];
                    penjualan[i]=temp;
                }
            }
        }
    }
    
}
