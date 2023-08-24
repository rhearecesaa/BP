package circularlist;
public class cCircularList {
    //tidak memiliki akhir, pointer tail diarahkan kembali ke head
    //contoh: permainan monopoli
    //untuk: aplikasi yang mengatur akses komponen secara bergantian
    //untuk: proses yang berjalan "bersamaan"=> metode Round Robin
    cNode head, tail;
    int jNode;
    
    cCircularList(){
        head=tail=null;
        jNode=0;
        System.out.println("Circular List dibuat");
    }
    
    void addNode(cNode baru){
        if(head == null){ //=>list kosong
            head=tail=baru;
            tail.next=head;
        }
        else{
            baru.next=head;
            tail.next=baru;
            head=baru;
        }
        System.out.println("Penambahan simpul sukses");
    }
    void delNode(){
        if(tail==null){
            System.out.println("Linked List Kosong!");
        }
        else if (head.next==null){ //1 doang
            System.out.println("Simpul berhasil dihapus");
            head=tail=null;
        }
        else{
            cNode temp = head.next;
            head.next=null;
            head = temp;
            tail.next=head;
            System.out.println("Simpul berhasil dihapus");
        }
    }
    
    void viewList(){
        System.out.print("Isi rangkaian: ");
        cNode i = head;
        do{
            System.out.print(i.getData()+" ");
            i=i.next;
        }while(i!=head);
        System.out.println();
    }
    
    void findList(int c){
        cNode start = null;
        if(head==null){
            System.out.println("Linked List Kosong!");
        }
        else{
            boolean ada = false;
            cNode i = head;
            do{
                if(i.getData()==c){
                    ada = true;
                    start=i;
                    break;
                }
                i=i.next;
            }while(i!=head);
            if(ada){
                System.out.println("Data "+c+" ditemukan");
                System.out.print("Isi Rangkaian: ");
                i = start;
                do{
                    System.out.print(i.getData()+" ");
                    i=i.next;
                }while(i!=start);
                System.out.println();
            }
            else{
                System.out.println("Data "+c+" tidak ditemukan");
            }
        }
    }
}
