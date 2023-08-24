package queue;

import java.util.Scanner;

public class Main {
    /*
    tambah depan, hapus belakang
    FIFO(First In First Out)
    
    Jenis:
    1. Circular/Ring Buffer => circular linked list 
    2. Priority Queue => yang paling prioritas yang keluar dulu
    */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue(10);
        int pilih =0;
        do{
            System.out.println("\nMenu Antrian");
            System.out.println("1. Add (Enqueue)");
            System.out.println("2. Call (Dequeue)");
            System.out.println("3. View");
            System.out.println("4. Exit");
            System.out.print("Jawab = ");
            pilih = sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.println("  TAMBAH ANTRIAN");
                    System.out.print("  Nama = ");
                    String nm = sc.next();
                    System.out.print("  Prioritas = ");
                    int p = sc.nextInt();
                    Pembeli x = new Pembeli(nm, p);
                    q.enqueue(x);
                    q.view();
                    break;
                case 2:
                    String call = q.dequeue();
                    if(!call.isEmpty()){
                        System.out.println("Panggil "+ANSI_CYAN+call+ANSI_RESET);
                    }
                    break;
                case 3: 
                    q.view();
                    break;
                case 4: break;
            }
        }while(pilih !=4);
    }
}
