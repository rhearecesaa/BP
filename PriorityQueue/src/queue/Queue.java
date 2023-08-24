package queue;
public class Queue {
    Pembeli front, rear, sorted;
    int jumlah, maks;
    Queue(int m){
        maks=m;
        System.out.println("Antrian maksimal "+m+" dibuat...");
    }
    void enqueue(Pembeli baru){//tambah belakang
        if(jumlah<maks){
            if(front==null){ //antrian kosong
                front=rear=baru;
            }
            else{
                rear.next=baru;
                baru.prev=rear;
                rear=baru;
            }
            jumlah++;
            sort();
        }
        else{
            System.out.println("Antrian penuh!");
        }
    }
    String dequeue(){//hapus depan
        String nm="";
        if(jumlah>0){
            nm=front.nama;
            if(front.next==null){//1 doang
                front=rear=null;
            }
            else{
                front=front.next;
                front.prev=null;
            }
            jumlah--;
        }
        else{
            System.out.println("Antrian Kosong!");
        }
        return nm;
    }
    
    void view(){
        if(front!=null){
            System.out.println("Jumlah antrian: "+jumlah);
            System.out.println("Antrian : ");
            for(Pembeli i = front; i!=null; i=i.next){
                System.out.println("- "+i.nama+" ["+i.val+"]");
            }
        }
        else{
            System.out.println("Antrian Kosong!");
        }
    }
    
    void sort(){
        Pembeli current = front, index=null, temp;
        int tempval;
        String tempname;
        
        while(current!=null){
            index = current.next;
            while(index!=null){
                if(current.val<index.val){
                    tempname = current.nama;
                    tempval = current.val;
                    current.nama = index.nama;
                    current.val = index.val;
                    index.nama=tempname;
                    index.val=tempval;
                     
                }
                index=index.next;
            }
            current=current.next;
        }
    }
}
