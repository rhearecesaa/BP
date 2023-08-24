package fp;
public class cTransaksi { //the node class
    String kode, pembeli;
    cBarang barang;
    int jumlah, status;
    cTransaksi prev, next;
    cTransaksi(){
        
    }
    cTransaksi(String k, cBarang b, String p, int j, int s){
        kode=k; barang=b; pembeli=p;jumlah=j;status=0;
    }
    int getStatus(){
        return status;
    }
    
    cBarang getBarang(){
        return barang;
    }
    
    int getJumlah(){
        return jumlah;
    }
    
    String getPembeli(){
        return pembeli;
    }
    
    String getKode(){
        return kode;
    }
    
    void setStatus(int s){status = s;}
}
