/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author RAHAYU KARTIKA SARI
 */
public class No4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int pertaliteAwal = 7650;
        int pertaliteAkhir = 10000;
        int pertamaxAwal = 12500;
        int pertamaxAkhir = 14500;
        
        float selisihHargaPertalite = pertaliteAkhir - pertaliteAwal;
        float selisihHargaPertamax = pertamaxAkhir - pertamaxAwal;
        float pPertalite = selisihHargaPertalite / pertaliteAwal;
        float pPertamax = selisihHargaPertamax / pertamaxAwal;
        
        boolean selisih = selisihHargaPertalite > selisihHargaPertamax;
        
        System.out.println ("selisih harga pertalite = " + selisihHargaPertalite);
        System.out.println ("selisih harga pertamax = " + selisihHargaPertamax);
        System.out.println ("prosentase kenaikan harga pertalite = " + (pPertalite * 100) + "%");
        System.out.println ("prosentase kenaikan harga pertamax = " + (pPertamax * 100) + "%");
        System.out.println ("apakah kenaikan harga pertalite lebih tinggi? " + selisih);
    }
}