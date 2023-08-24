/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author RAHAYU KARTIKA SARI
 */
public class No3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int uts = 78;
        int uas = 87;
        int tugas = 90;
        System.out.println("total nilai uts uas tugas = " + (uts + uas + tugas));
        
        float rataRata = ((uts + uas + tugas) / 3);
        System.out.println("rata-rata nilai uts uas tugas = " + rataRata);
        
        float nilai = (uts*3/10)+(uas*4/10)+(tugas*3/10);
        System.out.println("rata-rata nilai = "+ nilai);
    }
}
