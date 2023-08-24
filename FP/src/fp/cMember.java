package fp;
public class cMember {
    String idMember, password, nama;
    double pengeluaran=0;
    cMember(String id, String p, String n){
        idMember=id; password=p; nama=n;
    }
    
    void setPassword(String pw){
        password=pw;
    }
    void addPengeluaran (double p){
        pengeluaran=p+pengeluaran;
    }
    
}
