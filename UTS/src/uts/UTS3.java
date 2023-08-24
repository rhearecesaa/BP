/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts;

/**
 *
 * @author RAHAYU KARTIKA SARI
 */
import java.util.Scanner;
public class UTS3 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int ulang;
        
        do{
        //user input
        System.out.print("Masukkan jumlah bulan/periode: ");
        int periode = input.nextInt();
        
        //Data penjualan
        int penjualan[]= new int[periode];
        for (int i=0; i<=(periode-1); i++){
            System.out.print("Data penjualan bulan ke-"+ (i+1) + ": ");
            penjualan[i] = input.nextInt();
        }
        System.out.println();
        for (int i=0; i<=(periode-1); i++){
            System.out.println("Data penjualan bulan ke-"+ (i+1) + ": " + penjualan[i]);
        }
        System.out.println();
        
        if(periode>4){
        //peramalan 2 bulan
        int ramal=periode+1;
        System.out.println("Peramalan Orde 2 Bulan");
        int[] ramalan2;
        float[] rd2;
        ramalan2= new int[ramal];
        rd2 = new float[ramal];
        float jumlah_rd2=0;
        
        for (int j=2; j<periode; j++){
            ramalan2[j]=(penjualan[j-2]+penjualan[j-1])/2;
            
            float selisih=Math.abs(penjualan[j]-ramalan2[j]);
            rd2[j]=selisih/penjualan[j]*100;
            
            System.out.println("Data Bulan ke-"+(j+1)+" |Unit terjual = "+ penjualan [j]+"| Data peramalan = " + ramalan2[j]+"| Relative Devation = " +rd2[j]+"%");
            
            jumlah_rd2 = jumlah_rd2+rd2[j];
        }
            System.out.println();
        
        //peramalan 3 bulan
        System.out.println("Peramalan Orde 3 Bulan");
        int[] ramalan3;
        float[] rd3;
        ramalan3= new int[ramal];
        rd3 = new float[ramal];
        float jumlah_rd3=0;
        
        for (int k=3; k<periode; k++){
            ramalan3[k]=(penjualan[k-3]+penjualan[k-2]+penjualan[k-1])/3;
            
            float selisih=Math.abs(penjualan[k]-ramalan3[k]);
            rd3[k]=selisih/penjualan[k]*100;
            System.out.println("Data Bulan ke-"+(k+1)+"| Unit terjual = "+ penjualan [k]+"| Data peramalan = " + ramalan3[k]+"| Relative Devation = " +rd3[k]+"%");
            jumlah_rd3 = jumlah_rd3+rd3[k];
        }
        System.out.println();
        
        //peramalan 4 bulan
        System.out.println("Peramalan Orde 4 Bulan");
        int[] ramalan4;
        float[] rd4;
        ramalan4= new int[ramal];
        rd4 = new float[ramal];
        float jumlah_rd4=0;
        
        for (int l=4; l<periode; l++){
            ramalan4[l]=(penjualan[l-4]+penjualan[l-3]+penjualan[l-2]+penjualan[l-1])/4;
            
            float selisih=Math.abs(penjualan[l]-ramalan4[l]);
            rd4[l]=selisih/penjualan[l]*100;
            
            System.out.print("Data Bulan ke-"+(l+1));
            System.out.print("| Unit terjual = " + penjualan[l]);
            System.out.println("| Data peramalan = " + ramalan4[l]+"| Relative Devation = " + rd4[l] +"%");
            jumlah_rd4 = jumlah_rd4+rd4[l];
        }
        System.out.println();
        
        //ramalan       
        System.out.println("Perkiraan jumlah penjualan bulan ke-" + ramal);
        System.out.println("Orde Bulan 2");
        ramalan2[periode]= (penjualan[periode-2]+penjualan[periode-1])/2;
        rd2[periode] = jumlah_rd2/(periode-2);
        System.out.println("Data Bulan ke-"+ramal+"| Data peramalan = " + ramalan2[periode]+"| Relative Devation = " +rd2[periode]+"%");
        
        System.out.println("Orde Bulan 3");
        ramalan3[periode]= (penjualan[periode-3]+penjualan[periode-2]+penjualan[periode-1])/3;
        rd3[periode] = jumlah_rd3/(periode-3);
        System.out.println("Data Bulan ke-"+(periode+1)+"| Data peramalan = " + ramalan3[periode]+"| Relative Devation = " +rd3[periode]+"%");
        
        System.out.println("Orde Bulan 4");
        ramalan4[periode]= (penjualan[periode-4]+penjualan[periode-3]+penjualan[periode-2]+penjualan[periode-1])/4;
        rd4[periode] = jumlah_rd4/(periode-4);
        System.out.println("Data Bulan ke-"+(periode+1)+"| Data peramalan = " + ramalan4[periode]+"| Relative Devation = " +rd4[periode]+"%");
        
        //perbandingan relative deviation 4 bulan lebih
        if (rd2[periode]<rd3[periode] && rd2[periode]<rd4[periode]){
            System.out.println("Berdasarkan nilai relative deviation terkecil  yaitu pada orde bulan 2 sebesar "+rd2[periode]+"%");
            System.out.println("dipilih data peramalan orde 2 bulan yakni diperkirakan terjual "+ramalan2[periode]+" unit");
        }
        else if (rd3[periode]<rd2[periode] && rd3[periode]<rd4[periode]){
            System.out.println("Berdasarkan nilai relative deviation terkecil  yaitu pada orde bulan 3 sebesar "+rd3[periode]+"%");
            System.out.println("dipilih data peramalan orde 3 bulan yakni diperkirakan terjual "+ramalan3[periode]+" unit");
        }
        else if (rd4[periode]<rd3[periode] && rd4[periode]<rd2[periode]){
            System.out.println("Berdasarkan nilai relative deviation terkecil  yaitu pada orde bulan 4 sebesar "+rd4[periode]+"%");
            System.out.println("dipilih data peramalan orde 4 bulan yakni diperkirakan terjual "+ramalan4[periode]+" unit");
        }
        System.out.println();
        }
        
//periode == 4 bulan
        else if(periode==4){
            
        //peramalan 2 bulan
        int ramal=periode+1;
        System.out.println("Peramalan Orde 2 Bulan");
        int[] ramalan2;
        float[] rd2;
        ramalan2= new int[ramal];
        rd2 = new float[ramal];
        float jumlah_rd2=0;
        
        for (int j=2; j<periode; j++){
            ramalan2[j]=(penjualan[j-2]+penjualan[j-1])/2;
            float selisih=Math.abs(penjualan[j]-ramalan2[j]);
            rd2[j]=selisih/penjualan[j]*100;
            System.out.println("Data Bulan ke-"+(j+1)+" |Unit terjual = "+ penjualan [j]+"| Data peramalan = " + ramalan2[j]+"| Relative Devation = " +rd2[j]+"%");
            jumlah_rd2 = jumlah_rd2+rd2[j];
        }
            System.out.println();
        
        //peramalan 3 bulan
        System.out.println("Peramalan Orde 3 Bulan");
        int[] ramalan3;
        float[] rd3;
        ramalan3= new int[ramal];
        rd3 = new float[ramal];
        float jumlah_rd3=0;
        
        for (int k=3; k<periode; k++){
            ramalan3[k]=(penjualan[k-3]+penjualan[k-2]+penjualan[k-1])/3;
            
            float selisih=Math.abs(penjualan[k]-ramalan3[k]);
            rd3[k]=selisih/penjualan[k]*100;
            System.out.println("Data Bulan ke-"+(k+1)+"| Unit terjual = "+ penjualan [k]+"| Data peramalan = " + ramalan3[k]+"| Relative Devation = " +rd3[k]+"%");
            jumlah_rd3 = jumlah_rd3+rd3[k];
        }
        System.out.println();
        //peramalan 4 bulan
            System.out.println("Peramalan Orde 4 Bulan");
            int ramalan4=(penjualan[0]+penjualan[1]+penjualan[2]+penjualan[3])/4;
            System.out.println("Data peramalan = " +ramalan4);
        //ramalan
        System.out.println("Perkiraan jumlah penjualan bulan ke-" + ramal);
        System.out.println("Orde Bulan 2");
        ramalan2[periode]= (penjualan[periode-2]+penjualan[periode-1])/2;
        rd2[periode] = jumlah_rd2/(periode-2);
        System.out.println("Data Bulan ke-"+ramal+"| Data peramalan = " + ramalan2[periode]+"| Relative Devation = " +rd2[periode]+"%");
        
        System.out.println("Orde Bulan 3");
        ramalan3[periode]= (penjualan[periode-3]+penjualan[periode-2]+penjualan[periode-1])/3;
        rd3[periode] = jumlah_rd3/(periode-3);
        System.out.println("Data Bulan ke-"+(periode+1)+"| Data peramalan = " + ramalan3[periode]+"| Relative Devation = " +rd3[periode]+"%");
        //perbandingan relative deviation 3 bulan
        if (rd2[periode]<rd3[periode]){
            System.out.println("Berdasarkan nilai relative deviation terkecil  yaitu pada orde bulan 2 sebesar "+rd2[periode]+"%");
            System.out.println("dipilih data peramalan orde 2 bulan yakni diperkirakan terjual "+ramalan2[periode]+" unit");
        }
        else if (rd3[periode]<rd2[periode]){
            System.out.println("Berdasarkan nilai relative deviation terkecil  yaitu pada orde bulan 3 sebesar "+rd3[periode]+"%");
            System.out.println("dipilih data peramalan orde 3 bulan yakni diperkirakan terjual "+ramalan3[periode]+" unit");
        }
        System.out.println();
        }
        
        else if (periode==3){
        //peramalan 2 bulan
        int ramal=periode+1;
        System.out.println("Peramalan Orde 2 Bulan");
        int[] ramalan2;
        float[] rd2;
        ramalan2= new int[ramal];
        rd2 = new float[ramal];
        float jumlah_rd2=0;
        
        for (int j=2; j<periode; j++){
            ramalan2[j]=(penjualan[j-2]+penjualan[j-1])/2;
            
            float selisih=Math.abs(penjualan[j]-ramalan2[j]);
            rd2[j]=selisih/penjualan[j]*100;
            
            System.out.println("Data Bulan ke-"+(j+1)+" |Unit terjual = "+ penjualan [j]+"| Data peramalan = " + ramalan2[j]+"| Relative Devation = " +rd2[j]+"%");
            
            jumlah_rd2 = jumlah_rd2+rd2[j];
        }
            System.out.println();
            //ramalan
            System.out.println("Perkiraan jumlah penjualan bulan ke-" + ramal);
            System.out.println("Orde Bulan 2");
            ramalan2[periode]= (penjualan[periode-2]+penjualan[periode-1])/2;
            rd2[periode] = jumlah_rd2/(periode-2);
            System.out.println("Data Bulan ke-"+ramal+"| Data peramalan = " + ramalan2[periode]+"| Relative Devation = " +rd2[periode]+"%");    
            
        }
        else{
            
        }
        
        //ulang
        System.out.print("Apakah ingin mengulang program? (1/0)");
        ulang = input.nextInt();
        
        System.out.println();
        }
        while(ulang==1);
        
        System.out.println("Terimakasih");
    }
    
}
