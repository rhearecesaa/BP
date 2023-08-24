package palidrom;
public class Stack {
    Item top, bottom; //head, tail;
    int sum, capacity; //jumlah node
    
    Stack(int maks){
        top=bottom=null;
        sum=0;
        capacity = maks;
    }
    
    void push(char h){ //tambah depan
        Item baru = new Item(h);
        if(sum==capacity){ //stack full
            System.out.println("Stack sudah penuh!");
        }
        else{
            if (top==null){ //kosong
                top=bottom=baru;
            }
            else{ //sudah ada isi
                baru.next=top;
                top.prev=baru;
                top=baru;
            }
            sum++; //jumlah ditambah
        }
    }
    
    char pop(){//hapus depan
        Item out = null;
        if(sum==0){
            System.out.println("Stack sudah kosong!");
        }
        else{
            out = top;
            if(sum==1){ //isi 1
                top=bottom=null;
            }
            else{
                top=top.next;
                top.prev=null;
                out.next=null;
            }
            sum--;
        }
        return out.element;
    }
    
    boolean isEmpty(){
        boolean kosong = false;
        kosong = top==null;
        return kosong;
    }
}
