package listlanjutan;
public class cBarang {
    String nama;
    int harga;
    
    cBarang(String n, int h){
        nama=n; harga=h;
        System.out.println("Objek barang "+nama+" berhasil dibuat");
    }
    
    String getNama(){
        return nama;
    }
}
