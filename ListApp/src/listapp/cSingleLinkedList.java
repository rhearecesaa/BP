package listapp;

public class cSingleLinkedList {
    cNode head,tail;
    int jmlSimpul;
    
    cSingleLinkedList(){
        head=tail=null;
        jmlSimpul=0;
    }
    void addDepan(cNode baru){
        
    }
    void addBelakang(){
        
    }
    void addNode(cNode baru){//belakang
        if(head == null){ //=>list kosong
            head=tail=baru;
        }
        else{
            tail.next=baru;
            tail=baru;
        }
    }
    void delNode(){//depan
        if(head==null){
            System.out.println("Linked List Kosong!");
        }
        else if (head.next==null){ //1 doang
            System.out.println("Simpul "+ head.nama +" dihapus");
            head=null;
            tail=null;
        }
        else{
            cNode t = head; 
            head=head.next;
            System.out.println("Simpul "+t.nama+" dihapus");
            t=null;
        }
    }
    void viewList(){
        for(cNode t=head; t!=null;t=t.next){
            System.out.println("  - "+t.nama);
        }
        System.out.println("");
    }
     void cari(String c){
        boolean ada = false;
        for(cNode t=head; t!=null; t=t.next){
            if(t.nama == null ? c == null : t.nama.equals(c)){
                ada = true;
                break;
            }
        }
        if(ada==false){
            System.out.println("  >> Data "+c+" Tidak Ditemukan");
        }
        else{
            System.out.println("  >> Data "+c+" Ditemukan");
        }
    }
}
