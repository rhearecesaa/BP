package fp;

import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //data barang
        cBarang brg1 = new cBarang("Nasi Ayam Kecap", 14000);
        cBarang brg2 = new cBarang("Nasi Ati Ampla", 12000);
        cBarang brg3 = new cBarang("Nasi Telur Bali", 12000);
        cBarang brg4 = new cBarang("Nasi Udang Sambal", 14000);
        cBarang brg5 = new cBarang("Nasi Cecek", 10000);
        //data member
        cMember[] member = new cMember[4];
        member[0]= new cMember("Mafda145", "145", "Mafda");
        member[1]= new cMember("Rahayu146", "146", "Rahayu");
        member[2]= new cMember("Mifa147", "147", "Mifa");
        member[3]= new cMember("Vivi152", "152", "Vivi");
        //data admin
        String[] idAdmin={"Mafda145","Rahayu146","Mifa147","Vivi152"};
        String[] pwAdmin={"145","146","147","152",};
        cDaftarTransaksi tr = new cDaftarTransaksi();
        int pilih, pilih2, pilih3;
        //INISIASI
        int kode,jumlah;
        System.out.println("\nSelamat Datang di ");
        System.out.println("APLIKASI PENJUALAN WARUNG BU ANDRIK");
        System.out.println("By: VIMIRAMA TEAM");
        System.out.println("    - 22082010145 (Mafda Khoirotul Fatha)");
        System.out.println("    - 22082010146 (Rahayu Kartika Sari)");
        System.out.println("    - 22082010147 (Mifa Amira Dewi");
        System.out.println("    - 22082010152 (Viviana Purba)");
        //main menu
        do{
            System.out.println("\nMENU");
            System.out.println("1. Pembeli");
            System.out.println("2. Member");
            System.out.println("3. Admin");
            System.out.println("4. Pemilik");
            System.out.println("5. Exit");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            switch(pilih){
                case 1:
                    kode =100;
                    kode++;
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.println("\nMasuk Sebagai Pembeli");
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.next();
                    
                    do{
                        System.out.println("Menu Pembeli");
                        System.out.println("1.Tambah");
                        System.out.println("2.Hapus");
                        System.out.println("3.Lihat");
                        System.out.println("4.Kembali");
                        System.out.print("Pilih = ");
                        pilih2 = sc.nextInt();
                        switch(pilih2){
                            case 1: //tambah menu
                                cTransaksi br = null;
                                System.out.println("Daftar Menu: ");
                                System.out.println("1."+brg1.getNama()+"\t\t["+brg1.getHarga()+"]");
                                System.out.println("2."+brg2.getNama()+"\t\t["+brg2.getHarga()+"]");
                                System.out.println("3."+brg3.getNama()+"\t\t["+brg3.getHarga()+"]");
                                System.out.println("4."+brg4.getNama()+"\t\t["+brg4.getHarga()+"]");
                                System.out.println("5."+brg5.getNama()+"\t\t\t["+brg5.getHarga()+"]");
                                System.out.print("Pilih = ");
                                pilih3 = sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah = sc.nextInt();
                                switch (pilih3) {
                                    case 1:
                                        br = new cTransaksi(String.valueOf(kode),brg1,nama,jumlah,0);
                                        break;
                                    case 2:
                                        br = new cTransaksi(String.valueOf(kode),brg2,nama,jumlah,0);
                                        break;
                                    case 3:
                                        br = new cTransaksi(String.valueOf(kode),brg3,nama,jumlah,0);
                                        break;
                                    case 4:
                                        br = new cTransaksi(String.valueOf(kode),brg4,nama,jumlah,0);
                                        break;
                                    case 5:
                                        br = new cTransaksi(String.valueOf(kode),brg5,nama,jumlah,0);
                                        break;
                                    default:
                                        break;
                                }   
                                beli.tambahTransaksi(br);
                                break;
                                
                            case 2:
                                //hapus
                                beli.lihatTransaksi(1);
                                System.out.print("Hapus Nomor = ");
                                pilih3=sc.nextInt();
                                System.out.println("Yakin untuk menghapus? (1/0)");
                                System.out.print("Jawab = ");
                                int hapus = sc.nextInt();
                                if(hapus==1){
                                    beli.hapusTransaksi(pilih3);
                                }
                                else{
                                    System.out.println("Hapus Transaksi dibatalkan");
                                }
                                break;
                            case 3: 
                                //lihat
                                beli.lihatTransaksi(1);
                                break;
                            case 4:
                                tr.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat datang kembali..");
                                break;
                        }
                    }while(pilih2!=4);
                    break;
                case 2:
                    System.out.println("\nMasuk Sebagai Member");
                    System.out.println("  Masukkan ID dan Password");
                    System.out.print("ID       = ");
                    String id=sc.next();
                    System.out.print("Password = ");
                    String pn=sc.next();
                    boolean valid=false; int indeks=0;
                    for(int i=0; i<member.length;i++){
                        if(member[i].idMember.equals(id)){
                            if(member[i].password.equals(pn)){
                                valid=true;
                                indeks=i;
                            }
                            else{
                                System.out.println("Maaf PIN anda salah...");
                            }
                        }
                    }
                    if(!valid){
                        System.out.println("Maaf ID Member tidak ditemukan ....");
                    }
                    else{
                        kode=200; 
                        cDaftarTransaksi beli2 = new cDaftarTransaksi();
                        String nmem = member[indeks].nama;
                        System.out.println("Selamat Datang "+nmem+"....");
                        do{
                            System.out.println("\nMenu Member"); 
                            System.out.println("1.Tambah Transaksi");
                            System.out.println("2.Hapus Transaksi");
                            System.out.println("3.Lihat Transaksi");
                            System.out.println("4.Ubah Password");
                            System.out.println("5.Kembali");
                            System.out.print("Pilih = ");
                            pilih2=sc.nextInt();
                            switch(pilih2){
                                case 1:
                                    kode++;
                                    cTransaksi br = null;
                                    System.out.println("Daftar Menu: ");
                                    System.out.println("1."+brg1.getNama()+"\t\t["+brg1.getHarga()+"]");
                                    System.out.println("2."+brg2.getNama()+"\t\t["+brg2.getHarga()+"]");
                                    System.out.println("3."+brg3.getNama()+"\t\t["+brg3.getHarga()+"]");
                                    System.out.println("4."+brg4.getNama()+"\t\t["+brg4.getHarga()+"]");
                                    System.out.println("5."+brg5.getNama()+"\t\t\t["+brg5.getHarga()+"]");
                                    System.out.print("Pilih = ");
                                    pilih3 = sc.nextInt();
                                    System.out.print("Jumlah = ");
                                    jumlah = sc.nextInt();
                                    double total=0;
                                    switch (pilih3) {
                                        case 1:
                                            br = new cTransaksi(String.valueOf(kode),brg1,nmem,jumlah,0);
                                            break;
                                        case 2:
                                            br = new cTransaksi(String.valueOf(kode),brg2,nmem,jumlah,0);
                                            break;
                                        case 3:
                                            br = new cTransaksi(String.valueOf(kode),brg3,nmem,jumlah,0);
                                            break;
                                        case 4:
                                            br = new cTransaksi(String.valueOf(kode),brg4,nmem,jumlah,0);                                            
                                            break;
                                        case 5:
                                            br = new cTransaksi(String.valueOf(kode),brg5,nmem,jumlah,0);
                                            break;
                                        default:
                                            break;
                                        }  
                                    beli2.tambahTransaksi(br);
                                    break;
                                case 2:
                                    beli2.lihatTransaksi(2);
                                    System.out.print("Hapus Nomor = ");
                                    pilih3=sc.nextInt();
                                    System.out.println("Yakin untuk menghapus? (1/0)");
                                    System.out.print("Jawab = ");
                                    int hapus = sc.nextInt();
                                    if(hapus==1){
                                        beli2.hapusTransaksi(pilih3);
                                    }
                                    else{
                                        System.out.println("Hapus Transaksi dibatalkan");
                                    }
                                    break;
                                case 3:
                                    beli2.lihatTransaksi(2);
                                    break;
                                case 4: //ubah password
                                    System.out.println("Masukkan Password Baru ");
                                    System.out.print("Password = ");
                                    String pwbar = sc.next();
                                    member[indeks].setPassword(pwbar);
                                    break;
                                case 5:
                                    tr.sambungTransaksi(beli2.getFront(), beli2.getRear());
                                    System.out.println("Selamat datang kembali..");
                                    break;
                                }
                            }while(pilih2!=5);
                            break;
                        }
                    break;
                case 3:
                    System.out.println("  Masukkan ID dan Password");
                    System.out.print("ID       = ");
                    String ida=sc.next();
                    System.out.print("Password = ");
                    String pna=sc.next();
                    boolean valid2=false; 
                    for(int i=0; i<idAdmin.length;i++){
                        if(idAdmin[i].equals(ida)){
                            if(pwAdmin[i].equals(pna)){
                                valid2=true;
                            }
                            else{
                                System.out.println("Maaf PIN anda salah...");
                            }
                        }
                    }
                    if(!valid2){
                        System.out.println("Maaf ID Admin tidak ditemukan ....");
                    }
                    else{
                        System.out.println("Selamat Datang Admin");
                        do{
                            System.out.println("\n Menu Admin");
                            System.out.println("1. Lihat Transaksi Belum Diproses");
                            System.out.println("2. Proses Transaksi");
                            System.out.println("3. Kembali");
                            System.out.print("Pilih : ");
                            pilih2=sc.nextInt();
                            switch(pilih2){
                                case 1:
                                    tr.lihatBelumDiproses();
                                    break;
                                case 2: 
                                    cTransaksi t=tr.getFront();
                                    if(t==null){
                                        System.out.println("Daftar pembelian Kosong");
                                    }
                                    else{
                                        do{
                                            if(t.getStatus()==0){
                                                System.out.println("Kode     : "+t.getKode());
                                                System.out.println("Pembeli  : "+t.getPembeli());
                                                System.out.println("Barang   : "+t.getBarang().getNama());
                                                System.out.println("Jumlah   : "+t.getJumlah());
                                                System.out.println("Pilih Aksi");
                                                System.out.println("1. Diproses");
                                                System.out.println("2. Selesai");
                                                System.out.print("Pilih = ");
                                                int aksi =sc.nextInt();
                                                if(aksi==1){
                                                    double tot=0;
                                                    tr.prosesTransaksi(t);
                                                    System.out.println("Berhasil diproses...\n");
                                                    if(t.getKode().contains("20")){
                                                        int idx=-1;
                                                        for(int i =0; i<member.length; i++){
                                                            if(t.getPembeli() == null ? member[i].nama == null : t.getPembeli().equals(member[i].nama)){
                                                                idx=i;
                                                            }
                                                        }
                                                        if(idx>-1){
                                                            tot=t.getBarang().getHarga()*t.getJumlah()*0.95;
                                                            member[idx].addPengeluaran(tot);
                                                            t.getBarang().setPenjualan(tot);
                                                        }
                                                    }
                                                    else{
                                                       tot=t.getBarang().getHarga()*t.getJumlah();
                                                       t.getBarang().setPenjualan(tot);
                                                    }
                                                }
                                                else{
                                                    break;
                                                } 
                                            }
                                            t=t.next;
                                        }while(t!=null);
                                    }
                                    break;
                                case 3:
                                    System.out.println("Terimakasih, semangat...");
                                    break;
                            }
                        }while(pilih2!=3);
                        break;
                    }
                    break;
                case 4:
                    String idpemilik="404",password="101";
                    System.out.println("Masuk sebagai Pemilik");
                    System.out.println("  Masukkan ID dan Password");
                    System.out.print("ID       = ");
                    String idp=sc.next();
                    System.out.print("Password = ");
                    String pnp=sc.next();
                    boolean valid3=false; 
                    if(idpemilik.equals(idp)){
                        if(password.equals(pnp)){
                            valid3=true;
                        }
                        else{
                            System.out.println("Maaf PIN anda salah...");
                        }
                    }
                    if(!valid3){
                        System.out.println("Maaf ID Pemilik tidak ditemukan ....");
                    }
                    else{
                        System.out.println("Selamat datang...");
                        do{
                            System.out.println("Menu Pemilik");
                            System.out.println("1. Lihat Transaksi");
                            System.out.println("2. Edit Barang");
                            System.out.println("3. Laporan Penjualan Hari Ini");
                            System.out.println("4. Laporan Pembelian Member");
                            System.out.println("5. Grafik Penjualan");
                            System.out.println("6. Kembali");
                            System.out.print("Pilih = ");
                            pilih2=sc.nextInt();
                            switch(pilih2){
                                case 1:
                                    System.out.println("Menu Penghitungan Transaksi");
                                    System.out.println("1. Transaksi yang sudah diproses");
                                    System.out.println("2. Transaksi yang belum diproses");
                                    System.out.print("Pilih : ");
                                    pilih3=sc.nextInt();
                                    switch(pilih3){
                                        case 1: 
                                            System.out.println("Transaksi Diproses : "+tr.hitungDiproses());
                                            break;
                                        case 2:
                                            System.out.println("Transaksi Belum Diproses : "+tr.hitungBlmDiproses());
                                            break;
                                    }
                                    break;
                                case 2: //edit barang
                                    System.out.println("Daftar Menu: ");
                                    System.out.println("1."+brg1.getNama()+"\t\t["+brg1.getHarga()+"]");
                                    System.out.println("2."+brg2.getNama()+"\t\t["+brg2.getHarga()+"]");
                                    System.out.println("3."+brg3.getNama()+"\t\t["+brg3.getHarga()+"]");
                                    System.out.println("4."+brg4.getNama()+"\t\t["+brg4.getHarga()+"]");
                                    System.out.println("5."+brg5.getNama()+"\t\t\t["+brg5.getHarga()+"]");
                                    System.out.print("Pilih yang diedit = ");
                                    pilih3 = sc.nextInt();
                                    System.out.print("Harga Baru = ");
                                    int hb=sc.nextInt();
                                    switch (pilih3) {
                                        case 1:
                                            brg1.setHarga(hb);
                                            break;
                                        case 2:
                                            brg2.setHarga(hb);
                                            break;
                                        case 3:
                                            brg3.setHarga(hb);
                                            break;
                                        case 4:
                                            brg4.setHarga(hb);
                                            break;
                                        case 5:
                                            brg5.setHarga(hb);
                                            break;
                                        default:
                                            break;
                                        } 
                                    break;
                                case 3://laporan harian
                                    double totpen=brg1.penjualan+brg2.penjualan+brg3.penjualan+brg4.penjualan+brg5.penjualan;
                                    System.out.println("Total Pendapatan : "+totpen);
                                    System.out.println("1. "+brg1.getNama()+"\t : "+brg1.penjualan);
                                    System.out.println("2. "+brg2.getNama()+"\t : "+brg2.penjualan);
                                    System.out.println("3. "+brg3.getNama()+"\t : "+brg3.penjualan);
                                    System.out.println("4. "+brg4.getNama()+"\t : "+brg4.penjualan);
                                    System.out.println("5. "+brg5.getNama()+"\t\t : "+brg5.penjualan);
                                    break;
                                case 4://laporan member
                                    System.out.println("1. "+member[0].nama+"\t : "+member[0].pengeluaran);
                                    System.out.println("2. "+member[1].nama+"\t : "+member[1].pengeluaran);
                                    System.out.println("3. "+member[2].nama+"\t\t : "+member[2].pengeluaran);
                                    System.out.println("4. "+member[3].nama+"\t\t : "+member[3].pengeluaran);
                                    break;
                                case 5://grafik
                                    System.out.println("Grafik Penjualan: ");
                                    System.out.print("1. "+brg1.getNama()+"\t : ");
                                    if(brg1.penjualan!=0){
                                        for(int i=1; i<=(brg1.penjualan/10000); i++){
                                            System.out.print("X");
                                        }
                                    }
                                    System.out.println(" "+brg1.penjualan);
                                    System.out.print("2. "+brg2.getNama()+"\t : ");
                                    if(brg2.penjualan!=0){
                                        for(int i=1; i<=(brg2.penjualan/10000); i++){
                                            System.out.print("X");
                                        }
                                    }
                                    System.out.println(" "+brg2.penjualan);
                                    System.out.print("3. "+brg3.getNama()+"\t : ");
                                    if(brg3.penjualan!=0){
                                        for(int i=1; i<=(brg3.penjualan/10000); i++){
                                            System.out.print("X");
                                        }
                                    }
                                    System.out.println(" "+brg3.penjualan);
                                    System.out.print("4. "+brg4.getNama()+"\t : ");
                                    if(brg4.penjualan!=0){
                                        for(int i=1; i<=(brg4.penjualan/10000); i++){
                                            System.out.print("X");
                                        }
                                    }
                                    System.out.println(" "+brg4.penjualan);
                                    System.out.print("5. "+brg5.getNama()+"\t\t : ");
                                    if(brg5.penjualan!=0){
                                        for(int i=1; i<=(brg5.penjualan/10000); i++){
                                            System.out.print("X");
                                        }
                                    }
                                    System.out.println(" "+brg5.penjualan);
                                    break;
                                case 6:
                                    System.out.println("Terimakasih ....");
                                    break;
                            } 
                        }while(pilih2!=6);                        
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih...");
                    break;
            }
        }while(pilih!=5);
    }
}
