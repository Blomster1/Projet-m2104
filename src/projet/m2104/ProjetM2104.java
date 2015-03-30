/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.m2104;

import java.util.Scanner;

/**
 *
 * @author yevic
 */
public class ProjetM2104 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FFCAM ffcam1 = new FFCAM();
        
        int choix;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ajouté un CAF - 1");
        choix = sc.nextInt();
        
        if(choix==1){
            ffcam1.nouveauCAF();
        }
        
        
        
    }
    
}
