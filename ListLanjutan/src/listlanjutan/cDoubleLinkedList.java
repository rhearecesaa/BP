package listlanjutan;
public class cDoubleLinkedList {
    cNode head, tail;
    int jNode;
    
    cDoubleLinkedList(){
        head=tail=null;
        jNode=0;
        System.out.println("DLL dibuat");
    }
    
    void tambahDepan(cNode baru){
        if(head == null){ //=>list kosong
            head=tail=baru;
        }
        else{
            baru.next=head;
            head.prev=baru;
            head=baru;
        }
        System.out.println("Penambahan depan simpul sukses");
    }
    
    void tambahBelakang(cNode baru){
        if(head == null){ //=>list kosong
            head=tail=baru;
        }
        else{
            tail.next=baru;
            baru.prev=tail;
            tail=baru;
        }
        System.out.println("Penambahan belakang simpul sukses");
    }
    
    void delNode(int i){
        if(tail==null){
            System.out.println("Linked List Kosong!");
        }
        else if (tail.prev==null){ //1 doang
            System.out.println("Simpul berhasil dihapus");
            head=tail=null;
        }
        else{
            switch(i){
                case 1:
                    cNode temp1 = head.next;
                    head.next=null;
                    head = temp1;
                    head.prev=null;
                    System.out.println("Simpul paling depan berhasil dihapus");
                    break;
                case 2:
                    cNode temp2 = tail.prev;
                    tail.prev=null;
                    tail = temp2;
                    tail.next=null;
                    System.out.println("Simpul paling belakang berhasil dihapus");
                    break;
            }
        }
    }
    
    void viewList(int p){
        if(tail==null){
            System.out.println("Linked List Kosong!");
        }
        else{
            switch(p){
                case 1:
                    System.out.println("Dari Depan: ");
                    for(cNode i = head; i!= null; i=i.next){
                        System.out.print(i.getData().getNama()+"-");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Dari Belakang: ");
                    for(cNode i = tail; i!= null; i=i.prev){
                        System.out.print(i.getData().getNama()+"-");
                    }
                    System.out.println();
                    break;
            }
        }
    }
    
    void findList(String cari){
        String txt;
        if(tail==null){
            txt="Linked List Kosong!";
        }
        else{
            boolean ada = false;
            for(cNode i = head; i!= null; i=i.next){
                if(i.getData().getNama() == null ? cari == null : i.getData().getNama().equals(cari)){
                    ada=true;
                    break;
                }
            }
            if(ada){
                txt="Data "+ cari + " Ditemukan";
            }
            else{
                txt="Data "+ cari + " Tidak Ditemukan...";
            }
        }
        System.out.println(txt);
    }
}
