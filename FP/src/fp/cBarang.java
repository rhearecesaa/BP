package fp;
public class cBarang {
    String nama;
    int harga;
    double penjualan;
    
    cBarang(String n, int h){
        nama=n; harga=h; penjualan=0;
    }
    
    String getNama(){
        return nama;
    }
    int getHarga(){
        return harga;
    }
    
    void setHarga(int h){
        harga=h;
        System.out.println("Ubah Harga Barang berhasil..");
    }
    void setPenjualan(double p){
        penjualan=p+penjualan;
    }
}
