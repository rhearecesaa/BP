package listlanjutan;
public class cNode {
    cBarang barang;
    
    //linker
    cNode next;
    cNode prev;
    
    cNode(cBarang b){
        barang = b;
        prev=next=null;
    }
    
    cBarang getData(){
        return barang;
    }
}
