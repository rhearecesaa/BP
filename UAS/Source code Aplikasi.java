
package uasBP1;

/**
 *
 * @author 
 * Nama: RAHAYU KARTIKA SARI
 * NPM : 22082010146
 * 
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class UAS {
    //warna
    public static final String NORMAL = "\u001b[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String BACKGROUND_BLACK = "\u001B[40m";
    public static final String BACKGROUND_RED = "\u001B[41m";
    public static final String BACKGROUND_GREEN = "\u001B[42m";
    public static final String BACKGROUND_YELLOW = "\u001B[43m";
    public static final String BACKGROUND_BLUE = "\u001B[44m";
    public static final String BACKGROUND_MAGENTA = "\u001B[45m";
    public static final String BACKGROUND_CYAN = "\u001B[46m";
    public static final String BACKGROUND_WHITE = "\u001B[47m";

    //data awal
    static String[] data_barang = {"gantungan", "phone-strap", "kalung", "boneka", "plushies", "slime", "keycharm", "gelang"};
    static String[] data_barcode={"0001", "0002", "0003", "0004", "0005", "0006", "0007", "0008"};
    static int[] data_harga = {5000, 6000, 15000, 30000, 45000, 16000, 4000, 5000};
    static int[] indeks_penjualan = {3,5,1,3,0,4,0,2};
    static Scanner input = new Scanner(System.in);
    static String[] data_penjualan = {"\ngantungan 3\nstrap 4","\nboneka 3\nstrap 1","\nbandul 2\nslime 4","\nliontin 1"};
    static String[] tanggal_penjualan = {"19/12/2022", "20/12/2022", "22/12/2022", "23/12/2022"};
    
    public static void main(String[] args) {
        System.out.println(MAGENTA+BACKGROUND_WHITE+"               ALCAZARZARAY SHOP              "+NORMAL);
        System.out.println(WHITE+"Selamat datang, semoga harimu menyenangkan!!"+NORMAL);
        menu();
        
    }
    
    static void menu(){
        System.out.println(WHITE+BACKGROUND_MAGENTA+"Menu... "+NORMAL);
        System.out.println(WHITE+BACKGROUND_BLUE+"1. Kasir\n"+WHITE+"2. Admin\n"+WHITE+"3. Owner\n"+WHITE+BACKGROUND_BLACK+"99. Keluar"+NORMAL);
        System.out.print(CYAN+ "Jawab: "+NORMAL);
        int role = input.nextInt();
        switch (role){
            case 1 ->{
                kasir();
            }
            case 2 ->{
                admin();
            }
            case 3 ->{
                owner();
            }
            case 99 ->{
                System.out.println(WHITE+"Terimakasih telah menggunakan aplikasi!"+NORMAL);
                break;
            }
        }
        System.out.println();
    }
    
    public static void kasir(){
    boolean login = login(1);
    if(login){
        System.out.println(CYAN+"-------SELAMAT DATANG KASIR!-------"+NORMAL);
        System.out.println();
        
        
        
        int tetap;
        do{
            
        //list data, barcode, dan harga    
        System.out.println("-------LIST BARANG YANG DIJUAL-------");
        for(int i=0; i<data_barang.length; i++){
            System.out.println(WHITE+(i+1)+". "+data_barang[i]+"\t | Barcode: "+data_barcode[i]+"\t | harga: "+data_harga[i]+NORMAL);
        }
        System.out.println();
           
        //transaksi
        int tambah, total=0, jumlah, harga, indeks;
        String barcode;
        String penjualan = "";
        
        //tanggal transaksi
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String tanggal = dtf.format(now);
        System.out.println(CYAN+"Tanggal: "+tanggal+NORMAL);
        
        do{ 
            do{
            //cari harga bds barcode
            System.out.print(YELLOW+"Masukkan barcode \n=>"+NORMAL);
            barcode=input.next();
            indeks=cariBarcode(barcode);
                //jika barang tidak ada
                if(indeks<0){
                    System.out.println(MAGENTA+"Maaf barang tidak ada dalam data, cari dengan mode lain?"+NORMAL);
                    int ulang;
                    do{
                            ulang = 0;
                            indeks = cari();
                            if (indeks<0){
                                System.out.println(MAGENTA+"Periksa kembali data"+NORMAL);
                                System.out.print(GREEN+"Ulangi pencarian? (1/0)"+NORMAL);
                                ulang = input.nextInt();
                            }
                        }while(ulang == 1);
                        if (indeks == -1){
                            System.out.println(MAGENTA+"Maaf barang tidak ada dalam data, mohon hubungi admin"+NORMAL);
                            break;
                        }
                }
            //harga
            harga = data_harga[indeks];
            System.out.println(WHITE+"Barang: "+data_barang[indeks]+"\n"+WHITE+"Harga: "+data_harga[indeks]+NORMAL);
            //jumlah
            System.out.print(YELLOW+"Jumlah: "+NORMAL);
            jumlah=input.nextInt();
            if(jumlah>0){
            //harga total
            harga= data_harga[indeks]*jumlah;
            System.out.println(BLUE+BACKGROUND_WHITE+"Total harga barang:          "+harga+NORMAL);
            
            //total harga
            total = total+harga;
            System.out.println(GREEN+"Total:                       "+total+NORMAL);
            
            //data penjualan
            indeks_penjualan[indeks]=indeks_penjualan[indeks]+jumlah;
            penjualan=penjualan+"\n"+data_barang[indeks]+" "+jumlah;
            }
            else{
                System.out.println(MAGENTA+"Masukkan jumlah yang valid"+NORMAL);
            }
            indeks = -1;
            }while (indeks>=0);
            
            System.out.print(WHITE+"Tambah barang yang dibeli? (1/0)"+NORMAL);
            tambah= input.nextInt();
        }while (tambah>0);
        
        //output harga
        System.out.println(GREEN+"Total harga:                   " + total+NORMAL);
        
        //diskon
        System.out.print(WHITE+ "Diskon:                        "+NORMAL);
        int diskon = input.nextInt();
        total = total - diskon;
        
        //bayar akhir
        System.out.println(MAGENTA+BACKGROUND_YELLOW+"Total bayar:                   " + total+NORMAL);
        
        //cek tanggal
        if (tanggal_penjualan[tanggal_penjualan.length-1].equals(tanggal)){
            data_penjualan[data_penjualan.length-1] = data_penjualan[data_penjualan.length-1] + penjualan;
        }
        else{
            //add tanggal
            List<String> newdata_tanggal = new ArrayList<>(Arrays.asList(tanggal_penjualan));
            newdata_tanggal.add(tanggal);
            tanggal_penjualan = newdata_tanggal.toArray(tanggal_penjualan);
        
            //add data penjualan
            List<String> newdata_penjualan = new ArrayList<>(Arrays.asList(data_penjualan));
            newdata_penjualan.add(penjualan);
            data_penjualan = newdata_penjualan.toArray(data_penjualan);
        }
        
        //log out/tetap
        System.out.println(WHITE+"Apakah anda ingin tetap di mode kasir?(1/0)"+NORMAL);
        System.out.print(CYAN+"Jawab: "+NORMAL);
        tetap = input.nextInt();
        }while(tetap !=0);
            
        System.out.println(YELLOW+"---------Terimakasih telah menjadi kasir---------"+NORMAL);
        System.out.println();
        menu();
    }   
    }
    
    public static void admin(){
    boolean login = login(2);
    if(login){
        //menampilkan barang
        System.out.println(MAGENTA+"---------SELAMAT DATANG ADMIN!----------"+NORMAL);
        int menu, tetap;
        do{
            System.out.println(WHITE+"Pilih menu: "+NORMAL);
            System.out.print(WHITE+"1. Lihat data barang\n"+WHITE+"2. Tambah barang \n"+WHITE+"3. Ubah data barang\n"+WHITE+"4. Hapus data barang\n"+WHITE+"Opsi: "+NORMAL);
            menu = input.nextInt();
            System.out.println();
            switch(menu){
                case 1 ->{
                    System.out.println(WHITE+BACKGROUND_MAGENTA+"--------------DATA BARANG ALCAZARZARAY SHOP--------------"+NORMAL);
                    
                    
                    for(int i=0; i<data_barang.length; i++){
                    System.out.println(WHITE+(i+1)+". "+data_barang[i]+" | Barcode: "+data_barcode[i]+" | harga: "+data_harga[i]+NORMAL);
                    }
                    System.out.println();
                }
                case 2 ->{
                //menambah
                    System.out.println(BLUE+BACKGROUND_YELLOW+"TAMBAH BARANG"+NORMAL);
                    int lagi;
                    do{
                    System.out.println(WHITE+"Masukkan data barang yang akan ditambahkan"+NORMAL);
                    System.out.println(YELLOW+"Nama Barang: "+NORMAL);
                    String barang = input.next();
                    System.out.println(YELLOW+"Barcode: "+NORMAL);
                    String barcode = input.next();
                    System.out.println(YELLOW+"Harga (dalam rupiah, tulis angka saja): "+NORMAL);
                    int harga = input.nextInt();
                    tambah(barang, barcode, harga);
                    
                    System.out.println(BLUE+BACKGROUND_WHITE+"Tambah barang lagi?(1/0)"+NORMAL);
                    lagi = input.nextInt();
                    }while(lagi!=0);
                    
                }
                
                case 3 ->{
                //ubah data
                    System.out.println(CYAN+"EDIT DATA BARANG"+NORMAL);
                    int lagi, indeks=-1, ulang;
                    do{
                        //cari
                        do{
                            ulang = 0;
                            indeks = cari();
                            if (indeks<0){
                                System.out.println(RED+"Periksa kembali data"+NORMAL);
                                System.out.print(GREEN+"Ulangi pencarian? (1/0)"+NORMAL);
                                ulang= input.nextInt();
                            }
                        }while(ulang == 1);
                        if (indeks == -1){
                            break;
                        }
                    //output data
                    System.out.println(YELLOW+data_barang[indeks]+" | Barcode: "+data_barcode[indeks]+" | harga : " + data_harga[indeks]+NORMAL);
                    //edit
                    System.out.println(WHITE+"a. Edit nama barang \n"+WHITE+"b. Edit barcode \n"+WHITE+"c. Edit Harga"+NORMAL);
                    System.out.print(WHITE+"Pilih: "+NORMAL);
                    String edit = input.next();
                    switch(edit){
                        case "A", "a", "1" ->{
                            System.out.print(YELLOW+"Nama produk: "+NORMAL);
                            data_barang[indeks]=input.next();
                        }
                        case "B", "b","2" ->{
                            System.out.print(YELLOW+"Barcode: "+NORMAL);
                            data_barcode[indeks]=input.next();
                        }
                        case "C", "c", "3" ->{
                            System.out.print(YELLOW+"Harga: "+NORMAL);
                            data_harga[indeks]=input.nextInt();
                        }
                    }
                    
                    System.out.println(MAGENTA+"Edit data barang lagi?(1/0)"+NORMAL);
                    lagi = input.nextInt();
                    }while(lagi!=0);
                }
                case 4 ->{
                //hapus data
                    System.out.println(GREEN+"HAPUS DATA"+NORMAL);
                    int lagi, ulang, indeks=0;
                    do{
                    //cari
                        do{
                            ulang = 0;
                            indeks = cari();
                            if (indeks<0){
                                System.out.println(RED+"Periksa kembali data"+NORMAL);
                                System.out.print(GREEN+"Ulangi pencarian? (1/0)"+NORMAL);
                                ulang = input.nextInt();
                            }
                        }while(ulang == 1);
                        if (indeks == -1){
                            break;
                        }
                    System.out.println(YELLOW+data_barang[indeks]+" | Barcode: "+data_barcode[indeks]+" | harga : " + data_harga[indeks]+NORMAL);
                    
                    //hapus data
                    System.out.println(GREEN+"hapus data? (1/0)"+NORMAL);
                    int hapus = input.nextInt();
                    if (hapus == 1){
                        hapus(indeks);
                    }
                    
                    //ulang
                    System.out.println(MAGENTA+"Ingin hapus data barang lagi?(1/0)"+NORMAL);
                    lagi = input.nextInt();
                    }while(lagi!=0);
                    
                }
            
            }
        
        //log out/tetap
        System.out.println(WHITE+"Apakah anda ingin tetap di mode admin?(1/0)"+NORMAL);
        System.out.print(WHITE+"Jawab: "+NORMAL);
        tetap = input.nextInt();

        }while (tetap!=0);
        
        System.out.println(CYAN+"Terimakasih telah menjadi admin"+NORMAL);
        System.out.println();
        menu();
    }
    }
    
    public static void owner(){
    boolean login = login(3);
    if(login){
        System.out.println(CYAN+"\n-------------Hallo! Owner-------------\n"+NORMAL);
        int tetap, menu;
        do{
            System.out.println(WHITE+"Pilih menu: "+NORMAL);
            System.out.print(WHITE+"1. Laporan penjualan\n"+WHITE+"2. 5 Barang terlaris \n"+WHITE+"3. Penjualan sepekan\n"+WHITE+"Opsi: "+NORMAL);
            menu = input.nextInt();
            System.out.println();
            switch(menu){
                case 1 ->{
                    // laporan penjualan
                    System.out.println(RED+BACKGROUND_CYAN+"      LAPORAN PENJUALAN ALCAZARZARAY SHOP      "+NORMAL);
                    for(int i =0; i<data_barang.length; i++){
                        System.out.println(WHITE+data_barang[i]+" | Terjual: "+indeks_penjualan[i]+NORMAL); 
                    }
                    System.out.println();
                }
                case 2 ->{
                    // Copy array agar barang tidak berantakan
                    String[] barang = Arrays.copyOf(data_barang,data_barang.length);
                    int[] penjualan = Arrays.copyOf(indeks_penjualan,indeks_penjualan.length);
                    
                    // 5 barang paling laris
                    terlaris(barang, penjualan);
                    System.out.println(RED+BACKGROUND_YELLOW+"5 BARANG TERLARIS: "+NORMAL);
                    for (int i=0; i<5; i++){
                        System.out.println(MAGENTA+BACKGROUND_WHITE+(i+1)+". "+barang[i]+" | Terjual: "+penjualan[i]+"  "+NORMAL);
                    }
                    System.out.println();
                }
                case 3->{
                    // daftar harian dalam satu pekan
                    System.out.println(BLUE+BACKGROUND_WHITE+"PENJUALAN SEPEKAN"+NORMAL);
                    //penjualan lebih dari 7 hari
                    if (data_penjualan.length>7){
                        for(int i=data_penjualan.length-1; i>data_penjualan.length-7; i--){
                            System.out.println(WHITE+tanggal_penjualan[i]+data_penjualan[i]);
                            System.out.println();
                        }
                    }
                    //penjualan 7 hari
                    else if (data_penjualan.length<7){
                        for(int i=data_penjualan.length-1; i>-1; i--){
                            System.out.println(WHITE+tanggal_penjualan[i]+data_penjualan[i]);
                            System.out.println();
                        }
                    }
                }
            }
            
            
            //log out/tetap
            System.out.println(YELLOW+"Apakah anda ingin tetap di mode owner?(1/0)"+NORMAL);
            System.out.print(WHITE+"Jawab: "+NORMAL);
            tetap = input.nextInt();

        }while (tetap!=0);
        
        System.out.println(CYAN+"Terimakasih telah melihat laporan toko"+NORMAL);
        System.out.println();
        menu();
    }
    }
    
    static boolean login(int role){
        String[] username = {};
        String[] password = {};
        
        //akun kasir
        String[] username1 = {"chasier123", "Iamcashier", "Dori"};
        String[] password1 = {"onlycash", "12345678", "moramora"};
        
        //akun admin
        String[] username2 = {"IamEddie", "Anne", "lililili"};
        String[] password2 = {"notanymore", "password", "tralala"};
        
        //akun OWNER
        String[] username3 = {"zhonglee", "DoriDori"};
        String[] password3 = {"morax", "triplemora"};
        
        switch (role){
            case 1 ->{
                username = username1;
                password = password1;
            }
            case 2 ->{
                username = username2;
                password = password2;
            }
            case 3 ->{
                username = username3;
                password = password3;
            }
        }
        
        System.out.println(CYAN+"Login dulu yaa..."+NORMAL);
        
        boolean masuk = false;
        int benar, ulang=1;
        do{
            benar=1;
            System.out.print(MAGENTA+"Username: "+NORMAL);
            String u = input.next();
            int idx=0;
            boolean  ada=false;
            for (int i = 0; i<username.length; i++){
                    if(username[i].equals(u)){
                    idx = i;
                    ada=true;
                    break;
                    }
            }
            if(ada){
                System.out.print(MAGENTA+"Password: "+NORMAL);
                String pw = input.next();
                if(pw.equals(password[idx])){
                    masuk = true;
                }
            }
            else{
                System.out.println(RED+"Periksa kembali penulisan username, coba ulang"+NORMAL);
                benar=0;
                ulang=ulang+1;
            }
            if(!masuk && ada){
                System.out.println(RED+"Ingat-ingat kembali password, coba ulang"+NORMAL);
                benar=0;
                ulang=ulang+1;
            }
            if(ulang>3){
                System.out.println("Maaf sudah 3 kali percobaan. Silahkan restart aplikasi");
                break;
            }
        }while(benar==0);
        
        return masuk;
    }
    
    static int cari(){
        System.out.println(WHITE+"Pilih mode cari data \n"+CYAN+"1. Barcode\n"+CYAN+"2. Barang"+NORMAL);
        System.out.print(WHITE+"Mode yang dipilih: "+NORMAL);
        int mode = input.nextInt();
        int indeks =-1;
        switch (mode){
            case 1 -> {
            System.out.print(YELLOW+"Barcode : "+NORMAL);
            String kata1 = input.next();
            indeks = cariBarcode(kata1);
            }
            case 2 -> {
            System.out.println(YELLOW+"Nama Barang : "+NORMAL);
            String kata2 = input.next();
            indeks = cariBarang(kata2);
            }
        }
        return indeks;
            
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
    
    static int cariBarang(String x){
        int idx = -1;
        boolean ada = false;
        
        for (int i = 0; i<data_barang.length; i++){
                if(data_barang[i].equals(x)){
                idx = i;
                ada = true;
                break;
                }
        }
        return idx;
    }
    
    static void tambah(String nbarang, String nbarcode, int nharga){
        List<String> newdata_barang = new ArrayList<>(Arrays.asList(data_barang));
        newdata_barang.add(nbarang);
        data_barang = newdata_barang.toArray(data_barang);
        
        List<String> newdata_barcode = new ArrayList<>(Arrays.asList(data_barcode));
        newdata_barcode.add(nbarcode);
        data_barcode = newdata_barcode.toArray(data_barcode);
        
        data_harga = Arrays.copyOf(data_harga, data_harga.length+1);
        data_harga[data_harga.length-1] = nharga;
        
        indeks_penjualan = Arrays.copyOf(indeks_penjualan,indeks_penjualan.length+1);
        indeks_penjualan[indeks_penjualan.length-1] = 0;
    }
    
    static void hapus(int indeks){
        for (int i= indeks; i<data_barang.length-1; i++){
            data_barang[i]=data_barang[i+1];
        }
        data_barang = Arrays.copyOf(data_barang, data_barang.length-1);
        
        for (int i= indeks; i<data_barcode.length-1; i++){
            data_barcode[i]=data_barcode[i+1];
        }
        data_barcode = Arrays.copyOf(data_barcode, data_barcode.length-1);
        
        for (int i= indeks; i<data_harga.length-1; i++){
            data_harga[i]=data_harga[i+1];
        }
        data_harga = Arrays.copyOf(data_harga, data_harga.length-1);
    }
    
    static void terlaris(String[] barang, int[] penjualan){
        int temp, max_idx;
        String stemp;
        for (int i=0; i<barang.length-1; i++){
            max_idx=i;
            for(int j=i+1; j<barang.length; j++){
                if (penjualan[j]>penjualan[max_idx]){
                    max_idx = j;
                }
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
