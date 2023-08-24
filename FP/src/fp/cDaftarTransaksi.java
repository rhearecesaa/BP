package fp;
public class cDaftarTransaksi {
    cTransaksi front, rear;
    cDaftarTransaksi(){
        front=rear=null;
    }
    //olah transaksi
    void tambahTransaksi(cTransaksi t){
        if(front == null){ //=>list kosong
            front=rear=t;
        }
        else{
            rear.next=t;
            t.prev=rear;
            rear=t;
        }
        System.out.println("Penambahan transaksi sukses");
    }
    void hapusTransaksi(int x){
        if(rear==null){
            System.out.println("Daftar Transaksi Kosong!");
        }
        else{
            cTransaksi temp=front;
            cTransaksi prev=null;
            int i=1;
            if(x==1){ //hapus terdepan
                if(temp.next==null){
                    front=rear=null;
                }
                else{
                    front=front.next;
                    temp.next=null;
                }
            }
            else{
                for (; temp!=null;temp=temp.next){
                    if(i==x){
                        break;
                    }
                    i++;
                    prev=temp;
                }
                if(temp.next==null){
                    rear=prev;
                    rear.next=null;
                }
                else{
                    prev.next=temp.next;
                    temp.next=null;
                }
            }
            System.out.println("["+temp.getBarang().getNama()+"] dihapus..");
        }
    }
    void lihatTransaksi(int x){
        System.out.println("Daftar Transaksi: ");
        int i=1;
        if(front!=null){
            switch(x){
                case 1: //transaksi pembeli
                    double total1=0;
                    for(cTransaksi t=front; t!=null; t=t.next){
                        System.out.print(i+".");
                        System.out.print(t.getBarang().getNama()+" [ ");
                        System.out.println(t.getJumlah()+"x ]");
                        total1=total1+(t.getBarang().getHarga()*t.getJumlah());
                        i++;
                    }
                    System.out.println("\nTotal Belanja : "+total1);
                    break;
                case 2: //transaksi member
                    double total2=0,diskon;
                    for(cTransaksi t=front; t!=null; t=t.next){
                        System.out.print(i+".");
                        System.out.print(t.getBarang().getNama()+"-");
                        System.out.println(t.getJumlah()+"x");
                        i++;
                        total2=total2+(t.getBarang().getHarga()*t.getJumlah());
                    }
                    System.out.println("Total Belanja : "+total2);
                    System.out.println("Diskon        : "+(0.05*total2));
                    System.out.println("Total Bayar   : "+(total2-(0.05*total2)));
                            System.out.println();
                    break;
                case 3: //transaksi toko
                    for(cTransaksi t=front; t!=null; t=t.next){
                        System.out.print(i+".");
                        System.out.print(t.getKode()+"-");
                        System.out.print(t.getPembeli()+"-");
                        System.out.print(t.getBarang().getNama()+"-");
                        System.out.print(t.getJumlah()+"-");
                        System.out.println(t.getStatus());
                        i++;
                    }
                    break;
            }
        }
        else{
            System.out.println("Daftar Transaksi Kosong");
        }
    }
    void lihatBelumDiproses(){
        cTransaksi t=front;
        if(t!=null){
            int i=1;
            for(;t!=null;t=t.next){
                if(t.getStatus()==0){
                    System.out.print(i+".");
                    System.out.print(t.getKode()+"-");
                    System.out.print(t.getPembeli()+"-");
                    System.out.print(t.getBarang().getNama()+"-");
                    System.out.print(t.getJumlah()+"-");
                    System.out.println(t.getStatus());
                    i++;
                }
            }
        }
        else {
            System.out.println("Daftar Transaksi Kosong!");
        }
    }
    void sambungTransaksi(cTransaksi depan, cTransaksi belakang){
        if(front==null){
            front = depan;
            rear = belakang;
        }
        else{
            rear.next = depan;
            rear=belakang;
        }
        
    }
    void prosesTransaksi(cTransaksi t){
        t.setStatus(1);
    }
    cTransaksi getFront(){
        return front;
    }
    cTransaksi getRear(){
        return rear;
    }
    public int hitungDiproses(){
        cTransaksi t=front;
        int proses=0;
        for(;t!=null;t=t.next){
            if(t.getStatus()==1){
                proses++;
            }
        }
        return proses;
    }
    public int hitungBlmDiproses(){
        cTransaksi t=front;
        int proses=0;
        for(;t!=null;t=t.next){
            if(t.getStatus()==0){
                proses++;
            }
        }
        return proses;
    }
    public double lihatPemasukan(int x){
        cTransaksi t=front;
        double nominal=0;
        switch(x){
            case 1:
                for(;t!=null;t=t.next){
                    if(t.getStatus()==1){
                        nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
                        //cek member
                        if(t.getKode().equalsIgnoreCase("00")){
                            nominal=nominal-(0.05*nominal); //nbuat dari member
                        }
                    }
                }
                break;
            case 0:
                for(;t!=null;t=t.next){
                    if(t.getStatus()==0){
                        nominal=nominal+t.getBarang().getHarga()*t.getJumlah();
                        //cek member
                        if(t.getPembeli().equalsIgnoreCase("001")||t.getPembeli().equalsIgnoreCase("002")||t.getPembeli().equalsIgnoreCase("003")){
                            nominal=nominal-(0.05*nominal);
                        }
                    }
                }
                break;
        }
        return nominal;
    }
}
