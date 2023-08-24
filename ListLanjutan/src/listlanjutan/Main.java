package listlanjutan;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cBarang b1 = new cBarang("apel", 5000);
        cBarang b2 = new cBarang("manggis", 6000);
        cBarang b3 = new cBarang("jeruk", 4000);
        cNode n1 = new cNode(b1);
        cNode n2 = new cNode(b2);
        cNode n3 = new cNode(b3);
        cDoubleLinkedList dll = new cDoubleLinkedList();
        dll.tambahBelakang(n1);
        dll.tambahBelakang(n2);
        dll.tambahBelakang(n3);
        
        System.out.println("\n======================================================================");
        System.out.println("DIBUAT OLEH: RAHAYU KARTIKA SARI - 22082010146");
        
        int pilih=0;
        do{
            System.out.println("\nMENU DOUBLE LINKED LIST");
            System.out.println("Menu: ");
            System.out.println("[1] Tambah Node");
            System.out.println("[2] Hapus Node");
            System.out.println("[3] Cari Data");
            System.out.println("[4] Lihat List");
            System.out.println("[5] Keluar");
            System.out.print("Pilih = ");
            pilih = sc.nextInt();
        switch(pilih){
            case 1: 
                System.out.println("\nTAMBAH NODE");
                System.out.println("1. Tambah Depan");
                System.out.println("2. Tambah Belakang");
                System.out.print("Pilih = ");
                int p = sc.nextInt();
                System.out.print("Masukkan Nama = ");
                String nm = sc.next();
                System.out.print("Masukkan Harga = ");
                int hg = sc.nextInt();
                cBarang b = new cBarang(nm,hg);
                cNode nd = new cNode(b);
                if(p==1){
                    dll.tambahDepan(nd);
                }
                else if(p==2){
                    dll.tambahBelakang(nd);
                }
                break;
            case 2: 
                System.out.println("\nHAPUS NODE");
                System.out.println("1. Hapus Depan");
                System.out.println("2. Hapus Belakang");
                System.out.print("Pilih = ");
                int d = sc.nextInt();
                if(d==1){
                    dll.delNode(1);
                }
                else if(d==2){
                    dll.delNode(2);
                }
                break;
            case 3:
                System.out.println("\nCARI DATA");
                System.out.print("Masukkan Data = ");
                String c = sc.next();
                dll.findList(c);
                break;
            case 4: 
                System.out.println("\nLIHAT LIST");
                System.out.println("1. Dari Depan");
                System.out.println("2. Dari Belakang");
                System.out.print("Pilih = ");
                int l = sc.nextInt();
                if(l==1){
                    dll.viewList(1);
                }
                else if(l==2){
                    dll.viewList(2);
                }
                break;
            case 5: 
                System.out.println("See You...");
                break;
        }
        }while(pilih!=5);
    }
    
}
