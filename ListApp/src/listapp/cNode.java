package listapp;

public class cNode {
    String nama;
    int harga;
    
    cNode next; //next ada 1 = single lists
    //cNode prev; //ada 2 => double list
    
    //constructor
    cNode(String d){
        nama = d;
        next = null;
        System.out.println("Node "+ d + " created...");
    }
    
}
