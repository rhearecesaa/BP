/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.pkgif;

import java.util.Scanner;

/**
 *
 * @author RAHAYU KARTIKA SARI
 */
public class no2 {
    public static void main(String[] args) {
        System.out.println("MENGHITUNG TARIF PARKIR");
        Scanner scan = new Scanner(System.in);
        System.out.println("(mobil = 1, motor = 2; truck = 3)");
        System.out.print("case:  ");
        int jenis = scan.nextInt();   
        switch(jenis){ 
       
//tarif mobil
        case 1:
        System.out.print("Masukkan lama mobil parkir:  ");
        int jamMobil = scan.nextInt();
        
        if(jamMobil>1){
        float tarifMobil = jamMobil*4000;
        System.out.println("Tarif Parkir Mobil = Rp " + tarifMobil); 
        }
        
        else{
        float tarifMobil = jamMobil*5000;
        System.out.println("Tarif Parkir Mobil = Rp " + tarifMobil); 
        } 
        
        break;
        
//tarif motor
        case 2:        
        System.out.print("Masukkan lama motor parkir:  ");
        int jamMotor = scan.nextInt();
        
        float tarifMotor = jamMotor*2000;
        System.out.println("Tarif Parkir Motor = Rp " + tarifMotor);
            break;    
        
        
//tarif truck     

        case 3 :
        System.out.print("Masukkan lama truck parkir:  ");
        int jamTruck = scan.nextInt();
   
        if(jamTruck>1){
            float tarifTruck = jamTruck*4000;
            System.out.println("Tarif Parkir Truck = Rp " + tarifTruck); 
        }
        
        else{
            float tarifTruck = jamTruck*7000;
            System.out.println("Tarif Parkir Truck = Rp " + tarifTruck); 
    }
        break;
    }
    }       
}
