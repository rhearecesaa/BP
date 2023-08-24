package circularlist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cNode n1 = new cNode(10);
        cNode n2 = new cNode(12);
        cNode n3 = new cNode(14);
        
        cCircularList cll = new cCircularList();
        
        cll.addNode(n1);
        cll.addNode(n2);
        cll.addNode(n3);
        
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
                System.out.println("\nTAMBAH NODE");
                System.out.print("Masukkan Data = ");
                int nm = sc.nextInt();
                cNode nd = new cNode(nm);
                cll.addNode(nd);
                break;
            case 2: 
                cll.delNode();
                break;
            case 3: 
                System.out.println("\nCARI NODE");
                System.out.print("Data Yang Dicari = ");
                int c = sc.nextInt();
                cll.findList(c);
                break;
            case 4: 
                System.out.println("\nLIHAT NODE");
                cll.viewList();
                break;
            case 5: 
                System.out.println("See You...");
                break;
        }
        }while(pilih!=5);

    }
    
}
