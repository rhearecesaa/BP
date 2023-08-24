package listapp;

import java.util.Scanner;

public class ListApp {

    public static void main(String[] args) {
        cNode n1 = new cNode("Facewash");
        cNode n2 = new cNode("Toner");
        cNode n3 = new cNode("Serum");
        
        /*
        n1.next=n2;
        n2.next=n3;
        //n2.next=n1; List akan berulang terus, krn kembali ke n1=n3
        
        System.out.println("Isi Linked List: ");
        for(cNode t=n1; t!=null; t=t.next){
            System.out.print(t.nama+"-");
        }
        System.out.println("");
        */
        
        cSingleLinkedList sll = new cSingleLinkedList();
        
        sll.addNode(n1);
        sll.addNode(n2);
        sll.addNode(n3);
        
        int pilih=0;
        do{
        System.out.println("\nAPLIKASI LINKED LIST");
        System.out.println("Menu: ");
        System.out.println("[1] Tambah Node");
        System.out.println("[2] Hapus Node");
        System.out.println("[3] Cari Node");
        System.out.println("[4] Lihat Node");
        System.out.println("[5] Keluar");
        System.out.print("Pilih = ");
        Scanner sc = new Scanner(System.in);
        pilih = sc.nextInt();
        switch(pilih){
            case 1: 
                System.out.println("  TAMBAH NODE");
                System.out.print("  Masukkan Data = ");
                String nm = sc.next();
                cNode nd = new cNode(nm);
                sll.addNode(nd);
                break;
            case 2: 
                System.out.print("  ");
                sll.delNode();
                break;
            case 3: 
                System.out.println("  CARI NODE");
                System.out.print("  Data Yang Dicari = ");
                String c = sc.next();
                sll.cari(c);
                break;
            case 4: 
                System.out.println("  LIHAT NODE");
                sll.viewList();
                break;
            case 5: 
                System.out.println("See You...");
                break;
        }
        }while(pilih!=5);
    }
}
