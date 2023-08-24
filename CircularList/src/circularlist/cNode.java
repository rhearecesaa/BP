package circularlist;
public class cNode {
    int data;
    
    //linker
    cNode next;
    
    cNode(int d){
        data = d;
        next=null;
    }
    
    int getData(){
        return data;
    }
}