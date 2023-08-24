package queue;
public class Pembeli{//the node
    String nama;
    int val;
    Pembeli next, prev;//linker
    Pembeli(String n, int v){
        nama=n;
        val=v;
        System.out.println(nama+" dibuat...");
    }
}
